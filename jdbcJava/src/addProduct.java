

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class addProduct {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Pruduct";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pruduct", "root", "");

            String insertrecord = "CREATE TABLE Product (\n" +
                    "        id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "        name VARCHAR(255),\n" +
                    "price_per_unit DOUBLE,\n" +
                    "active_for_sell BOOLEAN\n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO Product (name, price_per_unit, active_for_sell) VALUES\n" +
                    "        ('Product A', 10.5, true),\n" +
                    "        ('Product B', 15.75, true),\n" +
                    "        ('Product C', 20.0, false);";

            Statement stmt = connection.createStatement();

            stmt.executeUpdate(insertrecord);

//            String query1 = "SELECT * FROM Pruduct";
//
//            Statement resultSet1 = connection.createStatement();
//
//            ResultSet rs = resultSet1.executeQuery(query1);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from Product");

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getDouble(3)
                        +" "+resultSet.getBoolean(4));
            }
            connection.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}