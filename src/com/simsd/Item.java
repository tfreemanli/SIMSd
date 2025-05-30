package com.simsd;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private long iID;
    private String sName;
    private String sType;
    private LocalDate dtSellByDate;
    private boolean bExpired;
    private LocalDate dtExpireDate;
    private String sDescription;
    private float fPricePerUnit;
    private String sUnit;
    private float fQuantity;

    /**
     * Constructor with item Name
     * 
     */
    public Item(String name){        
        //generate a ID from current time.
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYMMddHHmmssSSS");//max value is 1231235959, within int's range
        String text = datetime.format(formatter);
        this.iID = Long.valueOf(text);
        this.sName = name;
    }


    /**
     * Default Constructor
     * will only generate a ID from current time stamp with a format of "MMddHHmmss"
     */
    public Item(){
        this("");
    }

    public String toString(){
        return sName + "["+iID+"]";
    }

    //All getter and setter
    public long getID(){
        return this.iID;
    }

    public void setID(String id){
        try{
        this.iID = Long.valueOf(id);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public String getName() {
        return sName;
    }

    public void setName(String sName) {
        this.sName = sName;
    }

    public String getType() {
        return sType;
    }

    public void setType(String sType) {
        this.sType = sType;
    }

    public LocalDate getSellByDate() {
        return dtSellByDate;
    }

    public void setSellByDate(LocalDate dtSellByDate) {
        this.dtSellByDate = dtSellByDate;
    }

    public boolean isExpired() {
        return bExpired;
    }

    public void setExpired(boolean bExpired) {
        this.bExpired = bExpired;
    }

    public LocalDate getExpDate() {
        return dtExpireDate;
    }

    public void setExpDate(LocalDate dtExpire) {
        this.dtExpireDate = dtExpire;
    }

    public String getDescription() {
        return sDescription;
    }

    public void setDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public float getPricePerUnit() {
        return fPricePerUnit;
    }

    public void setPricePerUnit(float fPricePerUnit) {
        this.fPricePerUnit = fPricePerUnit;
    }

    public String getUnit() {
        return sUnit;
    }

    public void setUnit(String sUnit) {
        this.sUnit = sUnit;
    }

    public float getQuantity() {
        return fQuantity;
    }

    public void setQuantity(float fQuantity) {
        this.fQuantity = fQuantity;
    }
    //end of getter and setter
    
}
