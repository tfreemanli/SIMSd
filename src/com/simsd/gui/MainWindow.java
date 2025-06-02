package com.simsd.gui;

import com.simsd.FileOpr;
import com.simsd.ItemFromSupplier;
import com.simsd.ItemList;
import com.simsd.ItemProducedInStore;
import com.simsd.Supplier;
import com.simsd.SupplierList;
import com.simsd.config.Config;
import com.simsd.gui.components.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
//import java.time.LocalDate; 

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private static MainWindow instance = null;
    
    public SupplierList supplierList = new SupplierList();
    public ItemList<ItemFromSupplier> IFSList = new ItemList<ItemFromSupplier>();
    public ItemList<ItemProducedInStore> IPSList = new ItemList<ItemProducedInStore>();

    public JPanel mainPanel; // Main panel to contain all pages
    public SupplierListPanel supplierListPage;
    public SupplierDetailPanel supplierDetailPage;
    public SupplierCreatePanel supplierCreatePage;
    public IFSListPanel ifsListPage;
    public IFSCreatePanel ifsCreatePage;
    public IFSDetailPanel ifsDetailPage;
    public IPSListPanel ipsListPage;
    public IPSCreatePanel ipsCreatePage;
    public IPSDetailPanel ipsDetailPage;
    public ReportPanel reportPage;
    
    public CardLayout cardLayout;

    public final static String INDEX_VIEW = "IndexView";
    public final static String SUPPLIER_LIST_VIEW = "SupplierListView";
    public final static String SUPPLIER_DETAIL_VIEW = "SupplierDetailView";
    public final static String SUPPLIER_CREATE_VIEW = "SupplierCreateView";
    public final static String IFS_LIST_VIEW = "IFSListView";
    public final static String IFS_DETAIL_VIEW = "IFSDetailView";
    public final static String IFS_CREATE_VIEW = "IFSCreateView";
    public final static String IPS_LIST_VIEW = "IPSListView";
    public final static String IPS_DETAIL_VIEW = "IPSDetailView";
    public final static String IPS_CREATE_VIEW = "IPSCreateView";
    public final static String REPORT_VIEW = "ReportView";

    public static MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
        }
        return instance;
    }

    private MainWindow() {
    	this.initData();
        setTitle("SIMSd Inventory Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the window on the screen

        MyMenuBar menuBar = new MyMenuBar(this);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Add a main panel
//        mainPanel = new JPanel();
//        mainPanel.add(new JLabel("Main Panel"));
//        mainPanel.setLayout(new BorderLayout());
//        add(mainPanel, BorderLayout.CENTER);

        // Create pages
        createPages();

    }

    private void createPages() {
        // Create pages here if needed

        ipsListPage = new IPSListPanel(this);
        ipsDetailPage = new IPSDetailPanel(this);
        ipsCreatePage = new IPSCreatePanel(this);
        
        ifsListPage = new IFSListPanel(this);
        ifsCreatePage = new IFSCreatePanel(this);
        ifsDetailPage = new IFSDetailPanel(this);

        supplierListPage = new SupplierListPanel(this);
        supplierDetailPage = new SupplierDetailPanel(this);
        supplierCreatePage = new SupplierCreatePanel(this);
        
        reportPage = new ReportPanel(this);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        mainPanel.add(new JPanel(), INDEX_VIEW);
        mainPanel.add(supplierListPage, SUPPLIER_LIST_VIEW);
        mainPanel.add(supplierDetailPage, SUPPLIER_DETAIL_VIEW);
        mainPanel.add(supplierCreatePage, SUPPLIER_CREATE_VIEW);
        mainPanel.add(ifsListPage, IFS_LIST_VIEW);
        mainPanel.add(ifsDetailPage, IFS_DETAIL_VIEW);
        mainPanel.add(ifsCreatePage, IFS_CREATE_VIEW);
        mainPanel.add(ipsListPage, IPS_LIST_VIEW);
        mainPanel.add(ipsDetailPage, IPS_DETAIL_VIEW);
        mainPanel.add(ipsCreatePage, IPS_CREATE_VIEW);
        mainPanel.add(reportPage, REPORT_VIEW);
        
        this.add(mainPanel);
    }

    public void switchToPage(String toView) {
//        mainPanel.removeAll(); // Clear the main panel
//        mainPanel.add(page, BorderLayout.CENTER); // Add the new page
//        mainPanel.revalidate(); // Refresh the panel
//        mainPanel.repaint(); // Repaint the panel
        this.cardLayout.show(mainPanel, toView);
    }

    /**
     * Initializes the data for the application.
     * It sets up file operations for suppliers and items, and performs actions based on user input.
     */
    private void initData() {
        // Initialize data here
        
        supplierList.setFileOpr(new FileOpr<Supplier>(new File(Config.PATH_SUPPLIERS_FILE), Supplier.class));
        supplierList.open();

//        int act = 1; // 0 for save, 1 for open
//
//        if (act == 0) {
//            Supplier splr = new Supplier("Supplier1");
//            splr.setDescription("Supplier1 description here");
//            supplierList.add(splr);
//            splr = new Supplier("Spp2");
//            splr.setDescription("Supplier2 description here");
//            supplierList.add(splr);
//            supplierList.save();
//        } else if (act == 1) {
//            supplierList.open();
//            // if (SupplierList.size() > 0) {
//            //     Supplier splr = SupplierList.get(0);
//            //     System.out.println(splr.getID() + " " + splr.getName() + " " + splr.getDescription());
//            // } else {
//            //     System.out.println("No suppliers found.");
//            // }
//        }

        IFSList.setFileOpr(new FileOpr<ItemFromSupplier>(new File(Config.PATH_IFS_FILE), ItemFromSupplier.class));
        IFSList.open();
        
//        act = 1; // 0 for save, 1 for open
//        if(act==0){
//            IFSList.add(new ItemFromSupplier("Item_Name1", "What are you my darling", 12.99f, supplierList.get(0).getID()));
//            IFSList.add(new ItemFromSupplier("Item_Name2", "What are you my darling", 12.99f, supplierList.get(0).getID()));
//            IFSList.save();
//        }else if(act==1){
//            IFSList.open();
//            // if (IFSList.size() > 0) {
//            //     ItemFromSupplier item = IFSList.get(0);
//            //     System.out.println(item.getID() + " " + item.getDescription() + " " + item.getPricePerUnit());
//            // } else {
//            //     System.out.println("No items found.");
//            // }
//        }

        IPSList.setFileOpr(new FileOpr<ItemProducedInStore>(new File(Config.PATH_IPS_FILE), ItemProducedInStore.class));
        IPSList.open();
        
//        act = 1;
//        if(act==0){
//            IPSList.add(new ItemProducedInStore("Item_Name1", "What are you my darling", 12.99f, LocalDate.parse("2023-03-01")));
//            IPSList.add(new ItemProducedInStore("Item_Name2", "What are you my darling", 12.99f, LocalDate.parse("2023-03-02")));
//            IPSList.save();
//        }else if(act==1){
//            IPSList.open();
//            // if (IPSList.size() > 0) {
//            //     ItemProducedInStore item = IPSList.get(0);
//            //     System.out.println(item.getID() + " " + item.getDescription() + " " + item.getPricePerUnit());
//            // } else {
//            //     System.out.println("No items found.");
//            // }
//        }
    }
}
