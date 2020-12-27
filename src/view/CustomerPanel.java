package view;

import view.customer.MyOrdersPanel;
import view.customer.ShoppingListPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomerPanel extends JPanel {

    private MyOrdersPanel panelMyOrders;
    private ProductPanel panelProducts;
    private ShoppingListPanel panelShoppinglist;
    private MainPanel mainPanel;

    public CustomerPanel(MainPanel mainPanel, DefaultTableModel myOrdersData, DefaultTableModel productdata) {
        this.mainPanel = mainPanel;
        panelMyOrders = new MyOrdersPanel(mainPanel, myOrdersData, productdata);
        panelProducts = new ProductPanel(mainPanel, productdata);
        panelShoppinglist = new ShoppingListPanel();

        setLayout(new BorderLayout());

        add(panelMyOrders, BorderLayout.WEST);
        add(panelProducts, BorderLayout.CENTER);
        add(panelShoppinglist, BorderLayout.EAST);
    }

    public ProductPanel getPanelProducts() {
        return panelProducts;
    }
// Metod eller metoder för att skicka meddelande från knapptrycken till controllern. Via MainPanel?

}
