/**
 * SYSC 2004 Winter 2021 - Milestone 5 ProductStockContainer Abstract/Interface
 *
 * @authors Gilles Myny, 101145477 & Tawseef Patel, 101145333
 * @version 1.0
 */

package myStore;

public interface ProductStockContainer {
    int getProductQuantity(Product p1);

    void addProductQuantity(Product p1, int quantity);

    void removeProductQuantity(Product p1, int quantity);

    int getNumOfProducts();
}
