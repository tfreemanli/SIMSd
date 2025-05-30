package com.simsd.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.simsd.gui.MainWindow;
import com.simsd.gui.components.MyMenuBar;

public class MenuCtrlr {
    private MainWindow mainWindow = null;

    public MenuCtrlr(MyMenuBar menuBar) {
        this.mainWindow = menuBar.getMainWindow();

        // Item - From Supplier - List All
        // Add action listeners to menu items
        menuBar.getListSupplierItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mainWindow.switchToPage(MainWindow.IFS_LIST_VIEW);
            }
        });
        
        //Item - From Supplier - Create
        menuBar.getAddSupplierItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mainWindow.switchToPage(MainWindow.IFS_CREATE_VIEW);
            }
        });

        // Item - Store Produce - List All
        menuBar.getListStoreItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mainWindow.switchToPage(MainWindow.IPS_LIST_VIEW);
            }
        });
        
        //Item - Store Produce - Create
        
        menuBar.getAddStoreItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mainWindow.switchToPage(MainWindow.IPS_CREATE_VIEW);
            }
        });

        // Supplier - List Supplier
        menuBar.getListSplr().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mainWindow.switchToPage(MainWindow.SUPPLIER_LIST_VIEW);
            }
        });

        // Supplier - List Supplier
        menuBar.getAddSplr().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mainWindow.switchToPage(MainWindow.SUPPLIER_CREATE_VIEW);
            }
        });
        
        //Report - show all the items
        menuBar.getReport().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainWindow.switchToPage(MainWindow.REPORT_VIEW);
			}
		});
    }
}
