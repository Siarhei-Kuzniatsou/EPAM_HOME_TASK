package homeWork6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite implements IConnection {

    private Connection connection = null;
    private static ConnectionSQLite connectionSQLite = null;
    private ConnectionSQLite (){};

    @Override
    public Connection getConnection(String url) {
        try {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    @Override
    public void close(Connection connection) throws SQLException {
        if(!connection.isClosed()) connection.close();
    }

    public static synchronized IConnection getInstance() {
        if (connectionSQLite == null) return new ConnectionSQLite();
        return connectionSQLite;
    }

}
