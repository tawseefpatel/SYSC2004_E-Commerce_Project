/**
 * SYSC 2004 Winter 2021 - Milestone 3 Inventory Test JUnit Class
 *
 * @authors Gilles Myny, 101145477 & Tawseef Patel, 101145333
 * @version 1.0
 * This milestone version was created by Gilles Myny, 101145477.
 */

package storetest;

import myStore.Inventory;
import myStore.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * This class tests the necessary methods in the Inventory class inside the store package.
 */
public class InventoryTest {
    private static Inventory inv;

    /**
     * BeforeAll initializes all necessary class objects before running the tests.
     */
    @BeforeAll
    public static void init() {
        inv = new Inventory();
    }

    /**
     * testGetProd tests the getProd method in the Inventory class given the product name, price, and ID.
     */
    @Test
    public void testGetProd() {
        Assertions.assertEquals("Jordan 1 Retro High", inv.getProd("Dark Mocha").getProdName(), "Test failed, name incorrect.");
        Assertions.assertEquals("Dark Mocha", inv.getProd("Dark Mocha").getProdId(), "Test failed, ID incorrect.");
        Assertions.assertEquals(836.99, inv.getProd("Dark Mocha").getProdPrice(), "Test failed, price incorrect.");
    }

    /**
     * testGetStockAmount tests the getStockAmount method in the Inventory class given a product id.
     */
    @Test
    public void testGetStockAmount() {
        Assertions.assertEquals(10, inv.getStockAmount("Dark Mocha"), "Test failed, stock amount incorrect.");
    }

    /**
     * testAddStockAmount tests the addStockAmount method in the Inventory class using a couple of scenarios.
     */
    @Test
    public void testAddStockAmount() {
        Product p1 = new Product("Nike Air Zoom", "Vick 3 Laser", 656.99);
        inv.addStockAmount("Cream V2", 5);
        //inv.addStockAmount(p1, 5);
        Assertions.assertEquals(10, inv.getStockAmount("Cream V2"), "Test failed, stock amount not increased properly.");
        Assertions.assertEquals(20, inv.getStockAmount("Vick 3 Laser"), "Test failed, stock amount not increased properly.");
    }

    /**
     * testRemoveStockAmount tests the removeStockAmount method in the Inventory class.
     */
    @Test
    public void testRemoveStockAmount() {
        inv.removeStockAmount("High", 9);
        Assertions.assertEquals(9, inv.getStockAmount("High"), "Test failed, stock amount not decreased properly.");
    }
}
