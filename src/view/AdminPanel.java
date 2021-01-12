package view;


import view.admin.AddProductsAdmin;
import view.admin.DiscountPanel;
import view.admin.SuppliersPanel;
import view.admin.UnconfirmedOrdersPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminPanel extends JPanel {

    private JPanel panelProductsLayout;
    private SuppliersPanel panelSuppliers;
    private ProductPanel panelProducts;
    private AddProductsAdmin panelAddProductsAdmin;
    private DiscountPanel panelDiscount;
    private MainPanel mainPanel;
    private UnconfirmedOrdersPanel panelUnconOrders;


    public AdminPanel(MainPanel mainPanel, DefaultTableModel supplierdata, DefaultTableModel productdata, DefaultTableModel discountdata, DefaultTableModel discountedProductsdata) {
        this.mainPanel = mainPanel;
        panelAddProductsAdmin = new AddProductsAdmin(mainPanel);
        panelSuppliers = new SuppliersPanel(mainPanel, supplierdata);
        panelProducts = new ProductPanel(mainPanel, productdata);
        panelDiscount = new DiscountPanel(mainPanel, discountdata, discountedProductsdata);
        panelProductsLayout = new JPanel(new BorderLayout());
        panelUnconOrders = new UnconfirmedOrdersPanel(mainPanel);

        setLayout(new BorderLayout());

        panelProductsLayout.add(panelProducts, BorderLayout.CENTER);
        panelProductsLayout.add(panelAddProductsAdmin, BorderLayout.SOUTH);

        add(panelSuppliers, BorderLayout.WEST);
        add(panelProductsLayout, BorderLayout.CENTER);
        add(panelDiscount, BorderLayout.EAST);
        add(panelUnconOrders, BorderLayout.SOUTH); //Här sklle jag vilja ha unconfimed orders istället i south.
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
        return panelAddProductsAdmin;
    }

    public void setSupplierTableData(DefaultTableModel updatedSupplierData) {
        panelSuppliers.setSupplierData(updatedSupplierData);
    }

    public void setProductTableData(DefaultTableModel updatedProductsData) {
        panelProducts.setProductData(updatedProductsData);

    }

    public void setDiscountTableData(DefaultTableModel updatedDiscountData) {
        panelDiscount.setDiscountTableData(updatedDiscountData);
    }





}
