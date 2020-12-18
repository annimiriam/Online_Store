package control;

import java.sql.*;

public class JdbcSQLServerConnection {

    private Connection connection;

    public JdbcSQLServerConnection(String user, String password) {
        try {
            connectToDatabase(user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connectToDatabase(String user, String password) throws ClassNotFoundException, SQLException {

        String dbURL = "jdbc:sqlserver://localhost;DatabaseName=OnlineStore";
        connection = DriverManager.getConnection(dbURL, user, password);

        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        if (connection != null) {
            System.out.println("connected do database: ");

            //Test query - printar kolumn 1-10 från tabellen customer
            testQuery(connection);
        }
    }

    public void testQuery(Connection conn) {

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " "
                        + rs.getString(2) + " "
                        + rs.getString(3) + " "
                        + rs.getString(4) + " "
                        + rs.getString(5) + " "
                        + rs.getString(6) + " "
                        + rs.getString(7) + " "
                        + rs.getString(8) + " "
                        + rs.getString(9) + " "
                        + rs.getString(10) + " "
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void addCustomer(String name, String phonenumber, String address, String password) {
        try {
            Statement statement = connection.createStatement();
            String query = "EXECUTE register_customer " + name + ", " + phonenumber + ", " + address + ", " + password + ";";
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println(resultSet.getString(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
