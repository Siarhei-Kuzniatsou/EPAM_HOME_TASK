package homeWork8;

import javax.smartcardio.Card;

public interface ICard {
    String reduceCash(int cash);
    String setCash(int cash);
    int getCash();
    AbstractCard addNewCard(String name, int cash, CardType type);
}
