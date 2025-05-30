package com.simsd.gui.components;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
//import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import com.simsd.ItemFromSupplier;
import com.simsd.ItemList;
import com.simsd.gui.MainWindow;

public class IFSListPanel extends JPanel{

    private static final long serialVersionUID = 1L;
    private MainWindow mainWindow;
    private JTable table;
    private ItemTableModel tableModel;
    private JComboBox<String> schKey;
    private JTextField schValue;
    private ItemList<ItemFromSupplier>  dataList;
    public ItemList<ItemFromSupplier> displayList;
    
    public IFSListPanel(MainWindow mw) {
    	this.mainWindow = mw;
    	this.dataList = mw.IFSList;
    	
    	setLayout(new BorderLayout(5, 0));
    	
    	JPanel panel = new JPanel();
    	add(panel, BorderLayout.NORTH);
    	panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 15));
    	
    	JLabel lblNewLabel = new JLabel("Item:");
    	panel.add(lblNewLabel);

    	String[] options = {"Name", "Description"};
    	schKey = new JComboBox<String>(options);
    	panel.add(schKey);
    	schValue = new JTextField();
    	panel.add(schValue);
    	schValue.setColumns(10);
    	
    	JButton btnSearch = new JButton("Search");
    	btnSearch.addActionListener(_-> doSearch());
    	panel.add(btnSearch);
    	
    	JButton btnCreate = new JButton("Create");
    	btnCreate.addActionListener(_ -> this.mainWindow.switchToPage(MainWindow.IFS_CREATE_VIEW));
    	panel.add(btnCreate);
    	
    	JButton btnRefresh = new JButton("Reload");
    	btnRefresh.addActionListener(_ -> reLoadTable());
    	panel.add(btnRefresh);
    	
    	//Search Bar End ======================Table Start
    	
    	
    	displayList = dataList;
    	this.tableModel = new ItemTableModel(displayList, mainWindow);
    	table = new JTable(tableModel);
    	
    	table.getColumnModel().getColumn(0).setPreferredWidth(50);   // Name
    	table.getColumnModel().getColumn(1).setPreferredWidth(100);  // Description
    	table.getColumnModel().getColumn(2).setPreferredWidth(50);  // Supplier
    	table.getColumnModel().getColumn(3).setPreferredWidth(50);  // ExpDate
    	table.getColumnModel().getColumn(4).setPreferredWidth(50);  // Price
    	table.getColumnModel().getColumn(5).setPreferredWidth(20);  // Unit
    	table.getColumnModel().getColumn(6).setPreferredWidth(50);  // Quantity

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    int row = table.getSelectedRow();
                    ItemFromSupplier item = tableModel.getData().get(row);
                    mainWindow.ifsDetailPage.setItem(item);
                    mainWindow.switchToPage(MainWindow.IFS_DETAIL_VIEW);
                }
            }
        });
        
    	add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
    private static class ItemTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		private final String[] columnNames = {"Item Name", "Description", "Supplier", "Expiry Date", "Price $", "Unit", "Quantity"};
        private ItemList<ItemFromSupplier> items;
        private MainWindow mainWindow;

        public ItemTableModel(ItemList<ItemFromSupplier> items, MainWindow mw) {
            this.items = items;
            this.mainWindow = mw;
        }
        
        public void setData(ItemList<ItemFromSupplier> list) {
        	this.items = list;
            fireTableDataChanged(); 
        }
        
        public ItemList<ItemFromSupplier> getData(){
        	return this.items;
        }

        @Override
        public int getRowCount() {
            return items.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
        	ItemFromSupplier item = items.get(rowIndex);
            return switch (columnIndex) {
	            case 0 -> item.getName();
	            case 1 -> item.getDescription();
	            case 2 -> mainWindow.supplierList.getBySupplierID(item.getSupplierID())==null?item.getSupplierID():mainWindow.supplierList.getBySupplierID(item.getSupplierID()).getName();
	            case 3 -> item.getExpDate()==null?"":item.getExpDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	            case 4 -> item.getPricePerUnit();
	            case 5 -> item.getUnit();
	            case 6 -> item.getQuantity();
	            default -> "";
            };	
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
    
    public void setDataList(ItemList<ItemFromSupplier> data) {
    	this.dataList = data;
    }
    
    public void reLoadTable() {
    	//System.out.println("Table refreshed.");
    	this.dataList.open();
    	displayList = dataList;
		this.tableModel.setData(displayList);
    }
    
    public void saveTable() {
    	this.dataList.save();
    }
    
    public void doSearch() {
    	String sKey = ""+ schKey.getSelectedItem();
    	String sValue = schValue.getText();
    	if(!sValue.equals("")) {
    		//doSearch
    		displayList = dataList.filter(sKey, sValue);
    		this.tableModel.setData(displayList);
    	}else {
    		this.tableModel.setData(dataList);
    		
    	}
    	
    }

}
