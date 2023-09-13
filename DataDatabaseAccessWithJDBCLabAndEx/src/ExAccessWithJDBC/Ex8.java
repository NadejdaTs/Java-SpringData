package ExAccessWithJDBC;

import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) throws SQLException {
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "1024");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", prop);

        Scanner sc = new Scanner(System.in);
        int[] idsOfMinions = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < idsOfMinions.length; i++) {
            PreparedStatement updateMinions = connection.prepareStatement("""
                    UPDATE minions m
                    SET m.name = lower(m.name), m.age = m.age + 1
                    WHERE m.id = ?;
                    """);
            int idsOfMinion = idsOfMinions[i];
            updateMinions.setInt(1, idsOfMinion);
            int test = updateMinions.executeUpdate();
        }
        PreparedStatement selectMinions = connection.prepareStatement("SELECT name, age FROM minions;");
        ResultSet minionsSet = selectMinions.executeQuery();

        while(minionsSet.next()) {
            String name = minionsSet.getString("name");
            int age = minionsSet.getInt("age");
            System.out.println(name + " " + age);
        }
    }
}
