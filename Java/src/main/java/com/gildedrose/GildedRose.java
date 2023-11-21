package com.gildedrose;

import com.gildedrose.inventory.InventoryItem;
import com.gildedrose.inventory.InventoryItemFactory;

/**
 * Client class to update inventory of items
 */
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        for (Item item : items) {
            InventoryItem inventory = InventoryItemFactory
                .createInstance(item.name);
            inventory.processItem(item);
        }
    }
}
