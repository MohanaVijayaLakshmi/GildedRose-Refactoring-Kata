package com.gildedrose.inventory;

import com.gildedrose.Item;

/**
 * Implementation class for Sulfuras items
 */
public class SulfurasItem implements InventoryItem{

    static final int MAX_QUALITY = 80;

    @Override
    public void updateItemQuality(Item item) {
        //legendary item quality never decreases
    }

    @Override
    public void updateItemSellIn(Item item) {
        //legendary item never to be sold
    }

    @Override
    public void updateItemQualityPostSellByDate(Item item) {
        //legendary item quality never decreases
    }
}
