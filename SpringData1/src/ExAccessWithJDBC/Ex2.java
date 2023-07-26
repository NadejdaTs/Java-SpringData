package ExAccessWithJDBC;

import java.sql.*;
import java.util.Properties;

public class Ex2 {
    public static void main(String[] args) throws SQLException {
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "1024");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", prop);

        PreparedStatement statement = connection.prepareStatement("SELECT v.name, count(DISTINCT mv.minion_id) as minion_count FROM villains as v " +
                "JOIN minions_villains as mv ON v.id = mv.villain_id " +
                "GROUP BY mv.villain_id " +
                "HAVING minion_count > 15 " +
                "ORDER BY minion_count desc;");

        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            String villainName = rs.getString("name");
            int minionCount = rs.getInt("minion_count");
            System.out.println(villainName + " " + minionCount);
        }
        connection.close();
    }
}
