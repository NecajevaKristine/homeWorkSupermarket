import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class Database {
    private static final String dbURL = "jdbc:mysql://localhost:3306/homeworksupermarket";
    private static final String user ="root" ;
    private static final String password ="0315";
    private static Connection connection;


    public static void registerUser (Connection connection, String userName, Integer id, String userId) throws SQLException {

        String sql = "INSERT INTO users (userName, userId) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,userName);
        statement.setString(2, userId);

        int rowInserted = statement.executeUpdate();

        if (rowInserted > 0) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Sorry, something went wrong...");
        }
    }

    public static boolean logIn(Connection connection, String existingUserName) throws SQLException {

        String sql;
        try (Connection connection1 = DriverManager.getConnection(dbURL, user, password)) {
            sql = "SELECT userName FROM users WHERE userName = '"+ existingUserName+ "'";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void createProducts(Products products ) {
       String sql;
        try{
            sql = "INSERT INTO products (productName, productPrice, productWeight, productQuantity) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, products.getProductName());
            statement.setDouble(2, products.getPrice());
            statement.setDouble(3, products.getWeight());
            statement.setInt(4, products.getQuantity());

            int rowInserted = statement.executeUpdate();

            if (rowInserted > 0) {
                System.out.println("Product created successfully!");
            } else {
                System.out.println("Sorry, something went wrong...");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Products>getAllProducts()throws SQLException{
        ArrayList<Products> products = new ArrayList<>();
        try{
            String sql = "SELECT * FROM products";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                products.add(this.createProductsFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    private Products createProductsFromResultSet(ResultSet resultSet) {
        return null;
    }


}

