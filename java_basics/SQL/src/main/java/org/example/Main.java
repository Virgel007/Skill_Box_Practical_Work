package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main
{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "Arkadiy722983";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, count(course_name) as number_of_sale, \n" +
                    "(max(month(subscription_date)) - min(month(subscription_date)-1)) as months_on_sale,\n" +
                    "round(count(course_name) / (max(month(subscription_date)) - min(month(subscription_date)-1)),2) as average_number_of_sale_per_month\n" +
                    "FROM skillbox.purchaselist WHERE  month(subscription_date) in(1,2,3,4,5,6,7,8,9) group by course_name;");

            while (resultSet.next()) {
                String name = resultSet.getString("course_name");
                String column_1 = resultSet.getString("number_of_sale");
                String column_2 = resultSet.getString("months_on_sale");
                String column_3 = resultSet.getString("average_number_of_sale_per_month");
                System.out.println("course_name: " + name +
                        " - number_of_sales: " + column_1 +
                        " - months_on_sale: " + column_2 +
                        " - average_number_of_sales_per_month: " + column_3);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}