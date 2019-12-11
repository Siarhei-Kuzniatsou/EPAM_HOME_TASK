package homeWork8;

import javax.smartcardio.Card;

public interface ICard {
    String addCash(String name, int cash);
    String reduceCash(String name, int cash);
//    Card getCard(String name, int cash, String type);
}
