package com.gildedrose.inventory;

import com.gildedrose.ItemTypeConstants;

import static com.gildedrose.ItemTypeConstants.*;

/**
 * Factory class with static factory method to
 * create item instances based on item name
 */
public class InventoryItemFactory {

    public static InventoryItem createInstance(String itemType){
        InventoryItem item = null;
        switch(itemType){
            case AGED_BRIE:
                item = new AgedBrieItem();
                break;
            case BACKSTAGE:
                item = new BackstageItem();
                break;
            case SULFURAS:
                item = new SulfurasItem();
                break;
            case CONJURED:
                item = new ConjuredItem();
                break;
            default:
                item = new GenericItem();
        }
        return item;
    }

}
