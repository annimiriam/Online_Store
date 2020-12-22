package control;

import java.sql.*;

public class JdbcSQLServerConnection {

    private Connection connection;


    public JdbcSQLServerConnection() {
    }

    public void connectToDatabase(String user, String password) {
        String dbURL = "jdbc:sqlserver://localhost;DatabaseName=OnlineStore";
        try {
            connection = DriverManager.getConnection(dbURL, user, password);
            if (connection != null) {
                System.out.println("connected do database: ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnectFromDatabase() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet createStatementAndExecuteProcedure(String procedure) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("EXECUTE " + procedure);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //Procedures that add, delete and modify database

    public void addSupplier(String name, String tel, String address, String postnbr, String city, String country) {
        createStatementAndExecuteProcedure(
                "add_supplier "
                        + name + ", "
                        + tel + ", "
                        + address + ", "
                        + postnbr + ", "
                        + city + ", "
                        + country + ";"
        );
    }

    public void addProduct(int id, String name, double baseprice, String supplier, int qty) {
        createStatementAndExecuteProcedure(
                "add_procuct"
                        + id + ", "
                        + name + ", "
                        + baseprice + ", "
                        + supplier + ", "
                        + qty + ";"

        );
    }

    public void addDiscount(int id, String name, int percent, Date from, Date tom){
        createStatementAndExecuteProcedure(
                "add_discount "
                        + id + ", "
                        + name + ", "
                        + percent + ", "
                        + from + ", "
                        + tom + ";"
        );

    }

    public void addProductToOrder(int prodId, int orderId, int qty){
        createStatementAndExecuteProcedure(
                "add_product_to_order "
                        + prodId + ", "
                        + orderId + ", "
                        + qty + ";"
        );

    }

    public void assignDiscountToProduct(int prodId, int discId){
        createStatementAndExecuteProcedure(
                "add_discount "
                        + prodId + ", "
                        + discId + ";"
        );
    }

    public void updateQuantity(int prodId, int qty){
        createStatementAndExecuteProcedure(
                "add_supplier "
                        + prodId + ", "
                        +  qty + ";"
        );
    }

    public void deleteProduct(int prodId){
        createStatementAndExecuteProcedure(
                "delete_product "
                        + prodId + ";"
        );
    }

    public void registerCustomer(String firstName, String lastName, String email, String address, String postnbr, String city, String country, String tel, String password){
        createStatementAndExecuteProcedure(
                "add_procuct"
                        + firstName + ", "
                        + lastName + ", "
                        + email + ", "
                        + address + ", "
                        + postnbr + ", "
                        + city + ", "
                        + country + ","
                        + tel + ", "
                        + password + ";"
        );
    }

    // Checks if the username and password connected to an admin exists in the database
    public boolean loginAdmin(String username, String password)
    {
        int output = 0;
        int admin_id = Integer.parseInt(username);

        try (CallableStatement cstmt = connection.prepareCall("{? = call login_admin(?, ?)}");) {

            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setInt(2, admin_id);
            cstmt.setString(3, password);

            cstmt.execute();
            output = cstmt.getInt(1);
             }

        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        if (output == 1) {
            //Öppna Adminpanel
            System.out.println("Inloggning korrekt");
            return true;
        } else {
            //Felmeddelande
            System.out.println("Personen existerar inte i databasen");
            return false;
        }

    }

    // Checks if the username and password connected to a user exists in the database
    public boolean loginCustomer(String username, String password)
    {
        int output = 0;

        try (CallableStatement cstmt = connection.prepareCall("{? = call login_customer(?, ?)}");) {

            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, username);
            cstmt.setString(3, password);

            cstmt.execute();
            output = cstmt.getInt(1);
        }

        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        if (output == 1) {
            //Öppna Userpanel
            System.out.println("Inloggning korrekt, kund inloggad");
            return true;
        } else {
            //Felmeddelande
            System.out.println("Personen existerar inte i databasen");
            return false;
        }

    }

    //Procedures search in database

    //TODO - vet ej om denna kommer funka med tomma parametrar? Eller är de null?
    public void searchProduct(int prodId, String name, double maxPrice, String supplier){
        createStatementAndExecuteProcedure(
                "search_product "
                        + prodId + ", "
                        + name + ", "
                        + maxPrice + ", "
                        + supplier + ";"
        );

    }

    //TODO - måste vi ha en egen metod som har tomma parametrar?
    public void listAllProducts(){
        //createStatementAndExecuteProcedure();
    }

    public void searchUnconfirmedOrders(){
        ResultSet rs = createStatementAndExecuteProcedure("unconfirmed_orders");
        // TODO - sätt in resultatet i en objectsmatris som kan sättas i tabellen

    }

    public void orderHistory(int customerId){
        createStatementAndExecuteProcedure(
                "add_procuct"
                        + customerId + ";"
        );
    }


//    public void testQuery(Connection conn) {
//
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from customer");
//
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " "
//                        + rs.getString(2) + " "
//                        + rs.getString(3) + " "
//                        + rs.getString(4) + " "
//                        + rs.getString(5) + " "
//                        + rs.getString(6) + " "
//                        + rs.getString(7) + " "
//                        + rs.getString(8) + " "
//                        + rs.getString(9) + " "
//                        + rs.getString(10) + " "
//                );
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//    }

//    public void addCustomer(String name, String phonenumber, String address, String password) {
//        try {
//            Statement statement = connection.createStatement();
//            String query = "EXECUTE register_customer " + name + ", " + phonenumber + ", " + address + ", " + password + ";";
//            ResultSet resultSet = statement.executeQuery(query);
//            System.out.println(resultSet.getString(0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }


}
