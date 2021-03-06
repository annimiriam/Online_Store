package view;

import control.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;

public class MainPanel extends JPanel {
    private Controller controller;
    private LoginPanel loginPanel;
    private JPanel eastPanel;
    private RegisterPanel registerPanel;
    private AdminPanel adminPanel;
    private CustomerPanel customerPanel;
    private ProductPanel productPanel;
    private JPanel logOutPanel;
    private JButton logOutButton;

    public MainPanel(Controller controller) {
        this.controller = controller;
        this.loginPanel = new LoginPanel(this);
        this.registerPanel = new RegisterPanel(this);
        eastPanel = new JPanel(new BorderLayout());
        createLogOutPanel();
        setLayout(new BorderLayout());
        add(eastPanel, BorderLayout.EAST);
        eastPanel.add(loginPanel, BorderLayout.NORTH);
        eastPanel.setPreferredSize(new Dimension(400,200));
        productPanel = new ProductPanel(this, controller.listAllProducts());
        add(productPanel,BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(1200, 600));
    }

   public void createLogOutPanel(){
        logOutPanel = new JPanel(new BorderLayout());
        logOutButton = new JButton("Log out");
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.logOut();
            }
        });
        JPanel panel = new JPanel(new BorderLayout());
        logOutPanel.add(panel,BorderLayout.NORTH);
        panel.add(logOutButton, BorderLayout.EAST);
    }
   public void updateProductQty(){
        controller.updateProductQty();
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

    public DefaultTableModel listAllProducts(){
        return controller.listAllProducts();
    }
    public DefaultTableModel listDiscountedProducts(){
        return controller.listDiscountedProducts();
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
        eastPanel.removeAll();
        eastPanel.add(loginPanel, BorderLayout.NORTH);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(registerPanel, BorderLayout.NORTH);
        eastPanel.add(panel, BorderLayout.CENTER);
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
        logOutPanel.add(customerPanel, BorderLayout.CENTER);
        add(logOutPanel, BorderLayout.CENTER);
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
                controller.listAllDiscounts(), controller.listAllDiscountedProducts()
        );
        logOutPanel.add(adminPanel, BorderLayout.CENTER);
        add(logOutPanel, BorderLayout.CENTER);

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

    public void deleteProduct(int productId) {
        controller.adminDeleteProduct(productId);
        adminPanel.setProductTableData(controller.listAllProducts());
        adminPanel.getPanelProducts().clearSelectionInTable();
    }

    public void getShoppingListTotalPrice()
    {
        double totalPrice = controller.getShoppingListTotalPrice();
        customerPanel.getPanelShoppinglist().updateTotalPrice(totalPrice);
    }

    public void getSelectedProduct(String id, String name, String qty) {
        if (adminPanel != null) {
            adminPanel.getAddProductsAdmin().setSelectedProduct(id, name, qty);
        }
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

    public int getChosenDiscountId()
    { return adminPanel.getPanelDiscount().getChosenDiscountId();}

    public void giveProductDiscount(int discountId, int productId)
    {
        controller.adminAssignDiscountToProduct(discountId,productId);
        adminPanel.setDiscountedProductsTableData(controller.listAllDiscountedProducts());
    }

    public void addDiscount() {
        controller.adminAddDiscount();
        adminPanel.setDiscountTableData(controller.listAllDiscounts());

    }

    public DefaultTableModel getUnconfirmedOrders()
    {
        return controller.searchUnconfirmedOrders();
    }

    public DefaultTableModel getMostSoldProducts()
    {
        return controller.getMostSoldProducts();
    }

    public String getSearchProductCode() {
        if (customerPanel!=null) {
            return customerPanel.getPanelProducts().getSearchProductPanel().getTxtProductCode();
        } else if (adminPanel != null){
            return adminPanel.getPanelProducts().getSearchProductPanel().getTxtProductCode();
        } else {
            return productPanel.getSearchProductPanel().getTxtProductCode();
        }
    }

    /**
     * @return
     */
    public String getSearchProductName() {

        if (customerPanel!=null) {
            return customerPanel.getPanelProducts().getSearchProductPanel().getTxtProductName();
        } else if(adminPanel != null){
            return adminPanel.getPanelProducts().getSearchProductPanel().getTxtProductName();
        } else {
            return productPanel.getSearchProductPanel().getTxtProductName();
        }

    }

    /**
     * @return
     */
    public String getSearchSupplier() {

        if (customerPanel!=null) {
            return customerPanel.getPanelProducts().getSearchProductPanel().getTxtSupplier();
        } else if(adminPanel != null){
            return adminPanel.getPanelProducts().getSearchProductPanel().getTxtSupplier();
        } else {
            return productPanel.getSearchProductPanel().getTxtSupplier();
        }

    }

    /**
     * @return
     */
    public String getSearchPrice() {
        if (customerPanel!=null) {
            return customerPanel.getPanelProducts().getSearchProductPanel().getTxtPrice();
        } else if(adminPanel != null){
            return adminPanel.getPanelProducts().getSearchProductPanel().getTxtPrice();
        } else {
            return productPanel.getSearchProductPanel().getTxtPrice();
        }

    }

    /**
     * @param productsDataTable
     */
    public void presentTableProducts(DefaultTableModel productsDataTable) {

        if (customerPanel!=null) {
        customerPanel.getPanelProducts().setProductData(productsDataTable);
        } else if(adminPanel != null){
             adminPanel.getPanelProducts().setProductData(productsDataTable);
        } else {
             productPanel.setProductData(productsDataTable);
        }

    }

    public void clearAddProductPanel(){
        adminPanel.getAddProductsAdmin().clear();
    }

    /**
     *
     */

    public DefaultTableModel getOrderDetails(int orderNbr) {
        return controller.listOrderDetails(orderNbr);
    }

    public void deleteUnconfirmedOrderCustomer(int orderNbr)
    {
        controller.customerDeleteUnconfirmedOrder(orderNbr);
        customerPanel.setOrderTableData(controller.listMyOrders());
        customerPanel.getPanelProducts().setProductData(controller.listAllProducts());
        customerPanel.getPanelMyOrders().setOrderDetailsData(new DefaultTableModel());
    }

    public DefaultTableModel getMyOrders()
    {
        return controller.listMyOrders();
    }

    public void test() {
        adminPanel.getPanelSuppliers().getPnlAddSupplier().getTxtName();
        adminPanel.getPanelDiscount().getPnlAddDiscount().getTxtName();
        adminPanel.getPanelProducts().getSearchProductPanel().getTxtProductName();
    }
    public void addToChart() {
        int productID = customerPanel.getPanelProducts().getSelectedProduct();
        int nbrOfProducts = customerPanel.getPanelAddProductsCustomer().getNbrOfProductsToChart();
        controller.customerAddProductToOrder(productID, nbrOfProducts);
        customerPanel.getPanelShoppinglist().setNewOrderData(controller.listNewOrder());
        customerPanel.getPanelProducts().setProductData(controller.listAllProducts());

    }

    public void makeOrder()
    {
        controller.makeOrder();

        customerPanel.setOrderTableData(controller.listMyOrders());
    }


}
