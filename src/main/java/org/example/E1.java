package org.example;

import java.sql.*;

public class E1 {
    public static void main(String[] args) {
/*
jdbc => api that we are planning to use from java
mysql=> name of the database to which we are connecting
3.239.253.255 => address of the computer that as our database
3306=> port of the application
syntaxhrm_mysql => name of the database
 */

        String dbURL = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            // Helps us establish the connection
            Connection connection = DriverManager.getConnection(dbURL, userName, password);
            // helps us take the query on the db server execute it bring the results back
            Statement statement = connection.createStatement();
            String query = "select * from person";
            // This method executes the query and returns the results back in the form of a resultSet
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String firstname=resultSet.getString("firstname");
                int age=resultSet.getInt("age");
                String city=resultSet.getString("city");
                System.out.println(firstname+" "+age+" "+city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}