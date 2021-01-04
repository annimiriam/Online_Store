package view;

import control.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainPanel extends JPanel {
    private Controller controller;
    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;
    private AdminPanel adminPanel;
    private CustomerPanel customerPanel;

    public MainPanel(Controller controller) {
        this.controller = controller;
        this.loginPanel = new LoginPanel(this);
        this.registerPanel = new RegisterPanel(this);
        setLayout(new BorderLayout());
        add(loginPanel, BorderLayout.NORTH);
        this.setPreferredSize(new Dimension(500, 300));
    }

    /**
     *
     */
    public void login() {
        controller.login();
    }

    /**
     *
     */
    public void search() {
        controller.searchProduct();
    }

    public void confirmOrder(int orderNbr) {
        controller.confirmOrder(orderNbr);
    }

    //TODO kanske inte ska finnas sedan när vi får det andra att funka
    public void checkLogin(String user, String password) {


        if (user.equals("admin") && password.equals("admin")) {
            System.out.println("admin inloggad");
            showAdminPanel();
        } else if (user.equals("kund") && password.equals("kund")) {
            System.out.println("kund inloggad");
            showCustomerPanel();
        }
        controller.setExtendedState();
    }

    /**
     *
     */
    public void registerCustomer() {
        controller.registerCustomer();
    }

    // Visar registrera-kund-panelen
    public void showRegisterCustomerPanel() {
        add(registerPanel, BorderLayout.SOUTH);
        repaint();

        revalidate();
        //pack();
    }

    // Ritar upp kundpanelen
    public void showCustomerPanel() {
        removeAll();
        controller.setExtendedState();
        customerPanel = new CustomerPanel(this,
                controller.listMyOrders(),
                controller.listAllProducts());
        add(customerPanel, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    // Ritar upp adminpanelen
    public void showAdminPanel() {
        removeAll();
        controller.setExtendedState();
        adminPanel = new AdminPanel(this,
                controller.listAllSuppliers(),
                controller.listAllProducts(),
                controller.listAllDiscounts()
        );
        add(adminPanel, BorderLayout.CENTER);

        repaint();
        revalidate();
    }

    // Get-metoder för textinput från LoginPanelen
    public String getUsernameFromLoginPanel() {
        return loginPanel.getTxtUsername();
    }

    public String getPasswordFromLoginPanel() {
        return loginPanel.getTxtPassword();
    }

    //Get-metoder för textinput från RegisterPanelen
    public String getTxtFirstNameFromRegisterPanel() {
        return registerPanel.getTxtFirstName();
    }

    public String getTxtLastNameFromRegisterPanel() {
        return registerPanel.getTxtLastName();
    }

    public String getTxtEmailFromRegisterPanel() {
        return registerPanel.getTxtEmail();
    }

    public String getTxtPasswordFromRegisterPanel() {
        return registerPanel.getTxtPassword();
    }

    public String getTxtAddressFromRegisterPanel() {
        return registerPanel.getTxtAddress();
    }

    public String getTxtCityFromRegisterPanel() {
        return registerPanel.getTxtCity();
    }

    public String getTxtCountryFromRegisterPanel() {
        return registerPanel.getTxtCountry();
    }

    public String getTxtPhonenumberFromRegisterPanel() {
        return registerPanel.getTxtPhonenumber();
    }

    //Get-metoder för textinput från SupplierPanelen
    public String getTxtNameFromAddSupplierPanel() {
        return adminPanel.getPanelSuppliers().getPnlAddSupplier().getTxtName();
    }

    public String getTxtAddressFromAddSupplierPanel() {
        return adminPanel.getPanelSuppliers().getPnlAddSupplier().getTxtAddress();
    }

    public String getTxtPostnbrFromAddSupplierPanel() {
        return adminPanel.getPanelSuppliers().getPnlAddSupplier().getTxtPostnbr();
    }

    public String getTxtCityFromAddSupplierPanel() {
        return adminPanel.getPanelSuppliers().getPnlAddSupplier().getTxtCity();
    }

    public String getTxtCountryFromAddSupplierPanel() {
        return adminPanel.getPanelSuppliers().getPnlAddSupplier().getTxtCountry();
    }

    public String getTxtPhoneFromAddSupplierPanel() {
        return adminPanel.getPanelSuppliers().getPnlAddSupplier().getTxtPhone();
    }

    public void addSupplier() {
        controller.adminAddSupplier();

        //Uppdaterar tabellen med den tillagda leverantören
        adminPanel.setSupplierTableData(controller.listAllSuppliers());
    }

    //Get-metoder för textinput från AddProduct i SupplierPanelen
    public String getTxtIdFromAddProductsPanel() {
        return adminPanel.getAddProductsAdmin().getTxtId();
    }

    public String getTxtNameFromAddProductsPanel() {
        return adminPanel.getAddProductsAdmin().getTxtName();
    }

    public String getTxtBasepriceFromAddProductsPanel() {
        return adminPanel.getAddProductsAdmin().getTxtBaseprice();
    }

    public String getTxtSupplierFromAddProductsPanel() {
        return adminPanel.getAddProductsAdmin().getTxtSupplier();
    }

    public String getTxtQuantityFromAddProductsPanel() {
        return adminPanel.getAddProductsAdmin().getTxtQuantity();
    }

    public void addProduct() {
        controller.adminAddProduct();
        adminPanel.setProductTableData(controller.listAllProducts());
    }

    public void getSelectedProduct(String id, String name, String qty) {
        adminPanel.getAddProductsAdmin().setSelectedProduct(id, name, qty);
    }


    //Get-metoder för textinput från AddDiscountPanelen
    public String getDiscountName() {
        return adminPanel.getPanelDiscount().getPnlAddDiscount().getTxtName();
    }

    public String getDiscountId() {
        return adminPanel.getPanelDiscount().getPnlAddDiscount().getTxtId();
    }

    public String getDiscountPercent() {
        return adminPanel.getPanelDiscount().getPnlAddDiscount().getTxtPercent();
    }

    public String getDiscountDateFrom()
    {        return adminPanel.getPanelDiscount().getPnlAddDiscount().getDateFrom();}

    public String getDiscountDateTom()
    {        return adminPanel.getPanelDiscount().getPnlAddDiscount().getDateTo();}

    public void addDiscount() {
        controller.adminAddDiscount();
        adminPanel.setDiscountTableData(controller.listAllDiscounts());
    }

    public DefaultTableModel getUnconfirmedOrders()
    {
        return controller.searchUnconfirmedOrders();
    }

    public String getSearchProductCode() {
        if (customerPanel!=null) {
            return customerPanel.getPanelProducts().getSearchProductPanel().getTxtProductCode();
        } else {
            return adminPanel.getPanelProducts().getSearchProductPanel().getTxtProductCode();
        }
    }

    /**
     * @return
     */
    public String getSearchProductName() {
        return customerPanel.getPanelProducts().getSearchProductPanel().getTxtProductName();
    }

    /**
     * @return
     */
    public String getSearchSupplier() {
        return customerPanel.getPanelProducts().getSearchProductPanel().getTxtSupplier();
    }

    /**
     * @return
     */
    public String getSearchPrice() {
        return customerPanel.getPanelProducts().getSearchProductPanel().getTxtPrice();
    }

    /**
     * @param productsDataTable
     */
    public void presentTableProducts(DefaultTableModel productsDataTable) {
        customerPanel.getPanelProducts().setProductData(productsDataTable);
    }


    /**
     *
     */

    public DefaultTableModel getOrderDetails(int orderNbr) {
        return controller.listOrderDetails(orderNbr);
    }

    public void test() {
        adminPanel.getPanelSuppliers().getPnlAddSupplier().getTxtName();
        adminPanel.getPanelDiscount().getPnlAddDiscount().getTxtName();
        adminPanel.getPanelProducts().getSearchProductPanel().getTxtProductName();


    }


}
