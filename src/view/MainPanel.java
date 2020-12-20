package view;

import control.Controller;

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

   public void addDiscount(){
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

    public String getSearchProductCode() {
        return customerPanel.getPanelProducts().getSearchProductPanel().getTxtProductCode();
    }

    /**
     *
     * @return
     */
    public String getSearchProductName() {
        return customerPanel.getPanelProducts().getSearchProductPanel().getTxtProductName();
    }

    /**
     *
     * @return
     */
    public String getSearchSupplier() {
        return customerPanel.getPanelProducts().getSearchProductPanel().getTxtSupplier();
    }

    /**
     *
     * @return
     */
    public String getSearchPrice() {
        return customerPanel.getPanelProducts().getSearchProductPanel().getTxtPrice();
    }

    /**
     *
     * @param productsDataTable
     */
    public void presentTableProducts(String[][] productsDataTable) {
        customerPanel.getPanelProducts().presentTableProducts(productsDataTable);
    }

    public String getDiscountName() {
        return adminPanel.getPanelDiscount().getPnlAddDiscount().getTxtName();
    }

    public String getDiscountId() {
        return adminPanel.getPanelDiscount().getPnlAddDiscount().getTxtId();
    }

    public String getDiscountPercent() {
        return adminPanel.getPanelDiscount().getPnlAddDiscount().getTxtPercent();
    }


    public void test() {
        adminPanel.getPanelSuppliers().getPnlAddSupplier().getTxtName();
        adminPanel.getPanelDiscount().getPnlAddDiscount().getTxtName();
        adminPanel.getPanelProducts().getSearchProductPanel().getTxtProductName();


    }


}
