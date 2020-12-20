package control;

import view.*;

import java.awt.*;


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

    public void login() {
        String username  =  mainPanel.getUsernameFromLoginPanel();
        String password = mainPanel.getPasswordFromLoginPanel();
        jdbc.connectToDatabase(user, password);
        if(username.length()==5 && username.contains("@")){
            //login admin, jdbc
        }else{
            //login costumer, jdbc
        }
        jdbc.disconnectFromDatabase();

    }

    public void listAllSuppliers() {
        jdbc.connectToDatabase(user, password);
        //TODO

        jdbc.disconnectFromDatabase();

    }

    public void adminAddSupplier() {
        jdbc.connectToDatabase(user, password);
        //TODO
        //jdbc.addSupplier();
        jdbc.disconnectFromDatabase();
    }

    public void adminAddProduct() {
        jdbc.connectToDatabase(user, password);
        //jdbc.addProduct();
        jdbc.disconnectFromDatabase();
    }

    public void adminAddDiscount() {
        String discountName = mainPanel.getDiscountName();
        String discountId = mainPanel.getDiscountId();
        String discountPercent = mainPanel.getDiscountPercent();

        jdbc.connectToDatabase(user, password);
        //TODO
        //jdbc.addDiscount();
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
