package ExAccessWithJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) throws SQLException {
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "1024");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", prop);

        Scanner sc = new Scanner(System.in);
        int id = Integer.parseInt(sc.nextLine());

        PreparedStatement selectVillain = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
        selectVillain.setInt(1, id);
        ResultSet villainSet = selectVillain.executeQuery();

        if(!villainSet.next()){
            System.out.println("No such villain was found");
            return;
        }

        PreparedStatement minionsArr = connection.prepareStatement("""
            SELECT count(minion_id) as count_ids FROM minions_villains WHERE villain_id = ?
            """);
        minionsArr.setInt(1, id);
        ResultSet minionsSet = minionsArr.executeQuery();
        minionsSet.next();
        int countMinionsReleased = minionsSet.getInt("count_ids");

        connection.setAutoCommit(false);
        try{
            PreparedStatement deleteMinionsVillains = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");
            deleteMinionsVillains.setInt(1, id);
            deleteMinionsVillains.executeUpdate();

            PreparedStatement deleteVillains = connection.prepareStatement("DELETE FROM villains WHERE id = ?");
            deleteVillains.setInt(1, id);
            deleteVillains.executeUpdate();
            connection.commit();

            String name = villainSet.getString("name");
            System.out.printf("%s was deleted%n%d minions released%n", name, countMinionsReleased);
        }catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
        }
        connection.close();
    }
}
