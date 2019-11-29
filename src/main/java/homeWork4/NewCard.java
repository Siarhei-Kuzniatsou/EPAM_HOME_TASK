package homeWork4;
import java.util.Scanner;

public class NewCard {
    static void newcard (int choice){
        Scanner in = new Scanner(System.in);
        String name;
        switch (choice){
            case 1:
                System.out.println("Enter Name");
                name = in.nextLine();
                System.out.println("Enter Cash");
                int balance = in.nextInt();
                new Card().addCard(name, balance);
                new Start().option();
            break;
            case 2:
                System.out.println("Enter Name");
                name = in.nextLine();
                new Card().addCard(name);
                new Start().option();
            break;
        }

    };
}
