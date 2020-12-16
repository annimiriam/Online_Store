package view.customer;

import javax.swing.*;

public class AddProductsCustomer extends JPanel {

    private JButton btnAllProducts;
    private JButton btnSaleProducts;

    public AddProductsCustomer(){
        createElements();
        addElements();
    }

    public void createElements(){
        btnAllProducts = new JButton("Alla produkter");
        btnSaleProducts = new JButton("Reaprodukter");
    }

    public void addElements(){
        add(btnAllProducts);
        add(btnSaleProducts);
    }

}
