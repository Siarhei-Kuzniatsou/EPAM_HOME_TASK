package homeWork6;

import java.io.File;
import java.sql.*;
import java.util.List;


public class SQLiteDisp implements IRepository {
    final static private String url = "C:/Users/Siarhei_Kuzniatsou1/Desktop/repos/EPAM_HOME_TASK/src/main/resources/db/db_for_m4_l3.db";
    private File file;
    private ITable tableDisp;
    private IConnection iConnection = ConnectionSQLite.getInstance();
    private Connection connection;
    private Statement statement;
    private static SQLiteDisp sqlLiteDisp = null;


    private SQLiteDisp() {
        file = new File(url);
    }

    @Override
    public void save(List<Employer> table) {
        connection = iConnection.getConnection("jdbc:sqlite:" + url);
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
           int affected = statement.executeUpdate("delete from Employee");
            System.out.println(affected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Employer employer : table) {
            try {
                String str = new StringBuilder()
                        .append("insert into Employee (myid,firstname,lastname) values (")
                        .append(employer.getId())
                        .append(",")
                        .append("'")
                        .append(employer.getFirstname())
                        .append("'")
                        .append(",")
                        .append("'")
                        .append(employer.getLastname())
                        .append("'")
                        .append(")")
                        .toString();
                System.out.println("!!!!!!!" + str);

                statement.executeUpdate(str);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            statement.close();
            iConnection.close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read(ITable tableDisp) throws SQLException {
        connection = iConnection.getConnection("jdbc:sqlite:" + url);
        statement = connection.createStatement();
        this.tableDisp = tableDisp;

            try (ResultSet rs = statement.executeQuery("SELECT * from Employee")) {
                while (rs.next()) {
                    int id = rs.getInt("myid");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    Employer employer = new Employer(id, firstname, lastname);
                    tableDisp.add(employer);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            finally {
                statement.close();
                connection.close();
            }
        }

    @Override
    public boolean isEmpty() {return file.length() == 0;}


    public static IRepository getInstance() {
        if (sqlLiteDisp == null) return new SQLiteDisp();
        else return sqlLiteDisp;
    }

}
