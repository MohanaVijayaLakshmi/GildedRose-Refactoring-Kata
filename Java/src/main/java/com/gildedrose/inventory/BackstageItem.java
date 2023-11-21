package com.gildedrose.inventory;

import com.gildedrose.Item;

/**
 * Implementation class for Backstage items
 */
public class BackstageItem implements InventoryItem{
    @Override
    public void updateItemQuality(Item item) {
        if(item.sellIn>=0){
            if (item.sellIn < 6) {
                item.quality = limitQuality(item.quality + 3);
            } else if (item.sellIn < 11) {
                item.quality = limitQuality(item.quality + 2);
            } else {
                 item.quality = limitQuality(item.quality + 1);
            }
        }
    }

    @Override
    public void updateItemQualityPostSellByDate(Item item) {
        item.quality = 0;
    }
}
