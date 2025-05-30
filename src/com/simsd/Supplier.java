package com.simsd;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Supplier {
    private long iID;
    private String sName;
    private String sDescription;

    //Constructor
    public Supplier(){
        this("");
    }

    // Constructor
    public Supplier(String name){
        //this(0, "", "");
        //generate a ID from current time.
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYMMddHHmmssSSS");
        String text = datetime.format(formatter);
        this.iID = Long.valueOf(text);
        this.sName = name;
    }

    // Constructor for Json file in the future
    public Supplier(long iID, String sName, String sDescription) {
        this.iID = iID;
        this.sName = sName;
        this.sDescription = sDescription;
    }

    public String toString(){
        return this.sName;
    }

    // Getter for iID
    public long getID() {
        return iID;
    }

    // Setter for iID
    public void setID(long iID) {
        this.iID = iID;
    }

    // Getter for sName
    public String getName() {
        return sName;
    }

    // Setter for sName
    public void setName(String sName) {
        this.sName = sName;
    }

    // Getter for sDescription
    public String getDescription() {
        return sDescription;
    }

    // Setter for sDescription
    public void setDescription(String sDescription) {
        this.sDescription = sDescription;
    }
}
