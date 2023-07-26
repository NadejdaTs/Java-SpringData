package ExAccessWithJDBC;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) throws SQLException {
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "1024");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", prop);

        Scanner sc = new Scanner(System.in);
        int villainId = Integer.parseInt(sc.nextLine());

        PreparedStatement villainStatement = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");

        villainStatement.setInt(1, villainId);
        ResultSet villainSet = villainStatement.executeQuery();

        if(!villainSet.next()){
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            return;
        }
        String villaintName = villainSet.getString("name");
        System.out.println("Villain: " + villaintName);

        PreparedStatement minionStatement = connection.prepareStatement("""
                SELECT name, age
                FROM minions as m
                JOIN minions_villains as mv ON m.id = mv.minion_id
                WHERE mv.villain_id = ?;
                """);
        minionStatement.setInt(1, villainId);
        ResultSet minionSet = minionStatement.executeQuery();
        for (int i = 1; minionSet.next(); i++) {
            String name = minionSet.getString("name");
            int age = minionSet.getInt("age");
            System.out.printf("%d. %s %d%n", i, name, age);
        }
    }
}
