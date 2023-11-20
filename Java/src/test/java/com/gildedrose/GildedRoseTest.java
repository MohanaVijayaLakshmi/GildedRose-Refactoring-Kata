package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemTypeConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {



    GildedRose updateInventory(String name, int sellIn, int quality){
        Item[] items = new Item[]{new Item(name,sellIn,quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }

    @Test
    void testItemQualityDegrade(){
        GildedRose app = updateInventory(DEXTERITY,10,20);
        assertEquals(9,app.items[0].sellIn);
        assertEquals(19,app.items[0].quality);
    }

    @Test
    void testItemQualityDegradeBoundedToMinLimit(){
        GildedRose app = updateInventory(DEXTERITY,2,0);
        assertEquals(1,app.items[0].sellIn);
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void testItemQualityDegradeWhenSellByDatePassed(){
        GildedRose app = updateInventory(DEXTERITY,0,20);
        assertEquals(-1,app.items[0].sellIn);
        assertEquals(18,app.items[0].quality);
    }


    @Test
    void testAgedBrieQualityUpgrade(){
        GildedRose app = updateInventory(AGED_BRIE,10,15);
        assertEquals(9,app.items[0].sellIn);
        assertEquals(16,app.items[0].quality);

    }

    @Test
    void testAgedBrieQualityUpgradeWhenSellByDatePassed(){
        GildedRose app = updateInventory(AGED_BRIE,0,15);
        assertEquals(-1,app.items[0].sellIn);
        //assertEquals(16,app.items[0].quality);
        assertEquals(17,app.items[0].quality);
    }

    @Test
    void testAgedBrieQualityUpgradeBoundedToMaxLimit(){
        GildedRose app = updateInventory(AGED_BRIE,9,50);
        assertEquals(8,app.items[0].sellIn);
        assertEquals(50,app.items[0].quality);
    }

    @Test
    void testSulfurasLegendaryItemQuality(){
        GildedRose app = updateInventory(SULFURAS,10,80);
        assertEquals(10,app.items[0].sellIn);
        assertEquals(80,app.items[0].quality);
    }

    @Test
    void testBackstageQualityUpgradeWhenSellInMoreThan10(){
        GildedRose app = updateInventory(BACKSTAGE,15,45);
        assertEquals(14,app.items[0].sellIn);
        assertEquals(46,app.items[0].quality);
    }

    @Test
    void testBackstageQualityUpgradeWhenSellInMoreThan5AndLessThan11(){
        GildedRose app = updateInventory(BACKSTAGE,10,45);
        assertEquals(9,app.items[0].sellIn);
        assertEquals(47,app.items[0].quality);
    }

    @Test
    void testBackstageQualityUpgradeWhenSellInLessThanOrEquals5(){
        GildedRose app = updateInventory(BACKSTAGE,5,45);
        assertEquals(4,app.items[0].sellIn);
        assertEquals(48,app.items[0].quality);
    }

    @Test
    void testBackstageQualityUpgradeWhenSellInMoreThan5AndLessThan11BoundedToMaxLimit(){
        GildedRose app = updateInventory(BACKSTAGE,2,50);
        assertEquals(1,app.items[0].sellIn);
        assertEquals(50,app.items[0].quality);
    }

    @Test
    void testBackstageQualityUpgradeWhenSellInMoreThan5BoundedToMaxLimit(){
        GildedRose app = updateInventory(BACKSTAGE,6,50);
        assertEquals(5,app.items[0].sellIn);
        assertEquals(50,app.items[0].quality);
    }

    @Test
    void testBackstageQualityDropWhenSellByDatePassed() {
        GildedRose app = updateInventory(BACKSTAGE, 0, 45);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testConjuredItemsQualityDegrade(){
        GildedRose app = updateInventory(CONJURED,3,6);
        assertEquals(2,app.items[0].sellIn);
        assertEquals(4,app.items[0].quality);
    }

    @Test
    void testConjuredItemsQualityDegradeBoundedToMinLimit(){
        GildedRose app = updateInventory(CONJURED,0,0);
        assertEquals(-1,app.items[0].sellIn);
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void testConjuredItemsQualityDegradeWhenSellByDatePassed(){
        GildedRose app = updateInventory(CONJURED,0,10);
        assertEquals(-1,app.items[0].sellIn);
        assertEquals(6,app.items[0].quality);
    }

    @Test
    void printItem() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        //app.updateQuality();
        assertEquals("foo, 0, 0", app.items[0].toString());
    }

}
