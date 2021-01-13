package control;

import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JdbcSQLServerConnection {

    private Connection connection;


    public JdbcSQLServerConnection() {
    }

    public void connectToDatabase(String user, String password) {
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=OnlineStore";
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
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("EXECUTE add_supplier '"
                    + name + "', "
                    + tel + ", '"
                    + address + "', "
                    + postnbr + ", "
                    + city + ", "
                    + country + ";");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addProduct(int id, String name, double baseprice, String supplier, int qty) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("EXECUTE add_product "
                    + id + ", "
                    + name + ", "
                    + baseprice + ", "
                    + supplier + ", "
                    + qty + ";");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "Leverantören finns ej");
            //System.out.println("Leverantören finns inte");
        }
    }


    public void addDiscount(int id, String name, int percent, int from, int tom) {
        System.out.println("lägga till " + id);
        createStatementAndExecuteProcedure(
                "add_discount "
                        + id + ", "
                        + name + ", "
                        + percent + ", "
                        + from + ", "
                        + tom + ";"
        );
    }

    // Creates a new order when a customer is signed in
    public int newOrder(int customerID) {

        DateFormat df = new SimpleDateFormat("yyMMdd");
        String date = df.format(new java.util.Date());
        System.out.println("Todays date: " + date);

        ResultSet rs = createStatementAndExecuteProcedure(
                "new_order "
                        + customerID + ", "
                        + "unordered, '"
                        + date + "';"
        );

        try {

            while (rs.next()) {
                System.out.println("Här är vad som kommer ut rs ny order: " + rs.getInt(1));
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;

    }

    public void addProductToOrder(int orderId, int prodId, int qty) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("EXECUTE add_product_to_order "
                    + orderId + ", "
                    + prodId + ", "
                    + qty + ";");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String checkOrderStatus(int orderNbr) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select status from orders where id = " + orderNbr + ";");
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public double checkShoppingListTotalPrice(int orderNbr) {
        ResultSet rs = createStatementAndExecuteProcedure(
                "price_of_shoppinglist "
                        + orderNbr + ";"
        );
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                return Double.parseDouble(rs.getString(1));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    public void deleteUnconfirmedOrder(int orderNbr) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("EXECUTE " + "delete_order "
                    + orderNbr + ";");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void assignDiscountToProduct(int discId, int prodId) {

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.executeQuery("EXECUTE assign_discount_to_product "
                    + prodId + ", "
                    + discId + ";"
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void updateQuantity(int prodId, int qty) {
        createStatementAndExecuteProcedure(
                "change_quantity_of_product "
                        + prodId + ", "
                        + qty + ";"
        );
    }

    public void deleteProduct(int prodId) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("EXECUTE delete_product "
                    + prodId + ";"
            );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Statementet returnear inget resultset men det gör inget");
            //JOptionPane.showMessageDialog(null, "Produkten går inte att ta bort");
        }


    }

    public int registerCustomer(String firstName, String lastName, String email, String address, String postnbr, String city, String country, String tel, String password) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.executeQuery(
                    "register_customer "
                            + firstName + ", "
                            + lastName + ", '"
                            + email + "', '"
                            + address + "', "
                            + postnbr + ", "
                            + city + ", "
                            + country + ","
                            + tel + ", "
                            + password + ";");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return getCustomerId(email);
    }

    // Checks if the username and password connected to an admin exists in the database
    public boolean loginAdmin(String username, String password) {
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
    public boolean loginCustomer(String username, String password) {
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

    public int getCustomerId(String username) {
        ResultSet rs = createStatementAndExecuteProcedure(
                "getCustomerId '"
                        + username + "';"
        );
        try {

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //Procedures search in database

    //TODO - vet ej om denna kommer funka med tomma parametrar? Eller är de null?
    public ResultSet searchProduct(int prodId, String name, double maxPrice, String supplier) {
        ResultSet rs = createStatementAndExecuteProcedure(
                "search_product "
                        + "@product_id = " + prodId + ", "
                        + "@product_name = '" + name + "', "
                        + "@maxprice = " + maxPrice + ", "
                        + "@supplier_name = '" + supplier + "';"
        );

        return rs;
    }

    public ResultSet listAllProducts() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("list_all_products;");
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet listDiscountedProducts() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("list_discounted_products;");
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet listAllSuppliers() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM supplier");
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet listAllDiscounts() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM discount");
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet listAllDiscountedProducts() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("EXECUTE list_all_product_discounts;");
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet listMyOrders(int customerNbr) {
        ResultSet rs = createStatementAndExecuteProcedure(
                "order_history "
                        + customerNbr + ";"
        );
        return rs;
    }

    public ResultSet listOrderDetails(int orderNbr) {
        ResultSet rs = createStatementAndExecuteProcedure(
                "order_details "
                        + orderNbr + ";"
        );
        return rs;
    }

    public ResultSet searchUnconfirmedOrders() {
        ResultSet rs = createStatementAndExecuteProcedure("unconfirmed_orders");
        return rs;
    }

    public ResultSet getMostSoldProducts() {
        ResultSet rs = createStatementAndExecuteProcedure("most_sold_product");
        return rs;
    }

    // Confirms an order
    public void confirmOrder(int orderNbr) {
        ResultSet rs = createStatementAndExecuteProcedure("confirm_order " + orderNbr);
    }

    public void orderHistory(int customerId) {
        createStatementAndExecuteProcedure(
                "add_procuct"
                        + customerId + ";"
        );
    }

    public void makeOrder(int orderNbr) {
        createStatementAndExecuteProcedure(
                "make_order "
                        + orderNbr + ";"
        );
    }


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
