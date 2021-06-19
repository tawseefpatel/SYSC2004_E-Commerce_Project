/**
 * SYSC 2004 Winter 2021 - Milestone 5 ShoppingCart Class
 *
 * @authors Gilles Myny, 101145477 & Tawseef Patel, 101145333
 * @version 5.0
 */

package myStore;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The ShoppingCart class controls the users shopping cart and has the ability
 * to add and remove items. Also includes the method to checkout.
 */

public class ShoppingCart implements ProductStockContainer {
    private final HashMap<Product, Integer> shopCart;


    /**
     * Constructs the shopping cart by creating a hashmap for the user
     */
    public ShoppingCart() {
        shopCart = new HashMap<Product, Integer>();
    }

    /**
     * The emptyCart method clears the entire cart of products.
     */
    public void emptyCart() {
        shopCart.clear();
    }

    /**
     * The getProducts getter method returns each product in the cart hashmap.
     *
     * @return a Product object
     */
    public Product getProducts() {
        Product p = null;
        for (Map.Entry<Product, Integer> ent : shopCart.entrySet()) {
            p = ent.getKey();
        }
        return p;
    }

    /**
     * @return an arraylist of all the products in cart.
     */
    public ArrayList<Product> getProduct() {
        Product p = null;
        ArrayList<Product> prods = new ArrayList<Product>();
        for (Map.Entry<Product, Integer> ent : shopCart.entrySet()) {
            prods.add(ent.getKey());
        }
        return prods;
    }

    /**
     * @return the number of products in cart
     */
    public int getNumOfProducts() {
        int quan = 0;
        for (Map.Entry<Product, Integer> ent : this.shopCart.entrySet()) {
            quan += ent.getValue();
        }
        return quan;
    }

    /**
     * @param p is the product whose quantity is being retrieved
     * @return the quantity of product p in cart
     */
    public int getProductQuantity(Product p) {
        int quan = 0;
        for (Map.Entry<Product, Integer> ent : this.shopCart.entrySet()) {
            if (ent.getKey().equals(p)) {
                quan = shopCart.get(p);
            }
        }
        return quan;
    }

    /**
     * @param prod     is the product being added to cart
     * @param quantity is the amount of product being added to cart
     */
    public void addProductQuantity(Product prod, int quantity) {
        if (shopCart.containsKey(prod) && quantity >= 0) {
            System.out.println("Adding " + quantity + " more of " + prod.getProdName() + " " + prod.getProdId() + " to cart...");
            this.shopCart.replace(prod, this.shopCart.get(prod) + quantity);
        } else {
            System.out.println("Adding " + quantity + " of " + prod.getProdName() + " " + prod.getProdId() + " to cart...");
            this.shopCart.put(prod, quantity);
        }
    }

    /**
     * @param prod     is the product being removed from cart
     * @param quantity is the amount of product being removed from cart
     */
    public void removeProductQuantity(Product prod, int quantity) {
        if (shopCart.containsKey(prod) && quantity >= 0) {
            System.out.println("Removing " + quantity + " of " + prod.getProdName() + " " +
                    prod.getProdId() + " from cart...");
            if (shopCart.get(prod) > quantity) {
                shopCart.replace(prod, shopCart.get(prod), shopCart.get(prod) - quantity);
            } else {
                shopCart.remove(prod);
            }
        } else {
            System.out.println("Error in removing from cart. Please try again.");
        }
    }

    /**
     * The viewCart method returns a String of the cart contents.
     * @return A String representing the cart contents
     */
    public String viewCart() {
        StringBuilder sb = new StringBuilder();
        double total = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        String s;
        for (Map.Entry<Product, Integer> ent : shopCart.entrySet()) {
            s = "  " + ent.getKey().getProdName() + "  " + ent.getKey().getProdId() + "  " + ent.getKey().getProdPrice() + "  " + ent.getValue();
            sb.append(s).append("\n");
            total += (ent.getKey().getProdPrice()) * ent.getValue();
        }
        sb.append("\n  Your cart total is: $").append(df.format(total));
        return sb.toString();
    }

    /**
     * The checkOut method returns a String of the entire cart contents after checkout.
     * @return a String representing the contents that were checked out
     */
    public String checkOut() {
        StringBuilder sb = new StringBuilder();
        double total = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        String s;
        for (Map.Entry<Product, Integer> ent : shopCart.entrySet()) {
            s = "  " + ent.getKey().getProdName() + "  " + ent.getKey().getProdId() + "  " + ent.getKey().getProdPrice() + "  " + ent.getValue();
            sb.append(s).append("\n");
            total += (ent.getKey().getProdPrice()) * ent.getValue();
        }
        sb.append("\n  Thanks for shopping, your total was: $").append(df.format(total));
        return sb.toString();
    }
}