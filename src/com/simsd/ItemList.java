package com.simsd;

import java.util.ArrayList;
import java.io.File;
import java.time.LocalDate;

public class ItemList<ItemType extends Item> {
    private ArrayList<ItemType> arrList = new ArrayList<ItemType>();
    private Class<ItemType> myClass;
    private FileOpr<ItemType> fileOpr = null;


    // Default constructor
    public ItemList(){
        //empty constructor allow to start with a empty Item list
        //need to setFileOpr(file) manually and save it without open() it.
    }

    // Constructor that takes a file as an argument
    // and initializes the item list from it.
    // This Constructor will read the file straight away
    // If don't want to read the file into ArrayList, use the default constructor
    public ItemList(File file, Class<ItemType> clazz){
        
        this.myClass = clazz;

        if (file.exists()) {
            fileOpr = new FileOpr<ItemType>(file, clazz);
            this.open();
        } else {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }

    public Class<ItemType> getMyClass() {
        return myClass;
    }
    public void setMyClass(Class<ItemType> clazz) {
        this.myClass = clazz;
    }

    public void setFileOpr(FileOpr<ItemType> fileOpr) {
        this.fileOpr = fileOpr;
    }
    public FileOpr<ItemType> getFileOpr() {
        return fileOpr;
    }
    
    public void setArrItem(ArrayList<ItemType> arr) {
    	this.arrList = arr;
    }

    //Open JSON file to read items from
    public void open(){
        if (fileOpr != null) {
            arrList = fileOpr.open();
        } else {
            System.out.println("File operation object is not initialized.");
        }
    }

    //Save the item list to a file
    public void save() {
        if (fileOpr != null) {
            fileOpr.save(arrList);
        } else {
            System.out.println("File operation object is not initialized.");
        }
    }

    //== above is for file Operation =============================================

    //== below is for item list operation ========================================
    //get Type
    public String getType() {
        return myClass.getSimpleName();
        // return sType;
    }
    public void setType(String type) {
    }

    //add Item to the list
    public void add(ItemType item) {
        arrList.add(item);
    }

    //Remove Item from the list by object or index
    public void remove(int index) {
        arrList.remove(index);
    }
    public void remove(ItemType item) {
        arrList.remove(item);
    }
    public void clear() {
        arrList.clear();
    }

    //get Item by index or ItemID
    public ItemType getByItemID(int id) {
        for (ItemType item : arrList) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }
    public ItemType get(int index) {
        return arrList.get(index);
    }

    public ArrayList<ItemType> all() {
        return arrList;
    }

    public int size() {
        return arrList.size();
    }

    //update Item in the list by object or index
    public void update(int index, ItemType item) {
        arrList.set(index, item);
    }
    public void update(ItemType item) {
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i).getID() == item.getID()) {
                arrList.set(i, item);
                break;
            }
        }
    }

    //filter items by dictionary
    // alot more thing TODO here
    public ItemList<ItemType> filter(String key, String value) {
        ArrayList<ItemType> filteredList = new ArrayList<ItemType>();
        for (ItemType item : arrList) {
        	if (key.equals("Name") && item.getName().toLowerCase().indexOf(value.toLowerCase()) != -1) {
        		filteredList.add(item);
            } else if (key.equals("Description") && item.getDescription().toLowerCase().indexOf(value.toLowerCase()) != -1) {
            	filteredList.add(item);
            }
        }
        ItemList<ItemType> tmp = new ItemList<ItemType>();
        tmp.setArrItem(filteredList);
        return tmp;
    }

    //order asc ArrayList items by item's field name
    public void orderBy(String key){
        //
    }

    //Filter items which expiration date is before the given dateTime
    //e.g. exp date is 2023-10-01 00:00, given dateTime is 2023-10-02 00:00
    //then this item is expired and will be added to the list and returned
    public ItemList<ItemType> expireBefore(LocalDate date) {
        ArrayList<ItemType> expiredItems = new ArrayList<ItemType>();
        for (ItemType item : arrList) {
            if (item.getExpDate() != null && item.getExpDate().isBefore(date)) {
                expiredItems.add(item);
            }
        }
        ItemList<ItemType> tmpItemList= new ItemList<ItemType>();
        tmpItemList.setArrItem(expiredItems);
        return tmpItemList;
    }

    public void setExpire(LocalDate dateTime) {
        for (ItemType item : arrList) {
            if (item.getExpDate() != null && item.getExpDate().isBefore(dateTime)) {
                item.setExpired(true);;
            }else if (item.getExpDate() != null && item.getExpDate().isAfter(dateTime)) {
                item.setExpired(false);
            }
        }
        return;
    }
}
