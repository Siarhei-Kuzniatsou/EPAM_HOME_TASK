package homeWork6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TableDisp {
    private static List<Employer> table;
    private static TableDisp tableDisp;
    static FileDisp fileDisp = FileDisp.getInstance();

    public TableDisp(String param) {
        table = param.equals("ArrayList") ? new ArrayList<>() : new LinkedList<>();
       }

    public  List<Employer> getTable(String param) {
        return table;
    }

    public void addInTable(Employer employer){
        table.add(employer);
    }

    public  void saveTable() throws IOException {
        fileDisp.saveFile(table);
    }

    public  void delFromTable(int id){
        Employer employer =  table.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .get();
        table.remove(employer);

            }

    public static TableDisp getInstance(){
        if (tableDisp == null) return new TableDisp("ArrayList");
        else return tableDisp;
    }

}

