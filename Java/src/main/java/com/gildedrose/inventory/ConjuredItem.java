package com.gildedrose.inventory;

import com.gildedrose.Item;

/**
 * Implementation class for Conjured Items
 */
public class ConjuredItem implements InventoryItem{
    @Override
    public void updateItemQuality(Item item) {
        item.quality=limitQuality(item.quality-2);
    }



    @Override
    public void updateItemQualityPostSellByDate(Item item) {

        updateItemQuality(item);
    }
}
