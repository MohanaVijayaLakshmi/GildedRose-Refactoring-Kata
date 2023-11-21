package com.gildedrose.inventory;

import com.gildedrose.Item;

/**
 * Implementation class for Normal Items
 */
public class GenericItem implements InventoryItem{

    @Override
    public void updateItemQuality(Item item) {
        item.quality=limitQuality(item.quality-1);

    }



    @Override
    public void updateItemQualityPostSellByDate(Item item) {

        updateItemQuality(item);
    }
}
