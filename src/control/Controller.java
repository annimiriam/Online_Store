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
//        mainPanel = new MainPanel(new LoginPanel(this));
//        mainFrame = new MainFrame(mainPanel);

        // Skapar ny koppling mot databas med användarnamn och lösen
    }

    // Kontrollerar angivet användarnamn och lösenord om admin eller kund
    public void checkLogin(String user, String password) {
        if (user.equals("admin") && password.equals("admin")) {
            System.out.println("admin inloggad");
            showAdminPanel();
        } else if (user.equals("kund") && password.equals("kund")) {
            System.out.println("kund inloggad");
            showCustomerPanel();
        }
        mainFrame.setExtendedState(mainFrame.MAXIMIZED_BOTH); // maximerar fönsterstorlek för att ge plats åt paneler
    }

    // Visar registrera-kund-panelen
    public void showRegisterCustomerPanel() {
        mainPanel.add(new RegisterPanel(this), BorderLayout.SOUTH);
        mainPanel.repaint();
        mainPanel.revalidate();
        mainFrame.pack();
    }

    // Ritar upp kundpanelen
    public void showCustomerPanel() {
        mainPanel.removeAll();
        mainPanel.add(new CustomerPanel(), BorderLayout.CENTER);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    // Ritar upp adminpanelen
    public void showAdminPanel() {
        mainPanel.removeAll();
        mainPanel.add(new AdminPanel(), BorderLayout.CENTER);
        mainPanel.repaint();
        mainPanel.revalidate();
    }


    //get called when you register and press the register button
    public void addCustomer() {

        String fName = mainPanel.getTxtFirstNameFromRegisterPanel();
        String lName = mainPanel.getTxtLastNameFromRegisterPanel();
        String email = mainPanel.getTxtEmailFromRegisterPanel();
        String address = mainPanel.getTxtAddressFromRegisterPanel();

        String city = mainPanel.getTxtCityFromRegisterPanel();
        String country = mainPanel.getTxtCountryFromRegisterPanel();
        String tel = mainPanel.getTxtPhonenumberFromRegisterPanel();
        String password1 = mainPanel.getTxtPasswordFromRegisterPanel();
        jdbc.registerCustomer(fName, lName, email, address, postnbr, city, country, tel, password1);
    }

    public void loginCustomer() {
        jdbc.connectToDatabase(user, password);
        // kod
        jdbc.disconnectFromDatabase();

    }

    public void listAllSuppliers() {
        jdbc.connectToDatabase(user, password);

        jdbc.disconnectFromDatabase();
    }

    public void adminAddSupplier(){
        jdbc.connectToDatabase(user, password);
        jdbc.addSupplier();
        jdbc.disconnectFromDatabase();
    }

    public void adminAddProduct() {
        jdbc.connectToDatabase(user, password);
        jdbc.addProduct();
        jdbc.disconnectFromDatabase();
    }

    public void adminAddDiscount() {
        jdbc.connectToDatabase(user, password);
        jdbc.addDiscount();
        jdbc.disconnectFromDatabase();

    }

    public void customerAddProductToOrder(){
        jdbc.connectToDatabase(user, password);
        jdbc.addProductToOrder();
        jdbc.disconnectFromDatabase();
    }

    public void adminAssignDiscountToProduct() {
        jdbc.connectToDatabase(user, password);
        jdbc.assignDiscountToProduct();
        jdbc.disconnectFromDatabase();

    }

    public void adminUpdateQuantity(){
        jdbc.connectToDatabase(user, password);
        jdbc.updateQuantity();
        jdbc.disconnectFromDatabase();
    }

    public void adminDeleteProduct(){
        jdbc.connectToDatabase(user, password);
        jdbc.deleteProduct();
        jdbc.disconnectFromDatabase();
    }

    public void registerCustomer(){
        jdbc.connectToDatabase(user, password);
        jdbc.registerCustomer();
        jdbc.disconnectFromDatabase();
    }

    public void searchProduct(){
        jdbc.connectToDatabase(user, password);
        jdbc.searchProduct();
        jdbc.disconnectFromDatabase();
    }

    public void listAllProducts(){
        jdbc.connectToDatabase(user, password);
        jdbc.listAllProducts();
        jdbc.disconnectFromDatabase();
    }

    public void searchUnconfirmedOrders(){
        jdbc.connectToDatabase(user, password);
        jdbc.searchUnconfirmedOrders();
        jdbc.disconnectFromDatabase();
    }

    public void orderHistory(){
        jdbc.connectToDatabase(user, password);
        jdbc.orderHistory();
        jdbc. disconnectFromDatabase();
    }


}
