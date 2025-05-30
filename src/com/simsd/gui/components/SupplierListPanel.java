package com.simsd.gui.components;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JLabel;

import com.simsd.Supplier;
import com.simsd.SupplierList;
import com.simsd.gui.MainWindow;

public class SupplierListPanel extends JPanel{
    private static final long serialVersionUID = 1L;
    private MainWindow mainWindow;
    private JTable table;
    private ItemTableModel tableModel;
	private JComboBox<String> schKey;
    private JTextField schValue;
    private SupplierList dataList;
    public SupplierList displayList;

    public SupplierListPanel(MainWindow mw) {
    	this.mainWindow = mw;
    	this.dataList = mw.supplierList;
    	
    	setLayout(new BorderLayout(5, 0));
    	
    	JPanel panel = new JPanel();
    	add(panel, BorderLayout.NORTH);
    	panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 15));
    	
    	JLabel lblNewLabel = new JLabel("Supplier Name:");
    	panel.add(lblNewLabel);
    	
    	String[] keyOption = new String[]{"Name", "Description"};
    	schKey = new JComboBox<>(keyOption);
    	panel.add(schKey);
    	
    	schValue = new JTextField();
    	schValue.setFont(new Font("Arial", Font.PLAIN, 12));
    	panel.add(schValue);
    	schValue.setColumns(10);
    	
    	JButton btnSearch = new JButton("Search");
    	btnSearch.addActionListener(_-> doSearch());
    	panel.add(btnSearch);
    	
    	JButton btnCreate = new JButton("Create");
    	btnCreate.addActionListener(_ -> this.mainWindow.switchToPage(MainWindow.SUPPLIER_CREATE_VIEW));
    	panel.add(btnCreate);
    	
    	JButton btnReload = new JButton("ReLoad");
    	btnReload.addActionListener(_ -> reLoadTable());
    	panel.add(btnReload);
    	
//    	JButton btnRefresh = new JButton("Refresh");
//    	btnRefresh.addActionListener(_ -> refreshTable());
//    	panel.add(btnRefresh);
    	
    	//Search Bar End ======================Table Start
    	
    	this.displayList = this.dataList;
    	this.tableModel = new ItemTableModel(displayList);
    	table = new JTable(tableModel);
    	
    	table.getColumnModel().getColumn(0).setPreferredWidth(30);   // ID
    	table.getColumnModel().getColumn(1).setPreferredWidth(100);  // Name
    	table.getColumnModel().getColumn(2).setPreferredWidth(300);  // Description

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    int row = table.getSelectedRow();
                    Supplier supplier = tableModel.getData().get(row);
                    mainWindow.supplierDetailPage.setSupplier(supplier);
                    mainWindow.switchToPage(MainWindow.SUPPLIER_DETAIL_VIEW);
                }
            }
        });
        
    	add(new JScrollPane(table), BorderLayout.CENTER);
    	
    	//Table End=========== Bottom Start
//    	JPanel panel2 = new JPanel();
//    	add(panel2, BorderLayout.SOUTH);
//    	panel2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
//    	
//    	JButton btnSave = new JButton("Save");
//    	btnSave.addActionListener(_ -> saveTable());
//    	panel2.add(btnSave);
    	
    }
    
    
    private static class ItemTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		private final String[] columnNames = {"ID", "Supplier's Name", "Description"};
        private  SupplierList items;

        public ItemTableModel(SupplierList items) {
            this.items = items;
        }
        
        public void setData(SupplierList items) {
            this.items = items;
            fireTableDataChanged(); 
        }
        
        public SupplierList getData() {
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
        	Supplier item = items.get(rowIndex);
            return switch (columnIndex) {
	            case 0 -> item.getID();
	            case 1 -> item.getName();
	            case 2 -> item.getDescription();
	            default -> "";
            };	
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
    
    public void setDataList(SupplierList data) {
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
