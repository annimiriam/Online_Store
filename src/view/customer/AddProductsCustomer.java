package view.customer;

import javax.swing.*;

public class AddProductsCustomer extends JPanel {

    private JButton btnAllProducts;
    private JButton btnSaleProducts;

    public AddProductsCustomer(){
        createElements();
        addElements();
    }

    private void createElements(){
        btnAllProducts = new JButton("Alla produkter");
        btnSaleProducts = new JButton("Reaprodukter");
    }

    private void addElements(){
        add(btnAllProducts);
        add(btnSaleProducts);
    }

}
