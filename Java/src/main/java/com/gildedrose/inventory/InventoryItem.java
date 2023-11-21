package com.gildedrose.inventory;

import com.gildedrose.Item;

/**
 * Inventory Item interface with template and helper methods
 * that can be used to implement different types of inventory item
 */
public interface InventoryItem {

    int MIN_QUALITY = 0;
    int MAX_QUALITY = 50;

    /**
     * Process Item method accepts item and updates
     * quality and sellIn
     * @param item
     */
    default void processItem(Item item){
        updateItemQuality(item);
        updateItemSellIn(item);
        if(item.sellIn<0){
            updateItemQualityPostSellByDate(item);
        }

    }

    /**
     * Template method to update quality which should be
     * overridden by Item implementation class to define
     * logic
     * @param item
     */
    void updateItemQuality(Item item);

    /**
     * Template method to update sellIn which can be overridden
     * by item implementation class to define new logic
     * @param item
     */
    default void updateItemSellIn(Item item){
        item.sellIn--;
    }

    /**
     * Template method to update quality post sellIn passed
     * which should be implemented by Item implementation
     * classes to define logic
     * @param item
     */
    void updateItemQualityPostSellByDate(Item item);

    /**
     * Method limits quality to reside between MIN and MAX limit
     * @param quality
     * @return
     */
    default int limitQuality(int quality){
        if(quality<MIN_QUALITY){
            quality=MIN_QUALITY;
        }
        if(quality>MAX_QUALITY){
            quality=MAX_QUALITY;
        }
        return quality;
    }


}
