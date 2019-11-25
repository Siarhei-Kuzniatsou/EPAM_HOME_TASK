package homeWork4;
import java.util.*;

 class Card {

    void addCard (String name){
        HomeWork4.cards.put(name, 0);
        Start.option();
    };
    void addCard (String name, int balance){
        HomeWork4.cards.put(name, balance);
        Start.option();
    };
     void balance (String name) {
        System.out.println("Balance:" +  HomeWork4.cards.get(name));
        Start.option();
    };
     void balance(String name, double conversion){
         System.out.println("Balance:" +  HomeWork4.cards.get(name) * conversion);
         Start.option();
     };
     void replenish (String name, int cash) {
        HomeWork4.cards.put(name,  HomeWork4.cards.get(name) + cash);
        Start.option();
    };
     void decrease (String name, int cash) {
        HomeWork4.cards.put(name, HomeWork4.cards.get(name) - cash);
        Start.option();
    };

}
