package com.simsd;
import com.simsd.gui.*;
import com.simsd.config.Config;
import java.io.File;
import java.time.LocalDate;

public class SIMSd {

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
}
