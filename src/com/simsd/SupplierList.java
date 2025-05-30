package com.simsd;
import java.util.ArrayList;
import java.io.File;


public class SupplierList {
    private ArrayList<Supplier> arrSupplier = new ArrayList<Supplier>();
    private FileOpr<Supplier> fileOpr;

    // Default constructor
    public SupplierList(){
        //empty constructor allow to start with a empty Supplier list
        //need to setFileOpr(file) manually and save it without open() it.
    }
    
    // Constructor that takes a file as an argument
    // and initializes the supplier list from it.
    // This Constructor will read the file straight away
    // If don't want to read the file into ArrayList, use the default constructor
    // and set the fileOpr manually.
    public SupplierList(File file){
        if (file.exists()) {
            fileOpr = new FileOpr<Supplier>(file, Supplier.class);
            this.open();
        } else {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }
    
    public void setArrSupplier(ArrayList<Supplier> arr) {
    	this.arrSupplier = arr;
    }

    public void setFileOpr(FileOpr<Supplier> fileOpr) {
        this.fileOpr = fileOpr;
    }
    public FileOpr<Supplier> getFileOpr() {
        return fileOpr;
    }

    // Open JSON file to read suppliers from
    public void open(){
        if (fileOpr != null) {
            arrSupplier = fileOpr.open();
        } else {
            System.out.println("File operation object is not initialized.");
        }
    }

    // Save the supplier list to a file
    public void save() {
        if (fileOpr != null) {
            fileOpr.save(arrSupplier);
        } else {
            System.out.println("File operation object is not initialized.");
        }
    }

    //add Supplier to the list
    public void add(Supplier supplier) {
        arrSupplier.add(supplier);
    }

    //remove Supplier from the list by object or index
    public void remove(Supplier supplier) {
        arrSupplier.remove(supplier);
    }
    public void remove(int index) {
        arrSupplier.remove(index);
    }
    public void clear() {
        arrSupplier.clear();
    }

    //get Supplier by index
    public Supplier get(int i) {
        // Object obj = arrSupplier.get(index);
        // if (obj != null) {
        //     System.out.println("What I got is: " + obj.getClass()); // Return null if the index is out of bounds
        // }
        return arrSupplier.get(i);
    }

    //get Supplier by ID
    public Supplier getBySupplierID(long id) {
        for (Supplier supplier : arrSupplier) {
            if (supplier.getID()==id) {
                return supplier;
            }
        }
        return null; // Return null if not found
    }

    //get all Suppliers
    public ArrayList<Supplier> all() {
        return arrSupplier;
    }

    //get size of the list
    public int size() {
        return arrSupplier.size();
    }

    //filter suppliers by dictionary
    public SupplierList filter(String key, String value) {
        ArrayList<Supplier> filteredSuppliers = new ArrayList<Supplier>();
        for (Supplier supplier : arrSupplier) {
            if (key.equals("Name") && supplier.getName().toLowerCase().indexOf(value.toLowerCase()) != -1) {
                filteredSuppliers.add(supplier);
            } else if (key.equals("Description") && supplier.getDescription().toLowerCase().indexOf(value.toLowerCase()) != -1) {
                filteredSuppliers.add(supplier);
            }
        }
        
        SupplierList tmpList = new SupplierList();
        tmpList.setArrSupplier(filteredSuppliers);

        return tmpList;
    }
    
    public void set(Supplier newSupplier) {
    	for (Supplier supplier : arrSupplier) {
            if (supplier.getID() == newSupplier.getID()) {
                supplier = newSupplier;
                return;
            }
        }
    }
}
