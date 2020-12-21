package view;

import control.Controller;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        this.customerPanel = new CustomerPanel(this);
        this.customerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
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

    public void addDiscount() {
        controller.adminAddDiscount();
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
        add(customerPanel, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    // Ritar upp adminpanelen
    public void showAdminPanel() {
        removeAll();
        // add(new AdminPanel(), BorderLayout.CENTER);
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


    public String getSearchProductCode() {
        return customerPanel.getPanelProducts().getSearchProductPanel().getTxtProductCode();
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
    public void presentTableProducts(String[][] productsDataTable) {
        customerPanel.getPanelProducts().presentTableProducts(productsDataTable);
    }



    public void test() {
        adminPanel.getPanelSuppliers().getPnlAddSupplier().getTxtName();
        adminPanel.getPanelDiscount().getPnlAddDiscount().getTxtName();
        adminPanel.getPanelProducts().getSearchProductPanel().getTxtProductName();


    }


}
