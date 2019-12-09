package homeWork6;

import java.io.IOException;
import java.util.List;

interface ITable {
    void add(Employer employer);
    void remove(int id);
    void show(String param);
    List<Employer> get();
//    List<Employer> download();
}
