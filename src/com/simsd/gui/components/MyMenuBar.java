package com.simsd.gui.components;

import com.simsd.gui.*;
import com.simsd.gui.controllers.*;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private MainWindow mainWindow;
    MenuCtrlr menuCtrlr;

    private JMenuItem addSupplierItem;
    private JMenuItem listSupplierItem;
    private JMenuItem addStoreItem;
    private JMenuItem listStoreItem;
    private JMenuItem addSplr;
    private JMenuItem listSplr;
    private JMenuItem report;
	
	public static void main() {
		//
	}
	
	public MyMenuBar(MainWindow mw) {
		this.mainWindow = mw;
        
        // Create menus
        JMenu menuItem = new JMenu("Item");
        JMenu menuSupplier = new JMenu("Supplier");
        //JMenu menuReport = new JMenu("Report");
        report = new JMenuItem("Report");

        // Add menus to the menu bar
        this.add(menuItem);
        this.add(menuSupplier);
        this.add(report);

        // Add sub-menu items to "Item" menu
        JMenu fromSupplier = new JMenu("From Supplier");
        JMenu storeProduce = new JMenu("Store Produce");
        menuItem.add(fromSupplier);
        menuItem.add(storeProduce);

        addSupplierItem = new JMenuItem("Add Item");
        listSupplierItem = new JMenuItem("List All");
        fromSupplier.add(addSupplierItem);
        fromSupplier.add(listSupplierItem);
        addStoreItem = new JMenuItem("Add Item");
        listStoreItem = new JMenuItem("List All");
        storeProduce.add(addStoreItem);
        storeProduce.add(listStoreItem);

        addSplr = new JMenuItem("Add Supplier");
        listSplr = new JMenuItem("List All");
        menuSupplier.add(addSplr);
        menuSupplier.add(listSplr);
        
        //report = new JMenuItem("Items");
        //menuReport.add(report);

        //Set a MenuController for the menu bar
        //to handle menu actions
        menuCtrlr = new MenuCtrlr(this);
	}

    public MainWindow getMainWindow() {
        return mainWindow;
    }
    public JMenuItem getAddSupplierItem() {
        return addSupplierItem;
    }
    public JMenuItem getListSupplierItem() {
        return listSupplierItem;
    }
    public JMenuItem getAddStoreItem() {
        return addStoreItem;
    }
    public JMenuItem getListStoreItem() {
        return listStoreItem;
    }
    public JMenuItem getAddSplr() {
        return addSplr;
    }
    public JMenuItem getListSplr() {
        return listSplr;
    }
    public JMenuItem getReport() {
        return report;
    }

}
