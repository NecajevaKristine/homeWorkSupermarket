package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnection {

        public static void main(String[] args) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeworksupermarket", "root", "0315");

                Statement stmt = con.createStatement();
                ResultSet purchase = stmt.executeQuery("SELECT * FROM products");

                while (purchase.next()) {
                    System.out.printf("productID %d productName:  %s productPrice: %s productWeight: %s productQuantity %s \n",
                            purchase.getInt(1), purchase.getString(2), purchase.getDouble(3), purchase.getDouble(4), purchase.getInt(5));
                }
                con.close();


            } catch (Exception e) {
                System.out.println(e);
            }

        }

}


