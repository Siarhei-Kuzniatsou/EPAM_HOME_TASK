package homeWork8;

import java.util.HashMap;
import java.util.Map;

public class CardBase implements IBaseCard{
    private static CardBase cardBase = null;
    private Map<String, AbstractCard> baseCard = new HashMap<>();
    private static final ErrorType errorType = ErrorType.ERROR_CARD;


    public String addNewCard(String name, int cash, CardType type) {
//        if (baseCard.containsKey(name)) return errorType.toString();
//        else {
//            switch (type) {
//                case CREDIT: baseCard.put(name, new CardCredit(name, cash));
//                case DEBIT: baseCard.put(name, new CardDebit(name, cash));
//            }
//        }
        return "Good!";
    }

    @Override
    public boolean containCard(String name) {
        return baseCard.containsKey(name);
    }

    @Override
    public AbstractCard getCard(String name) {
        return baseCard.get(name);
    }


    public static CardBase getInstance(){
        if (cardBase == null) cardBase = new CardBase();
        return cardBase;
    }
}
