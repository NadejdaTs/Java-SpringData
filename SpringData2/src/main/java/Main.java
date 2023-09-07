import entities.Address;
import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static orm.MyConnector.createConnection;
import static orm.MyConnector.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        createConnection("root", "1024", "custom_orm");
        Connection connection = getConnection();
        EntityManager<User> userEntityManager = new EntityManager<>(connection);
        EntityManager<Address> addressEntityManager = new EntityManager<>(connection);

        //User user = new User("Pesho", 25, LocalDate.now());
        //user.setId(6);
        //user.setUsername("Pesho_Petrov");

        //userEntityManager.doAlter(User.class);
        //userEntityManager.doCreate(User.class);
        ///userEntityManager.persist(user);

        //String street, long streetNumber, String city, String country, String postalCode
        //addressEntityManager.doCreate(Address.class);
        Address address = new Address("stree1", 255, "Sofia", "Bulgaria", 1000);
        addressEntityManager.persist(address);
        Iterable<Address> addresses = addressEntityManager.find(Address.class);
        System.out.println(addresses.toString());

        //User first = userEntityManager.findFirst(User.class, "id = 2");
        //User first = userEntityManager.findFirst(User.class);
        //Iterable<User> first = userEntityManager.find(User.class, "id < 5");
        //Iterable<User> first = userEntityManager.find(User.class);
        //userEntityManager.delete(user);
        //System.out.println(first);
        connection.close();
    }
}
