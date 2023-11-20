package com.gildedrose;

import static com.gildedrose.ItemTypeConstants.*;

class GildedRose {
    Item[] items;

    static final int MIN_QUALITY = 0;
    static final int MAX_QUALITY = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);

            updateItemSellIn(item);

            updateQualityWhenSellByDatePassed(item);
        }
    }

    private void updateQualityWhenSellByDatePassed(Item item) {

        if (item.sellIn < 0) {
            if(item.name.equals(AGED_BRIE)){
                upgradeQuality(item);
            }else if(item.name.equals(BACKSTAGE)){
                item.quality = 0;
            }else{
                if(!item.name.equals(SULFURAS)){
                    degradeQuality(item);
                }
                if(item.name.equals(CONJURED)){
                    degradeQuality(item);
                }
            }

        }
    }

    private void updateItemQuality(Item item) {

        if(item.name.equals(AGED_BRIE)){
            upgradeQuality(item);
        }else if(item.name.equals(BACKSTAGE)){
            upgradeQuality(item);
            if(item.sellIn<11){
                upgradeQuality(item);
            }
            if(item.sellIn<6){
                upgradeQuality(item);
            }
        }else{
            if(!item.name.equals(SULFURAS)){
                degradeQuality(item);
            }
            if(item.name.equals(CONJURED)){
                degradeQuality(item);
            }
        }


    }

    private void degradeQuality(Item item) {
        if(item.quality>MIN_QUALITY){
            item.quality -= 1;
        }
    }

    private void upgradeQuality(Item item) {
        if(item.quality<MAX_QUALITY) {
            item.quality += 1;
        }
    }

    private void updateItemSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn -= 1;
        }
    }
}
