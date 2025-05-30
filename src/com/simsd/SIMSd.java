package com.simsd;
import com.simsd.gui.*;
import com.simsd.config.Config;
import java.io.File;
import java.time.LocalDate;

public class SIMSd {

    SupplierList SupplierList = new SupplierList();
    ItemList<ItemFromSupplier> IFSList = new ItemList<ItemFromSupplier>();
    ItemList<ItemProducedInStore> IPSList = new ItemList<ItemProducedInStore>();

    /**
     * Main method to run the SIMSd application.
     * It initializes the data and performs actions based on user input.
     * 
     * @param args command line arguments (not used).
     */

    public static void main(String[] args) {
        SIMSd app = new SIMSd();
        //app.initData(); // Initialize data
        MainWindow mainWindow = app.initMainWindow(); // Initialize GUI
        mainWindow.setVisible(true); // Show the GUI
        
    }

    /**
     * Initializes the MainWindow GUI for the application.
     */
    private MainWindow initMainWindow() {
        return  MainWindow.getInstance();
    }

    /**
     * Initializes the data for the Console application.
     * It sets up file operations for suppliers and items, and performs actions based on user input.
     */
    private void initData() {
        // Initialize data here
        
        SupplierList.setFileOpr(new FileOpr<Supplier>(new File(Config.PATH_SUPPLIERS_FILE), Supplier.class));

        int act = 1; // 0 for save, 1 for open

        if (act == 0) {
            Supplier splr = new Supplier("Supplier1");
            splr.setDescription("Supplier1 description here");
            SupplierList.add(splr);
            splr = new Supplier("Spp2");
            splr.setDescription("Supplier2 description here");
            SupplierList.add(splr);
            SupplierList.save();
        } else if (act == 1) {
            SupplierList.open();
            // if (SupplierList.size() > 0) {
            //     Supplier splr = SupplierList.get(0);
            //     System.out.println(splr.getID() + " " + splr.getName() + " " + splr.getDescription());
            // } else {
            //     System.out.println("No suppliers found.");
            // }
        }

        IFSList.setFileOpr(new FileOpr<ItemFromSupplier>(new File(Config.PATH_IFS_FILE), ItemFromSupplier.class));
        act = 1; // 0 for save, 1 for open
        if(act==0){
            IFSList.add(new ItemFromSupplier("Item_Name1", "What are you my darling", 12.99f, SupplierList.get(0).getID()));
            IFSList.add(new ItemFromSupplier("Item_Name2", "What are you my darling", 12.99f, SupplierList.get(0).getID()));
            IFSList.save();
        }else if(act==1){
            IFSList.open();
            // if (IFSList.size() > 0) {
            //     ItemFromSupplier item = IFSList.get(0);
            //     System.out.println(item.getID() + " " + item.getDescription() + " " + item.getPricePerUnit());
            // } else {
            //     System.out.println("No items found.");
            // }
        }

        IPSList.setFileOpr(new FileOpr<ItemProducedInStore>(new File(Config.PATH_IPS_FILE), ItemProducedInStore.class));
        act = 1;
        if(act==0){
            IPSList.add(new ItemProducedInStore("Item_Name1", "What are you my darling", 12.99f, LocalDate.parse("2023-03-01")));
            IPSList.add(new ItemProducedInStore("Item_Name2", "What are you my darling", 12.99f, LocalDate.parse("2023-03-02")));
            IPSList.save();
        }else if(act==1){
            IPSList.open();
            // if (IPSList.size() > 0) {
            //     ItemProducedInStore item = IPSList.get(0);
            //     System.out.println(item.getID() + " " + item.getDescription() + " " + item.getPricePerUnit());
            // } else {
            //     System.out.println("No items found.");
            // }
        }
    }
}
