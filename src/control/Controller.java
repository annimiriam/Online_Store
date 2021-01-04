package control;

import view.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Controller {

    private MainFrame mainFrame;
    private MainPanel mainPanel;
    JdbcSQLServerConnection jdbc = new JdbcSQLServerConnection();

    private String user = "hej";
    private String password = "secret";


    private String customer_email = "";
    private int customer_id;

    public Controller() {
        mainPanel = new MainPanel(this);
        mainFrame = new MainFrame(mainPanel);

        // Skapar ny koppling mot databas med användarnamn och lösen
    }

    // Kontrollerar angivet användarnamn och lösenord om admin eller kund
    public void checkLogin(String user, String password) {

    }


    // maximerar fönsterstorlek för att ge plats åt paneler
    public void setExtendedState() {
        mainFrame.setExtendedState(mainFrame.MAXIMIZED_BOTH);
    }


    //get called when you register and press the register button
    public void addCustomer() {

        String fName = mainPanel.getTxtFirstNameFromRegisterPanel();
        String lName = mainPanel.getTxtLastNameFromRegisterPanel();
        String email = mainPanel.getTxtEmailFromRegisterPanel();
        String address = mainPanel.getTxtAddressFromRegisterPanel();
        String postnbr = "";
        String city = mainPanel.getTxtCityFromRegisterPanel();
        String country = mainPanel.getTxtCountryFromRegisterPanel();
        String tel = mainPanel.getTxtPhonenumberFromRegisterPanel();
        String password1 = mainPanel.getTxtPasswordFromRegisterPanel();
        jdbc.registerCustomer(fName, lName, email, address, postnbr, city, country, tel, password1);
    }

    // Checks if user is an admin or customer and opens the corresponding panel if the user exists in database
    public void login() {
        String username = mainPanel.getUsernameFromLoginPanel();
        String password = mainPanel.getPasswordFromLoginPanel();
        jdbc.connectToDatabase(user, this.password);

        // Checks if admin exists in database
        if (username.length() == 5) {
            //login admin, jdbc
            if (jdbc.loginAdmin(username, password)) {
                //Open adminpanel
                mainPanel.showAdminPanel();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect username or password, try again.");
            }
        } else if (username.contains("@")) {

            //login costumer, jdbc
            if (jdbc.loginCustomer(username, password)) {
                customer_email = username; // Sparar kundens email för order referenser
                System.out.println("mejl: " + customer_email);
                customer_id = jdbc.getCustomerId(customer_email);
                System.out.println("customer id: " + customer_id);
                //Open customerpanel
                mainPanel.showCustomerPanel();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect username or password, try again.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect username or password, try again.");
        }
        jdbc.disconnectFromDatabase();

    }

    public void adminAddSupplier() {
        jdbc.connectToDatabase(user, password);

        String name = mainPanel.getTxtNameFromAddSupplierPanel();
        String address = mainPanel.getTxtAddressFromAddSupplierPanel();
        String postnbr = mainPanel.getTxtPostnbrFromAddSupplierPanel();
        String city = mainPanel.getTxtCityFromAddSupplierPanel();
        String country = mainPanel.getTxtCountryFromAddSupplierPanel();
        String phone = mainPanel.getTxtPhoneFromAddSupplierPanel();

        jdbc.addSupplier(name, address, postnbr, city, country, phone);

        jdbc.disconnectFromDatabase();
    }

    public void adminAddProduct() {
        jdbc.connectToDatabase(user, password);

        int id = Integer.parseInt(mainPanel.getTxtIdFromAddProductsPanel());
        String name = mainPanel.getTxtNameFromAddProductsPanel();
        double baseprice = Double.parseDouble(mainPanel.getTxtBasepriceFromAddProductsPanel());
        String supplier = mainPanel.getTxtSupplierFromAddProductsPanel();
        int qty = Integer.parseInt(mainPanel.getTxtQuantityFromAddProductsPanel());

        jdbc.addProduct(id, name, baseprice, supplier, qty);
        jdbc.disconnectFromDatabase();
    }

    // Adds a new discount
    public void adminAddDiscount() {

        int discountId = Integer.parseInt(mainPanel.getDiscountId());
        String discountName = mainPanel.getDiscountName();
        int discountPercent = Integer.parseInt(mainPanel.getDiscountPercent());
        int dateFrom = Integer.parseInt(mainPanel.getDiscountDateFrom());
        int  dateTo = Integer.parseInt(mainPanel.getDiscountDateTom());
        System.out.println("SQL date: " + dateFrom + ", " + dateTo);

        jdbc.connectToDatabase(user, password);
        jdbc.addDiscount(discountId, discountName, discountPercent, dateFrom, dateTo);
        jdbc.disconnectFromDatabase();

    }

    public void customerAddProductToOrder() {
        jdbc.connectToDatabase(user, password);

        //TODO
        //jdbc.addProductToOrder();
        jdbc.disconnectFromDatabase();
    }

    public void adminAssignDiscountToProduct() {
        jdbc.connectToDatabase(user, password);
        //TODO
        //jdbc.assignDiscountToProduct();
        jdbc.disconnectFromDatabase();

    }

    public void adminUpdateQuantity() {
        jdbc.connectToDatabase(user, password);
        //TODO
        //jdbc.updateQuantity();
        jdbc.disconnectFromDatabase();
    }

    public void adminDeleteProduct() {
        jdbc.connectToDatabase(user, password);
        //TODO
        //jdbc.deleteProduct();
        jdbc.disconnectFromDatabase();
    }

    public void registerCustomer() {
        jdbc.connectToDatabase(user, password);
        //TODO

        //jdbc.registerCustomer();
        if (true) {
            mainPanel.showCustomerPanel();
        }

        jdbc.disconnectFromDatabase();
    }

    public void searchProduct() {
        String productCode = mainPanel.getSearchProductCode();
        String productName = mainPanel.getSearchProductName();
        String supplier = mainPanel.getSearchSupplier();
        String price = mainPanel.getSearchPrice();

        jdbc.connectToDatabase(user, password);
        //jdbc.searchProduct();
        //TODO
        String[][] data = null; //get from jdbc
        mainPanel.presentTableProducts(data);
        jdbc.disconnectFromDatabase();
    }
    public DefaultTableModel listAllSuppliers() {
        DefaultTableModel datamodel = new DefaultTableModel(0,6);
        jdbc.connectToDatabase(user, password);

        ResultSet rs = jdbc.listAllSuppliers();
        try {

            while (rs.next()) {
                String[] data = {rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                };

                datamodel.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc.disconnectFromDatabase();
        return datamodel;
    }
    public DefaultTableModel listAllProducts() {
        DefaultTableModel datamodel = new DefaultTableModel(0,5);
        jdbc.connectToDatabase(user, password);

        ResultSet rs = jdbc.listAllProducts();
        try {

            while (rs.next()) {
                String[] data = {rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                };

                datamodel.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc.disconnectFromDatabase();
        return datamodel;
    }
    public DefaultTableModel listAllDiscounts(){
        DefaultTableModel datamodel = new DefaultTableModel(0,6);
        jdbc.connectToDatabase(user, password);

        ResultSet rs = jdbc.listAllDiscounts();
        try {

            while (rs.next()) {
                String[] data = {rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                };

                datamodel.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc.disconnectFromDatabase();
        return datamodel;
    }
    public DefaultTableModel listMyOrders(){
        DefaultTableModel datamodel = new DefaultTableModel(0,5);
        jdbc.connectToDatabase(user, password);

        ResultSet rs = jdbc.listMyOrders(customer_id);

        try {

            while (rs.next()) {
                String[] data = {rs.getString(1),
                        rs.getString(4),
                        rs.getString(5),
                };

                datamodel.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc.disconnectFromDatabase();
        return datamodel;
    }
    public DefaultTableModel listOrderDetails(int orderNbr){
        DefaultTableModel datamodel = new DefaultTableModel(0,3);
        jdbc.connectToDatabase(user, password);

        ResultSet rs = jdbc.listOrderDetails(orderNbr);
        System.out.println("Klickat ordernr: " + orderNbr);

        try {

            while (rs.next()) {
                String[] data = {rs.getString(2),
                        rs.getString(3),
                        rs.getString(3),
                };

                datamodel.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc.disconnectFromDatabase();
        return datamodel;
    }

    public DefaultTableModel searchUnconfirmedOrders() {

        DefaultTableModel datamodel = new DefaultTableModel(0,6);
        jdbc.connectToDatabase(user, password);

        ResultSet rs = jdbc.searchUnconfirmedOrders();
        try {

            while (rs.next()) {
                String[] data = {rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                };

                datamodel.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc.disconnectFromDatabase();
        return datamodel;

    }

    public void orderHistory() {
        jdbc.connectToDatabase(user, password);
        //jdbc.orderHistory();
        //TODO
        jdbc.disconnectFromDatabase();
    }

    //TODO: när denna anropas ska ordernumret skickas med viletk plockas från tabellen med ordrar
    public void confirmOrder(int orderNbr) {
        jdbc.connectToDatabase(user, password);
        jdbc.confirmOrder(orderNbr);
        // TODO: Uppdatera listan med ordrar så den konfirmerade ordern försvinner
        jdbc.disconnectFromDatabase();
    }


}
