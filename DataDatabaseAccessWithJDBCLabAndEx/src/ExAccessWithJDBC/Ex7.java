package ExAccessWithJDBC;

import java.sql.*;
import java.util.*;

public class Ex7 {
    public static void main(String[] args) throws SQLException {
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "1024");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", prop);

        PreparedStatement selectMinionsNames = connection.prepareStatement("SELECT name FROM minions ORDER BY id asc;");
        ResultSet namesSet = selectMinionsNames.executeQuery();

        PreparedStatement countNames = connection.prepareStatement("SELECT count(*) as cnt FROM minions;");
        ResultSet countSet = countNames.executeQuery();
        countSet.next();
        int count = countSet.getInt("cnt");

        ArrayDeque<String> minionsQueue = new ArrayDeque<>();
        ArrayDeque<String> minionsStack = new ArrayDeque<>();
        while(namesSet.next()){
            String name = namesSet.getString("name");
            minionsQueue.offer(name);
            minionsStack.push(name);
        }
        for (int i = 0; i < count/2; i++) {
            System.out.println(minionsQueue.poll());
            System.out.println(minionsStack.pop());
        }
    }
}
