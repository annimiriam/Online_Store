package view.customer;

import view.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductsCustomer extends JPanel {

    private MainPanel mainPanel;
    private JButton btnAllProducts;
    private JButton btnSaleProducts;
    private JButton btnAddToChart;
    private JLabel lblNbrOfProducts;
    private JTextField txtNbrOfProducts;

    public AddProductsCustomer(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        createElements();
        addElements();
        addListeners();
    }

    private void createElements() {
        btnAllProducts = new JButton("Alla produkter");
        btnSaleProducts = new JButton("Reaprodukter");
        btnAddToChart = new JButton("Lägg till i kundvagn");
        lblNbrOfProducts = new JLabel("Antal produkter: ");
        txtNbrOfProducts = new JTextField();
        txtNbrOfProducts.setPreferredSize(new Dimension(30,20));

    }

    private void addElements() {
        add(btnAllProducts);
        add(btnSaleProducts);
        add(btnAddToChart);
        add(lblNbrOfProducts);
        add(txtNbrOfProducts);
    }

    private void addListeners() {

        btnAllProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.presentTableProducts(mainPanel.listAllProducts());
            }
        });

        btnSaleProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.presentTableProducts(mainPanel.listDiscountedProducts());
            }
        });
        btnAddToChart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.addToChart();
               // mainPanel.getShoppingListTotalPrice();
            }
        });

    }

    public int getNbrOfProductsToChart() {
        return Integer.parseInt(txtNbrOfProducts.getText());
    }

}
