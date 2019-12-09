package homeWork6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class Start {
    static void start() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Which method do you want?\n1.File\n2.SQLite\n3.MySQL\n4.Exit");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String var = in.readLine();
        switch (var){
            case "1": MenuFile.menu("File"); break;
            case "2": MenuFile.menu("SQLite"); break;
            case "3":
                System.out.println("In progress!");
                Start.start();
                break;
            case "4": break;
        }
    }
}
