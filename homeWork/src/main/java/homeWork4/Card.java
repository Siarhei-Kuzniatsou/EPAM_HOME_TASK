package homeWork4;
import java.util.*;

public class Card {

    void addCard (String name){
        HomeWork4.cards.put(name, 0);
        new Start().option();
    };
    void addCard (String name, int balance){
        HomeWork4.cards.put(name, balance);
        new Start().option();
    };
    public void balance (String name) {
        System.out.println("Balance:" +  HomeWork4.cards.get(name));
        new Start().option();
    };
    public void replenish (String name, int cash) {
        HomeWork4.cards.put(name,  HomeWork4.cards.get(name) + cash);
        new Start().option();
    };
    public void decrease (String name, int cash) {
        HomeWork4.cards.put(name, HomeWork4.cards.get(name) - cash);
        new Start().option();
    };

}
