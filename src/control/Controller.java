package control;

import view.*;

import javax.swing.*;
import java.util.Date;


public class Controller {

    private MainFrame mainFrame;
    private MainPanel mainPanel;
    JdbcSQLServerConnection jdbc = new JdbcSQLServerConnection();

    private String user = "hej";
    private String password = "secret";

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
        String username  =  mainPanel.getUsernameFromLoginPanel();
        String password = mainPanel.getPasswordFromLoginPanel();
        jdbc.connectToDatabase(user, this.password);

        // Checks if admin exists in database
        if(username.length()==5){
            //login admin, jdbc
            if (jdbc.loginAdmin(username, password))
            {
                //Öppna adminpanel
                mainPanel.showAdminPanel();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect username or password, try again.");
            }
        }else if (username.contains("@")){

            //login costumer, jdbc
            if (jdbc.loginCustomer(username, password))
            {
                //Öppna adminpanel
                mainPanel.showCustomerPanel();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect username or password, try again.");
            }
        }
        else
        { JOptionPane.showMessageDialog(null, "Incorrect username or password, try again."); }
        jdbc.disconnectFromDatabase();

    }

    public void listAllSuppliers() {
        jdbc.connectToDatabase(user, password);
        //TODO

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

    public void adminAddDiscount() {

        int discountId = Integer.parseInt(mainPanel.getDiscountId());
        String discountName = mainPanel.getDiscountName();
        int discountPercent = Integer.parseInt(mainPanel.getDiscountPercent());
        //TODO - vilket format på datum?
        Date from;
        Date tom;

        jdbc.connectToDatabase(user, password);
        jdbc.addDiscount(discountId, discountName, discountPercent, from, tom);
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
        if(true) {
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

    public void listAllProducts() {
        jdbc.connectToDatabase(user, password);
        jdbc.listAllProducts();
        //TODO
        jdbc.disconnectFromDatabase();
    }

    public void searchUnconfirmedOrders() {
        jdbc.connectToDatabase(user, password);
        jdbc.searchUnconfirmedOrders();
        //TODO
        jdbc.disconnectFromDatabase();
    }

    public void orderHistory() {
        jdbc.connectToDatabase(user, password);
        //jdbc.orderHistory();
        //TODO
        jdbc.disconnectFromDatabase();
    }

}
