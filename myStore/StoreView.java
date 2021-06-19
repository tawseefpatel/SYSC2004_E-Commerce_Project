/**
 * SYSC 2004 Winter 2021 - Milestone 5 StoreView Class
 *
 * @authors Tawseef Patel, 101145333 & Gilles Myny, 101145477
 * @version 5.0
 */

package myStore;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The StoreView class provides the code for the GUI.
 */
public class StoreView {
    private final StoreManager storeManager = new StoreManager();
    private final JTextArea cartItems;
    private final JPanel bodyPanel1;
    private final JPanel bodyPanel2;
    private final JPanel bodyPanel3;
    private final JPanel bodyPanel4;
    private final JPanel bodyPanel5;
    private final JPanel bodyPanel6;
    private final JLabel jLabel1;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private final JLabel jLabel5;
    private final JLabel jLabel6;
    private final JFrame frame;
    private final JFrame checkOutFrame;

    /**
     * Constructor that initializes the global variables for the GUI.
     */
    public StoreView() {
        this.frame = new JFrame("The Shoe Store");
        this.checkOutFrame = new JFrame("Checkout Page");
        this.cartItems = new JTextArea("Your Cart is Empty");
        this.cartItems.setEditable(false);
        this.cartItems.setFont(new Font("Calibri", Font.PLAIN, 14));
        this.bodyPanel1 = new JPanel();
        this.bodyPanel2 = new JPanel();
        this.bodyPanel3 = new JPanel();
        this.bodyPanel4 = new JPanel();
        this.bodyPanel5 = new JPanel();
        this.bodyPanel6 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
    }

    public static void main(String[] args) {
        myStore.StoreView stv = new myStore.StoreView();
        stv.displayGUI();
    }

