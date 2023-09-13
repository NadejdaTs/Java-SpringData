package ExAccessWithJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) throws SQLException {
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "1024");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", prop);

        Scanner sc = new Scanner(System.in);
        String country = sc.nextLine();

        PreparedStatement updateTown = connection.prepareStatement("""
                    UPDATE towns
                    SET name = upper(name)
                    WHERE country = ?;
                    """);
        updateTown.setString(1, country);
        int count = updateTown.executeUpdate();

        if(count > 0){
            System.out.printf("%d town names were affected.%n", count);
            PreparedStatement selectTowns = connection.prepareStatement("""
                    SELECT name FROM towns WHERE country = ?;
                    """);
            selectTowns.setString(1, country);
            ResultSet townsSet = selectTowns.executeQuery();

            List<String> towns = new ArrayList<>();
            System.out.print("[");
            while(townsSet.next()){
                String townName = townsSet.getString("name");
                towns.add(townName);
            }
            System.out.print(String.join(", ", towns));
            System.out.print("]");
        }else{
            System.out.println("No town names were affected.");
        }
    }
}
