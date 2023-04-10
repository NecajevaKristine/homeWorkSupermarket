import java.sql.*;

public class Database {
    private static final String dbURL = "jdbc:mysql://localhost:3306/homeworksupermarket";
    private static final String user ="root" ;
    private static final String password ="0315";


    public static void registerUser (Connection connection, String userName, String userPassword) throws SQLException {

        String sql = "INSERT INTO users (userName, userPassword) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,userName);
        statement.setString(2, userPassword);

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
}
