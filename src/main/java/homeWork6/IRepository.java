package homeWork6;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IRepository {
    void save(List<Employer> table) throws IOException;
    void read(ITable iEmployer) throws SQLException, ClassNotFoundException;
    boolean isEmpty();

}
