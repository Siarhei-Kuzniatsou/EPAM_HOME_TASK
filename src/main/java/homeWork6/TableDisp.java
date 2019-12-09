package homeWork6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TableDisp implements ITable {
    private static List<Employer> table;
    private static TableDisp tableDisp = null;
    private IRepository fileDisp;

    private TableDisp(String param) {
        table = param.equals("ArrayList") ? new ArrayList<>() : new LinkedList<>();
       }

    public static ITable getInstance(){
        return new TableDisp("ArrayList");
    }

    @Override
    public void add(Employer employer) {
        table.add(employer);
    }

    @Override
    public void remove(int id) {
        Employer employer =  table.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .get();
        table.remove(employer);
    }

    @Override
    public void show(String param) {
        for (int i = 0; i != table.size(); i++) {
                 System.out.println(table.get(i));
             }
    }

    @Override
    public List<Employer> get() {
        return table;
    }


}

