package homeWork6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    static void menu() throws IOException {
        int numInt = 0;
        FileDisp fileDisp = FileDisp.getInstance();
        TableDisp tableDisp = TableDisp.getInstance();
        if (!fileDisp.isEmpty()) {
            System.out.println("Do you want to read file? Y or N:");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String var = in.readLine();
            switch (var) {
                case "Y":
                    fileDisp.readFile();
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
                tableDisp.addInTable(new Employer(id, firstname, lastname));
            break;
        case 2:
            System.out.println("Enter ID");
            tableDisp.delFromTable(Integer.parseInt(in.readLine()));
            break;
         case 3:
             List<Employer> table = tableDisp.getTable("ArrayList");
             for (int i = 0; i != table.size(); i++) {
                 System.out.println(table.get(i));
             }

             break;
            case 4:
                tableDisp.saveTable();
            break;
        }
        }
        while (numInt!=0);
    }

}
