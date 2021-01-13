package view;

import view.customer.AddProductsCustomer;
import view.customer.MyOrdersPanel;
import view.customer.ShoppingListPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomerPanel extends JPanel {

    private JPanel panelProductsLayout;
    private AddProductsCustomer panelAddProducts;
    private MyOrdersPanel panelMyOrders;
    private ProductPanel panelProducts;
    private ShoppingListPanel panelShoppinglist;
    private MainPanel mainPanel;

    public CustomerPanel(MainPanel mainPanel, DefaultTableModel myOrdersData, DefaultTableModel productdata) {
        this.mainPanel = mainPanel;
        panelMyOrders = new MyOrdersPanel(mainPanel, myOrdersData, productdata);
        panelProducts = new ProductPanel(mainPanel, productdata);
        panelShoppinglist = new ShoppingListPanel(mainPanel);
        panelAddProducts = new AddProductsCustomer(this.mainPanel);
        panelProductsLayout = new JPanel(new BorderLayout());

        setLayout(new BorderLayout());

        panelProductsLayout.add(panelProducts, BorderLayout.CENTER);
        panelProductsLayout.add(panelAddProducts, BorderLayout.SOUTH);
        add(panelMyOrders, BorderLayout.WEST);
        add(panelProductsLayout, BorderLayout.CENTER);
        add(panelShoppinglist, BorderLayout.EAST);
    }

    public void setProductTableData(DefaultTableModel updatedProductsData) {
        panelProducts.setProductData(updatedProductsData);

    }

    public void setOrderTableData(DefaultTableModel updatedProductsData) {
        panelMyOrders.setOrderTableData(updatedProductsData);

    }
    public ProductPanel getPanelProducts() {
        return panelProducts;
    }

    public AddProductsCustomer getPanelAddProductsCustomer() {
        return panelAddProducts;
    }

    public ShoppingListPanel getPanelShoppinglist(){
        return panelShoppinglist;
    }

    public MyOrdersPanel getPanelMyOrders() {
        return panelMyOrders;
    }
}
