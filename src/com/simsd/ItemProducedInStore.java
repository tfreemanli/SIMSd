package com.simsd;

import java.time.LocalDate;

public class ItemProducedInStore extends Item{
    private LocalDate produceDate;
    // private LocalDateTime useByDate;

    /**
     * Default constructor for ItemProducedInStore.
     * Initializes the item with an empty name.
     */
    public ItemProducedInStore(){
        this("ItemProducedInStore", "", 0.0f, LocalDate.now());
    }

    /**
     * Constructor for ItemProducedInStore with a specified name.
     * Calls the superclass constructor to set the name of the item.
     * 
     * @param name the name of the item.
     */
    public ItemProducedInStore(String name, String description, float pricePerUnit, LocalDate produceDate) {
        super(name);
        this.setDescription(description);
        this.setPricePerUnit(pricePerUnit);
        this.setProduceDate(produceDate);
    }
    
    /**
     * Gets the produce date of the item.
     * @return the produce date as a LocalDateTime object.
     */
    public LocalDate getProduceDate() {
        return produceDate;
    }

    /**
     * Sets the produce date of the item.
     * @param produceDate the produce date to set as a LocalDateTime object.
     */
    public void setProduceDate(LocalDate produceDate) {
        this.produceDate = produceDate;
    }

    /**
     * Gets the use-by date of the item.
     * @return the use-by date as a LocalDateTime object.
     */
    // public LocalDateTime getUseByDate() {
    //     return useByDate;
    // }

    /**
     * Sets the use-by date of the item.
     * @param useByDate the use-by date to set as a LocalDateTime object.
     */
    // public void setUseByDate(LocalDateTime useByDate) {
    //     this.useByDate = useByDate;
    // }
}
