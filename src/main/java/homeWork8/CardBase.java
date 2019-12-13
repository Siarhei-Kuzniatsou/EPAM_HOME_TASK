package homeWork8;

import java.util.HashMap;
import java.util.Map;

public class CardBase implements IBaseCard{
    private static CardBase cardBase = null;
    private Map<String, AbstractCard> baseCard = new HashMap<>();

    @Override
    public void addNewCardInBase(AbstractCard card) {
        baseCard.put(card.getName(), card);
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
