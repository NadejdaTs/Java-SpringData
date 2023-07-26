package LabAccessWithJDBC;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "1024");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/diablo", prop);

        PreparedStatement statement = connection.prepareStatement("SELECT user_name, first_name, last_name, count(ug.id) as games_played FROM users u " +
                "JOIN users_games ug ON u.id = ug.user_id WHERE user_name = ?" +
                "GROUP BY ug.user_id");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        statement.setString(1, name);

        ResultSet rs = statement.executeQuery();

        if(rs.next()){
            String user_name = rs.getString("user_name");
            //String user_name11 = rs.getString(1);
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            int games = rs.getInt("games_played");
            System.out.printf("User: %s%n%s %s has played %d games%n", user_name, first_name, last_name, games);
        }else{
            System.out.println("No such user exists");
        }
    }
}
