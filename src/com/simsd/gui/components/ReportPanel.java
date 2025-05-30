package com.simsd.gui.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import com.simsd.ItemFromSupplier;
import com.simsd.ItemList;
import com.simsd.ItemProducedInStore;
import com.simsd.SupplierList;
import com.simsd.Supplier;
import com.simsd.gui.MainWindow;

public class ReportPanel extends JPanel{

    private static final long serialVersionUID = 1L;
    private ItemList<ItemFromSupplier>  ifsList;
    private ItemList<ItemProducedInStore> ipsList;
    private SupplierList supplierList;
    JEditorPane editorPane;
    
    public ReportPanel(MainWindow mw) {
    	this.ifsList = mw.IFSList;
    	this.ipsList = mw.IPSList;
    	this.supplierList = mw.supplierList;
    	setLayout(new BorderLayout());
    	
    	editorPane = new JEditorPane();
    	editorPane.setContentType("text/html");
    	editorPane.setEditable(false);
    	LoadHTML(editorPane);
    	JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	
    	add(scrollPane, BorderLayout.CENTER);
    	
    	JPanel panel = new JPanel();
    	JButton btnButton = new JButton("Refresh");
    	btnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initData();
			}
		});
    	panel.add(btnButton);
    	add(panel, BorderLayout.SOUTH);
    }
    
    public void initData() {
    	LoadHTML(editorPane);
    }
    
    public void LoadHTML(JEditorPane pan) {
    	StringBuffer str = new StringBuffer();
    	str.append("<html><body style='padding:10px'>");
    	str.append("<h2>Items Produced In Store</h2>");
    	str.append("<hr>");
    	for (int i=0; i<ipsList.size();i++) {
			ItemProducedInStore item = ipsList.get(i);
			str.append("<p>");
			str.append("<b>Item Name:</b> "+ item.getName() +" &nbsp; ");
			str.append("<b>Item ID:</b> "+ item.getID() +"<br>");
			str.append("<b>Description:</b> "+ item.getDescription() +"<br>");
			str.append("<b>Price:</b> "+ item.getPricePerUnit() +" &nbsp; ");
			str.append("<b>Unit:</b> "+ item.getUnit() +" &nbsp; ");
			str.append("<b>Quantity:</b> "+ item.getQuantity() +"<br>");
			str.append("<b>Porduce Date:</b> "+ item.getProduceDate() +" &nbsp; ");
			str.append("<b>Sell By Date:</b> "+ item.getSellByDate() +"<br>");
			str.append("</p>");
		}
    	
    	str.append("<h2>Items From Supplier</h2>");
    	str.append("<hr>");
    	for (int i=0; i<ifsList.size();i++) {
			ItemFromSupplier item = ifsList.get(i);
			str.append("<p>");
			str.append("<b>Item Name:</b> "+ item.getName() +" &nbsp; ");
			str.append("<b>Item ID:</b> "+ item.getID() +"<br>");
			str.append("<b>Description:</b> "+ item.getDescription() +"<br>");
			str.append("<b>Price:</b> "+ item.getPricePerUnit() +" &nbsp; ");
			str.append("<b>Unit:</b> "+ item.getUnit() +" &nbsp; ");
			str.append("<b>Quantity:</b> "+ item.getQuantity() +"<br>");
			Long splrID = item.getSupplierID();
			String splrString = supplierList.getBySupplierID(splrID) == null?"<span color=red >Not Found</span>":supplierList.getBySupplierID(splrID).getName();
			str.append("<b>Supplier:</b> "+ splrID +" &nbsp; ");
			str.append("<b>Supplier:</b> "+ splrString +" &nbsp; ");
			str.append("<b>Sell By Date:</b> "+ item.getSellByDate() +"<br>");
			str.append("</p>");
		}
    	
    	str.append("<h2>Suppliers</h2>");
    	str.append("<hr>");
    	for (int i=0; i<supplierList.size();i++) {
			Supplier item = supplierList.get(i);
			str.append("<p>");
			str.append("<b>Supplier Name:</b> "+ item.getName() +" &nbsp; ");
			str.append("<b>Supplier ID:</b> "+ item.getID() +"<br>");
			str.append("<b>Description:</b> "+ item.getDescription() +"<br>");
			str.append("</p>");
		}
    	
    	str.append("</body></html>");
    	pan.setText(str.toString());    
    }
    

}
