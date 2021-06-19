/**
 * SYSC 2004 Winter 2021 - Milestone 5 Product Class
 *
 * @authors Gilles Myny, 101145477 & Tawseef Patel, 101145333
 * @version 5.0
 */

package myStore;

/**
 * The Product class creates a product object given a name, id, and price.
 */
public class Product {
    private final String prodName;
    private final String prodId;
    private final double prodPrice;

    /**
     * Default constructor for Product object
     */
    public Product() {
        prodName = "";
        prodId = "";
        prodPrice = 0;
    }

    /**
     * Overloaded Constructor
     * The Product constructor initializes a product object.
     *
     * @param name  a String representation of the product name
     * @param id    a String representation of the product ID
     * @param price a double representation of the product price
     */
    public Product(String name, String id, double price) {
        this.prodName = name;
        this.prodId = id;
        this.prodPrice = price;
    }

    /**
     * The getProdName getter method returns the product name.
     *
     * @return a String representation of the product name
     */
    public String getProdName() {
        return this.prodName;
    }

    /**
     * The getProdId getter method returns the product ID.
     *
     * @return a String representation of the product ID
     */
    public String getProdId() {
        return this.prodId;
    }

    /**
     * The getProdPrice getter method returns the product price.
     *
     * @return a double representation of the product price
     */
    public double getProdPrice() {
        return this.prodPrice;
    }

    /**
     * The equals method checks if a given product object's attributes match a product.
     *
     * @param prod a Product object
     * @return a boolean value if there is a match
     */
    public boolean equals(Product prod) {
        return this.prodName.equals(prod.getProdName()) && this.prodId.equals(prod.getProdId()) && this.prodPrice == prod.getProdPrice();
    }

    /**
     * The equals method checks if a given product object's attributes match a product.
     *
     * @param name   a String representation of the product name
     * @param prodId a String representation of the product ID
     * @param price  a double representation of the product price
     * @return a boolean value if there is a match
     */
    public boolean equals(String name, String prodId, double price) {
        return this.prodName.equals(name) && this.prodId.equals(prodId) && this.prodPrice == price;
    }
}