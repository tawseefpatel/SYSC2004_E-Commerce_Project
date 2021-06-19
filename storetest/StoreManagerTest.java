/**
 * SYSC 2004 Winter 2021 - Milestone 3 StoreManager Test JUnit Class
 *
 * @authors Gilles Myny, 101145477 & Tawseef Patel, 101145333
 * @version 1.0
 * This milestone version was created by Gilles Myny, 101145477.
 */

package storetest;

import myStore.Inventory;
import myStore.Product;
import myStore.ShoppingCart;
import myStore.StoreManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 * This class tests the necessary methods in the StoreManager class inside the store package.
 */
public class StoreManagerTest {
    private static StoreManager stm;
    private static Inventory inv;

    /**
     * BeforeAll initializes all necessary class objects before running the tests.
     */
    @BeforeAll
    public static void init() {
        stm = new StoreManager();
    }

    /**
     * testStockLoopUp tests the stockLoopUp method in the StoreManager class.
     */
    @Test
    public void testStockLoopUp() {
        Assertions.assertEquals(10, stm.stockLoopUp("Dark Mocha"), "Test failed, stock amount incorrect.");
    }

    /**
     * testGetCartId tests the getCartId method in the StoreManager class.
     */
    @Test
    public void testGetCartId() {
        ShoppingCart cart1 = new ShoppingCart();
        stm.generateCartId(cart1);
        Assertions.assertEquals(1001, stm.getCartId(cart1), "Test failed, wrong cart ID given.");
    }

    /**
     * testAddItemToCart tests the addItemToCart method in the StoreManager class.
     */
    @Test
    public void testAddItemToCart() {
        Product p = stm.getInv().getProd("Cream V2");
        stm.addItemToCart(1000, "Cream V2", 4);
       // Assertions.assertEquals(4, stm.getCart(1000).getQuantityOfProduct(p), "Test failed, product wasn't added to cart.");
    }

    /**
     * testRemoveCartItem tests the removeCartItem method in the StoreManager class.
     */
    @Test
    public void testRemoveCartItem() {
        Product p1 = stm.getInv().getProd("Cream V2");
        stm.removeCartItem(1000, "Cream V2", 2);
        //Assertions.assertEquals(2, stm.getCart(1000).getQuantityOfProduct(p1));
    }
}