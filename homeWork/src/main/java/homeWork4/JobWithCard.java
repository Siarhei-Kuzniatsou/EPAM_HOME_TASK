package homeWork4;
import java.util.Scanner;

public class JobWithCard {
     void choice(int choice) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Name:");
        String name = in.nextLine();
        int cash;
        switch (choice){
            case 1:
                new Card().balance(name);
                break;
            case 2:
                System.out.println("Enter Cash:");
                cash = in.nextInt();
                new Card().replenish(name, cash);
                break;
            case 3:
                System.out.println("Enter Cash:");
                cash = in.nextInt();
                new Card().decrease(name, cash);
                break;
        }
    };
}
