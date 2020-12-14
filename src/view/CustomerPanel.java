package view;

import javax.swing.*;
import java.awt.*;

public class CustomerPanel extends JPanel {

    private MyOrdersPanel panelMyOrders;
    private ProductPanel panelProducts;
    private ShoppingListPanel panelShoppinglist;

    public CustomerPanel() {
        panelMyOrders = new MyOrdersPanel();
        panelProducts = new ProductPanel();
        panelShoppinglist = new ShoppingListPanel();

        setLayout(new BorderLayout());

        add(panelMyOrders, BorderLayout.WEST);
        add(panelProducts, BorderLayout.CENTER);
        add(panelShoppinglist, BorderLayout.EAST);
    }

    // Metod eller metoder för att skicka meddelande från knapptrycken till controllern. Via MainPanel?

}
