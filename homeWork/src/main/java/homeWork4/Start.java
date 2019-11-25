package homeWork4;
import java.util.Scanner;

public class Start {
     static void option(){
      Scanner in = new Scanner(System.in);
      System.out.println("1. New card. \n" + "2. Jobs with card \n" + "0. Exit\n" + "To select an operation, press the number:");
      int choice = in.nextInt();
      switch (choice){
          case 1:
              System.out.println("1. With balance \n" + "2. Without balance \n" + "Enter a number:");
              NewCard.newcard(in.nextInt());
              break;
          case 2:
              System.out.println("1. Balance. \n" + "2. Replenish the balance. \n" + "3. Decrease the balance. \n" + "Enter a number:");
              new JobWithCard().choice(in.nextInt());
              break;
          case 0: break;
      }

    }
}