    /**
     * Initializes all the visual aspects from frames to labels and buttons.
     */
    public void displayGUI() {
        Color background = new Color(170, 170, 170);
        frame.setBackground(background);
        frame.setSize(1280, 710);
        frame.setMaximumSize(new Dimension(1280, 710));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkOutFrame.setBackground(background);
        checkOutFrame.setSize(500, 500);
        checkOutFrame.setMaximumSize(new Dimension(500, 500));
        checkOutFrame.setResizable(false);
        checkOutFrame.setVisible(false);
        checkOutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(background);
        frame.getContentPane().add(mainPanel, BorderLayout.NORTH);
        GridBagConstraints c = new GridBagConstraints();

        // Header Panel
        JPanel headerPanel = new JPanel(new FlowLayout());
        headerPanel.setBackground(background);
        JLabel headerLabel = new JLabel("The Shoe Store");
        headerPanel.add(headerLabel,Component.TOP_ALIGNMENT);
        headerPanel.setPreferredSize(new Dimension(800, 20));
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(headerPanel, c);

        // Body Panel
        JPanel bodyPanel = new JPanel(new GridLayout(3, 2));
        bodyPanel.setBackground(background);
        bodyPanel.setPreferredSize(new Dimension(1000, 550));
        bodyPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        itemDescription(bodyPanel1, jLabel1, "Dark Mocha");
        itemDescription(bodyPanel2, jLabel2, "Cream V2");
        itemDescription(bodyPanel3, jLabel3, "Vick 3 Laser");
        itemDescription(bodyPanel4, jLabel4, "Bapesta DC");
        itemDescription(bodyPanel5, jLabel5, "High");
        itemDescription(bodyPanel6, jLabel6, "Old Skool");
        dropDownMenu(bodyPanel1, "Dark Mocha");
        dropDownMenu(bodyPanel2, "Cream V2");
        dropDownMenu(bodyPanel3, "Vick 3 Laser");
        dropDownMenu(bodyPanel4, "Bapesta DC");
        dropDownMenu(bodyPanel5, "High");
        dropDownMenu(bodyPanel6, "Old Skool");
        try {
            addImage(bodyPanel1, "https://image.goat.com/1000/attachments/product_template_pictures/images/043/946/217/original/567948_00.png.png");
            addImage(bodyPanel2, "https://image.goat.com/1000/attachments/product_template_pictures/images/014/822/680/original/116662_00.png.png");
            addImage(bodyPanel3, "https://image.goat.com/1000/attachments/product_template_pictures/images/008/724/686/original/832698_001.png.png");
            addImage(bodyPanel4, "https://image.goat.com/1000/attachments/product_template_pictures/images/022/718/169/original/DC1.png.png");
            addImage(bodyPanel5, "https://image.goat.com/1000/attachments/product_template_pictures/images/001/678/883/original/850477_101.png");
            addImage(bodyPanel6, "https://image.goat.com/1000/attachments/product_template_pictures/images/011/051/956/original/335725_00.png.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        bodyPanel1.setBackground(background);
        bodyPanel2.setBackground(background);
        bodyPanel3.setBackground(background);
        bodyPanel4.setBackground(background);
        bodyPanel5.setBackground(background);
        bodyPanel6.setBackground(background);
        bodyPanel.add(bodyPanel1);
        bodyPanel.add(bodyPanel2);
        bodyPanel.add(bodyPanel3);
        bodyPanel.add(bodyPanel4);
        bodyPanel.add(bodyPanel5);
        bodyPanel.add(bodyPanel6);
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(2, 0, 2, 0);
        mainPanel.add(bodyPanel, c);

        // Cart Label
        JLabel cartLabel = new JLabel("Your Cart");
        cartLabel.setFont(new Font("Calibri Bold", Font.BOLD, 17));
        cartLabel.setPreferredSize(new Dimension(650, 20));
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(2, 0, 0, 0);
        mainPanel.add(cartLabel, c);

        // Cart Template Label
        JLabel templateLabel = new JLabel("|     Product Info, Price, and Quantity      |");
        templateLabel.setFont(new Font("Calibri Plain", Font.PLAIN, 14));
        templateLabel.setPreferredSize(new Dimension(650, 15));
        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(templateLabel, c);

        // Cart ScrollPane
        JScrollPane scrollPane = new JScrollPane(this.cartItems);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(655, 60));
        c.gridx = 0;
        c.gridy = 4;
        mainPanel.add(scrollPane, c);

        // Checkout
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setPreferredSize(new Dimension(160, 20));
        c.gridx = 0;
        c.gridy = 5;
        mainPanel.add(checkoutButton, c);
        checkoutButton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to checkout?")
                    == JOptionPane.OK_OPTION) {
                checkOut();
            }
        });
        quit(mainPanel);
        frame.pack();
    }

    /**
     * Creates and adds the image panel to the given panel setting its dimensions.
     * @param cp represents a JPanel that is unique to each product in the store
     * @param url is a String representing the URL for the image
     * @throws MalformedURLException
     */
    private void addImage(JPanel cp, String url) throws MalformedURLException {
        ImageIcon imageIcon = new ImageIcon(new URL(url)); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        cp.add(new JLabel(imageIcon));
    }

    /**
     * Creates and adds text to a given panel outlined the product info, price and stock available.
     * @param jp1 represents a JPanel that is unique to each product in the store
     * @param j represents a JPanel that contains the text
     * @param prodId is a String representing the product ID
     */
    private void itemDescription(JPanel jp1, JLabel j, String prodId) {
        j.setText("<html>" + storeManager.getInv().getProd(prodId).getProdName() + "<br/><html>" +
                storeManager.getInv().getProd(prodId).getProdId() + "<br/><html>$" + storeManager.getInv().getProd(prodId).getProdPrice() +
                "<br/><html>" + "Stock Available: " + storeManager.getInv().getStockAmount(prodId) + "</html>");
        jp1.add(j);
    }

    /**
     * Updates the item description everytime a product is added and removed from the cart.
     * @param j1 represents a JPanel that is unique to each product in the store
     * @param prodId is a String representing the product ID
     */
    private void updateDescription(JLabel j1, String prodId) {
        j1.setText("<html>" + storeManager.getInv().getProd(prodId).getProdName() + "<br/><html>" +
                storeManager.getInv().getProd(prodId).getProdId() + "<br/><html>$" + storeManager.getInv().getProd(prodId).getProdPrice() +
                "<br/><html>" + "Stock Available: " + storeManager.getInv().getStockAmount(prodId) + "</html>");
    }

    /**
     * IS responsible for creating the JComboBox for the amount a user can add to their cart..
     * @param jp1 represents a JPanel that is unique to each product in the store
     * @param prodId is a String representing the product ID
     */
    private void dropDownMenu(JPanel jp1, String prodId) {
        JComboBox<Integer> addBox = new JComboBox<>();
        JComboBox<Integer> removeBox = new JComboBox<>();
        JButton addButton = new JButton("Add To Cart");
        JButton removeButton = new JButton("Remove from Cart");
        removeButton.setEnabled(false);

        // Product Initializer
        Product p0  = storeManager.getInv().getProd(prodId);

        // Add to Cart Dropdown First Addition
        int addLength = storeManager.getInv().getStockAmount(prodId);
        for (int i = 1; i <= addLength; i++) {
            addBox.addItem(i);
        }

        // If Add to Cart Button is Pressed
        addButton.addActionListener(e -> {
            assert addBox.getSelectedItem() != null;
            int addQuan = (int) addBox.getSelectedItem();
            storeManager.getCart().addProductQuantity(p0, addQuan);
            storeManager.getInv().removeStockAmount(prodId, addQuan);
            removeButton.setEnabled(true);

            updateAddDD(addButton, addBox, prodId);
            updateRemoveDD(removeButton, removeBox, p0);
            updateCart();
            callToUpdateDescription(jp1, prodId);
        });

        // If Remove from Cart Button is Pressed
        removeButton.addActionListener(f -> {
            assert removeBox.getSelectedItem() != null;
            int removeQuan = (int) removeBox.getSelectedItem();
            storeManager.getCart().removeProductQuantity(p0, removeQuan);
            storeManager.getInv().addProductQuantity(p0, removeQuan);
            addButton.setEnabled(true);

            updateAddDD(addButton, addBox, prodId);
            updateRemoveDD(removeButton, removeBox, p0);
            updateCart();
            callToUpdateDescription(jp1, prodId);
        });

        jp1.add(addBox);
        jp1.add(addButton);
        jp1.add(removeBox);
        jp1.add(removeButton);
    }

    /**
     * Is a helper method for the dropDownMenu that updates the drop down for the add to cart functionality.
     * @param b1 represents the JButton to add a product to cart for each product panel
     * @param cb1 represents the JComboBox to add a product to cart for each product panel
     * @param prodId is a String representing the product ID
     */
    private void updateAddDD(JButton b1, JComboBox<Integer> cb1, String prodId) {
        cb1.removeAllItems();
        int length = storeManager.getInv().getStockAmount(prodId);
        if(length == 0) {
            b1.setEnabled(false);
        } else {
            for(int i = 1; i <= length; i++) {
                cb1.addItem(i);
            }
        }
    }

    /**
     * Is a helper method for the dropDownMenu that updates the drop down for the remove from cart functionality.
     * @param b1 represents the JButton to remove a product from cart for each product panel
     * @param cb1 represents the JComboBox to remove a product from cart for each product panel
     * @param p0 is a Product object representing the product being removed
     */
    private void updateRemoveDD(JButton b1, JComboBox<Integer> cb1, Product p0) {
        cb1.removeAllItems();
        int length = storeManager.getCart().getProductQuantity(p0);
        if(length == 0) {
            b1.setEnabled(false);
        } else {
            for (int i = 1; i <= length; i++) {
                cb1.addItem(i);
            }
        }
    }

    /**
     * This method serves to call the updateDescription method for each product panel.
     * @param jp1 represents a JPanel that is unique to each product in the store
     * @param prodId is a String representing the product ID
     */
    private void callToUpdateDescription(JPanel jp1, String prodId) {
        if (jp1.equals(this.bodyPanel1)) {
            updateDescription(jLabel1, prodId);
        } else if (jp1.equals(this.bodyPanel2)) {
            updateDescription(jLabel2, prodId);
        } else if (jp1.equals(this.bodyPanel3)) {
            updateDescription(jLabel3, prodId);
        } else if (jp1.equals(this.bodyPanel4)) {
            updateDescription(jLabel4, prodId);
        } else if (jp1.equals(this.bodyPanel5)) {
            updateDescription(jLabel5, prodId);
        } else if (jp1.equals(this.bodyPanel6)) {
            updateDescription(jLabel6, prodId);
        }
    }

    /**
     * This method updates the cart display JScrollPane everytime a product is added or removed from the cart.
     */
    private void updateCart() {
        this.cartItems.setText(storeManager.getCart().viewCart());
    }

    /**
     * Handles the receipt for when the user checks out, containing all the items in the cart and a total.
     */
    private void checkOut() {
        JTextArea checkOutWindow = new JTextArea(storeManager.getCart().checkOut());
        JLabel templateLabel = new JLabel("|          Product Info, Price, and Quantity           |");
        JPanel checkOutBody = new JPanel(new BorderLayout());
        this.frame.setVisible(false);
        this.checkOutFrame.setVisible(true);
        checkOutBody.add(templateLabel, BorderLayout.BEFORE_FIRST_LINE);
        checkOutBody.add(checkOutWindow, BorderLayout.CENTER);
        checkOutFrame.add(checkOutBody);
        checkOutFrame.pack();
    }

    /**
     * Handles the Leave Store button and quits the program if pressed.
     * @param jp1 represents the JPanel which is the main panel for the frame
     */
    private void quit(JPanel jp1) {
        JButton quit = new JButton("Leave Store");
        quit.setPreferredSize(new Dimension(160, 20));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(2, 0, 2, 0);
        jp1.add(quit, c);
        quit.addActionListener(e -> System.exit(0));
    }
}