package homeWork8;

import java.util.HashMap;
import java.util.Map;

public class CardBase implements IBaseCard{
    private static CardBase cardBase = null;
    private Map<String, AbstractCard> baseCard = new HashMap<>();
    private static final ErrorType errorType = ErrorType.ERROR_CARD;


    public String addNewCard(String name, int cash, CardType type) {
        AbstractCard card = new AbstractCard(name, cash, type);
        if (baseCard.containsKey(name)) return errorType.toString();
        else baseCard.put(name, card);
        return "Good!";
    }

    @Override
    public String addNewCard(String name, int cash, String type) {
        return null;
    }

    @Override
    public boolean containCard(String name) {
        return baseCard.containsKey(name);
    }

    @Override
    public AbstractCard getCard(String name) {
        return null;
    }


    public static CardBase getInstance(){
        if (cardBase == null) return new CardBase();
        else return cardBase;
    }
}
