/**
 * SYSC 2004 Winter 2021 - Milestone 5 Inventory Class
 *
 * @authors Gilles Myny, 101145477 & Tawseef Patel, 101145333
 * @version 5.0
 */

package myStore;

import java.util.HashMap;

/**
 * The Inventory class acts as the inventory of the store.
 */
public class Inventory implements ProductStockContainer {
    private final HashMap<Product, Integer> prodInfo;

    /**
     * The constructor initializes the product info hashmap and adds the 5 products to the inventory.
     */
    public Inventory() {
        this.prodInfo = new HashMap<Product, Integer>();
        prodInfo.put(new Product("Jordan 1 Retro High", "Dark Mocha", 836.99), 10);
        prodInfo.put(new Product("Yeezy 350", "Cream V2", 477.99), 5);
        prodInfo.put(new Product("Nike Air Zoom", "Vick 3 Laser", 656.99), 15);
        prodInfo.put(new Product("Bathing Ape", "Bapesta DC", 350.49), 13);
        prodInfo.put(new Product("Nike Dunk", "High", 355.49), 18);
        prodInfo.put(new Product("Vans Yacht Club", "Old Skool", 1049.99), 5);
    }

    /**
     * The getProd method returns the product object associated with the given product ID.
     *
     * @param prodId is a String representation of the product ID
     * @return either a product object or null depending if the product ID matches an available product
     */
    public Product getProd(String prodId) {
        for (Product prod : this.prodInfo.keySet()) {
            if (prod.getProdId().equals(prodId)) {
                return prod;
            }
        }
        return null;
    }

    /**
     * @return an arraylist of all the products in the inventory.
     */
    public int getNumOfProducts() {
        return this.prodInfo.size();
    }

    /**
     * The getProductQuantity method returns the quantity of the given product object.
     * @param p1 is a Product object
     * @return an int representation of the stock quantity
     */
    public int getProductQuantity(Product p1) {
        return getStockAmount(p1.getProdId());
    }

    /**
     * The getStockAmount method returns the available stock quantity given a product ID.
     *
     * @param prodId is a String representation of the product ID
     * @return an int representation of the stock quantity
     */
    public int getStockAmount(String prodId) {
        Product prod = getProd(prodId);
        if (prod != null) {
            return this.prodInfo.get(prod);
        }
        return -1;
    }

    /**
     * The addProductQuantity method adds a specific amount of stock to a given product object.
     *
     * @param item   is a Product object
     * @param amount is a int representation of the amount of stock to be added
     */
    public void addProductQuantity(Product item, int amount) {
        addStockAmount(item.getProdId(), amount);
    }

    /**
     * The addStockAmount method adds a specific amount of stock to a given the product ID.
     *
     * @param prodId is a String representation of the product ID
     * @param amount is a int representation of the amount of stock to be added
     */
    public void addStockAmount(String prodId, int amount) {
        Product temporary = getProd(prodId);
        if (this.prodInfo.containsKey(temporary)) {
            this.prodInfo.put(temporary, this.prodInfo.get(temporary) + amount);
        } else {
            this.prodInfo.put(temporary, amount);
        }
    }

    /**
     * The removeProductQuantity method removes a specific amount of stock to a given product object.
     *
     * @param item   is a Product object
     * @param amount is a int representation of the amount of stock to be removed
     */
    public void removeProductQuantity(Product item, int amount) {
        removeStockAmount(item.getProdId(), amount);
    }

    /**
     * The removeStockAmount method removes a specific amount of stock to a given the product ID.
     *
     * @param prodId is a String representation of the product ID
     * @param amount is a int representation of the amount of stock to be removed
     */
    public void removeStockAmount(String prodId, int amount) {
        for (Product prod : this.prodInfo.keySet()) {
            if (prod.getProdId().equals(prodId)) {
                this.prodInfo.put(prod, Math.max((this.prodInfo.get(prod) - amount), 0));
            }
        }
    }
}