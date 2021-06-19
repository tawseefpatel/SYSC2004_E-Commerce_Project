/**
 * SYSC 2004 Winter 2021 - Milestone 5 StoreManager Class
 *
 * @authors Gilles Myny, 101145477 & Tawseef Patel, 101145333
 * @version 5.0
 */

package myStore;

import java.util.HashMap;
import java.util.Map;

/**
 * The StoreManager class manages the inventory class and keeps track of carts and their ID's.
 */
public class StoreManager {
    private final Inventory inv;
    private final HashMap<ShoppingCart, Integer> allCarts; // ShoppingCart is the shoppingcart object, Integer is the cartId
    private int cartIdCounter = 1000;

    /**
     * The StoreManager constructor initializes a new inventory and hashmap of carts.
     */
    public StoreManager() {
        this.inv = new Inventory();
        this.allCarts = new HashMap<ShoppingCart, Integer>();
        cartCreation();
    }

    /**
     * The getInv getter method returns the inventory.
     *
     * @return a Inventory object
     */
    public Inventory getInv() {
        return this.inv;
    }

    /**
     * The stockLookUp method returns the amount of stock given a product ID.
     *
     * @param prodId is a String representation of the product ID
     * @return a int representing the stock amount
     */
    public int stockLoopUp(String prodId) {
        return inv.getStockAmount(prodId);
    }

    /**
     * The generateCartId method adds the given cart to the carts hashmap and assigns it with a ID.
     *
     * @param cart is a Cart object
     */
    public void generateCartId(ShoppingCart cart) {
        if (allCarts.containsKey(cart)) {
            allCarts.putIfAbsent(cart, cartIdCounter);
        } else {
            allCarts.put(cart, cartIdCounter);
        }
        cartIdCounter++;
    }

    /**
     * The cartCreation method calls on the generateCartId method.
     */
    public void cartCreation() {
        ShoppingCart temporary = new ShoppingCart();
        generateCartId(temporary);
    }


    /**
     * @param cart is the shoppingcart whose id is being requested
     * @return the cartId of the shoppingcart param
     */
    public int getCartId(ShoppingCart cart) {
        int cartNumber = 0;
        for (Map.Entry<ShoppingCart, Integer> ent : allCarts.entrySet()) {
            if (ent.getKey() == cart) {
                cartNumber = ent.getValue();
            }
        }
        return cartNumber;
    }

    /**
     * The getCart getter method returns the cart object given the cart Id.
     *
     * @return a Cart object
     */
    public ShoppingCart getCart() {
        ShoppingCart sc = null;
        for (Map.Entry<ShoppingCart, Integer> ent : allCarts.entrySet()) {
            if (ent.getKey() != null) {
                sc = ent.getKey();
            }
        }
        return sc;
    }

    /**
     * @param cartId is cart id of the shopping cart which is trying to be retrieved
     * @return the shoppingcart that is retrieved
     */
    public ShoppingCart getCart(int cartId) {
        ShoppingCart sc = null;
        for (Map.Entry<ShoppingCart, Integer> ent : allCarts.entrySet()) {
            if (ent.getValue().equals(cartId)) {
                sc = ent.getKey();
            }
        }
        if (sc != null) {
            return sc;
        } else {
            System.out.println("Cart does not Exist");
        }
        return sc;
    }

    /**
     * The addItemToCart method adds a product and its amount to the respective cartId.
     *
     * @param cartId is a int representing the cart Id number
     * @param prodId is a String representation of the product ID
     * @param amount is a int representing the amount of stock
     */
    public void addItemToCart(int cartId, String prodId, int amount) {
        if (allCarts.containsValue(cartId)) {
            Product prod = inv.getProd(prodId);
            for (Map.Entry<ShoppingCart, Integer> ent : allCarts.entrySet()) {
                if (ent.getValue() == cartId) {
                    ent.getKey().addProductQuantity(prod, amount);
                    break;
                }
            }
        } else {
            System.out.println("Cart does not exist. Please try again.");
        }
    }

    /**
     * The removeCartItem method removes a product and its amount from the respective cartId.
     *
     * @param cartId is a int representing the cart Id number
     * @param prodId is a String representation of the product ID
     * @param amount is a int representing the amount of stock
     */
    public void removeCartItem(int cartId, String prodId, int amount) {
        if (allCarts.containsValue(cartId)) {
            Product prod = inv.getProd(prodId);
            for (Map.Entry<ShoppingCart, Integer> ent : allCarts.entrySet()) {
                if (ent.getValue() == cartId) {
                    ent.getKey().removeProductQuantity(prod, amount);
                    break;
                }
            }
        } else {
            System.out.println("Cart does not exist. Please try again.");
        }
    }


    /**
     * The getAllCarts getter method returns the hashmap of all the carts.
     *
     * @return a HashMap<ShoppingCart, Integer>
     */
    public HashMap<ShoppingCart, Integer> getAllCarts() {
        return allCarts;
    }
}