package homeWork6;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnection {
    Connection getConnection(String url);
    void close(Connection connection) throws SQLException;
}
