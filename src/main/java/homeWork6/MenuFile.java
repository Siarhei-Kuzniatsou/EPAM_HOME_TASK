package homeWork6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class MenuFile {

    static void menu(String method) throws IOException, SQLException, ClassNotFoundException {
        int numInt = 0;
        IRepository fileDisp = null;
        ITable tableDisp = TableDisp.getInstance();
        switch (method){
            case "File": fileDisp = FileDisp.getInstance(); break;
            case "SQLite": fileDisp = SQLiteDisp.getInstance(); break;
        }

        if (!fileDisp.isEmpty()) {
            System.out.println("Do you want to read file? Y or N:");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String var = in.readLine();
            switch (var) {
                case "Y":
                    fileDisp.read(tableDisp);
                    break;
                case "N": break;
            }
        }
        do {
        System.out.println("1. Add employer\n2. Delete employer\n3. Show table\n4. Save\n0. Exit");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        numInt = Integer.parseInt(in.readLine());
        switch (numInt) {
            case 1:
                System.out.println("Enter Id");
                int id = Integer.parseInt(in.readLine());
                System.out.println("Enter Firstname");
                String firstname = in.readLine();
                System.out.println("Enter lastname");
                String lastname = in.readLine();
                tableDisp.add(new Employer(id, firstname, lastname));
            break;
        case 2:
            System.out.println("Enter ID");
            tableDisp.remove(Integer.parseInt(in.readLine()));
            break;
         case 3:
             tableDisp.show("ArrayList");
             break;
            case 4:
                fileDisp.save(tableDisp.get());
            break;
        }
        }
        while (numInt!=0);
    }

}
