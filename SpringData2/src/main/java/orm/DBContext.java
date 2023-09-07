package orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface DBContext<E> {
    boolean persist(E entity) throws IllegalAccessException, SQLException;

    Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException;
    Iterable<E> find(Class<E> table, String where) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    E findFirst(Class<E> table, String where) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

    boolean delete(E toDelete) throws SQLException, IllegalAccessException;
}
