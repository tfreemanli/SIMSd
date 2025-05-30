package com.simsd;
// import java.time.LocalDateTime;

public class ItemFromSupplier extends Item{
    // private LocalDateTime bestBeforeDate;
    private long iSupplierID;

    public ItemFromSupplier(){
        this("", "", 0.0f, 0);
    }
    public ItemFromSupplier(String name, String description, float pricePerUnit, long supplierID){
        super(name);
        this.setDescription(description);
        this.setPricePerUnit(pricePerUnit);
        this.setSupplierID(supplierID);
        // this.bestBeforeDate = LocalDateTime.now().plusDays(30); // Example: 30 days from now
    }

    // public LocalDateTime getBestBeforeDate() {
    //     return bestBeforeDate;
    // }

    // public void setBestBeforeDate(LocalDateTime bestBeforeDate) {
    //     this.bestBeforeDate = bestBeforeDate;
    // }

    public long getSupplierID() {
        return iSupplierID;
    }

    public void setSupplierID(long iSupplierID) {
        this.iSupplierID = iSupplierID;
    }
}
