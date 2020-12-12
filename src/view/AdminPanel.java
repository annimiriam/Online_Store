package view;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {
    private SuppliersPanel panelSuppliers;
    private ProductPanel panelProducts;
    private DiscountPanel panelDiscount;

    public AdminPanel (){
        panelSuppliers = new SuppliersPanel();
        panelProducts = new ProductPanel();
        panelDiscount = new DiscountPanel();

        setLayout(new BorderLayout());

        add(panelSuppliers, BorderLayout.WEST);
        add(panelProducts, BorderLayout.CENTER);
        add(panelDiscount, BorderLayout.EAST);
    }

}
