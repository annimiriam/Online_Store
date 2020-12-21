package view;


import view.admin.AddProductsAdmin;
import view.admin.DiscountPanel;
import view.admin.SuppliersPanel;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {

    private SuppliersPanel panelSuppliers;
    private ProductPanel panelProducts;
    private AddProductsAdmin addProductsAdmin;
    private DiscountPanel panelDiscount;
    private MainPanel mainPanel;

    public AdminPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        panelSuppliers = new SuppliersPanel();
        panelProducts = new ProductPanel(mainPanel);
        panelDiscount = new DiscountPanel();

        setLayout(new BorderLayout());

        add(panelSuppliers, BorderLayout.WEST);
        add(panelProducts, BorderLayout.CENTER);
        add(panelDiscount, BorderLayout.EAST);

    }

    public SuppliersPanel getPanelSuppliers() {
        return panelSuppliers;
    }

    public ProductPanel getPanelProducts() {
        return panelProducts;
    }

    public DiscountPanel getPanelDiscount() {
        return panelDiscount;
    }

    public AddProductsAdmin getAddProductsAdmin() {
        return addProductsAdmin;
    }
}
