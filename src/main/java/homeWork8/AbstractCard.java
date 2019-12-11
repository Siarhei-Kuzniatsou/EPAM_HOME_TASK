package homeWork8;

public abstract class AbstractCard implements ICard{
    private String name;
    private int cash = 0;
    private CardType type = CardType.DEBIT;
    protected IBaseCard iBaseCard = CardBase.getInstance();
    protected static ErrorType error = ErrorType.ERROR_CARD;

    public AbstractCard(String name, int cash, CardType type) {
        this.name = name;
        this.cash = cash;
        if (type.equals("credit")) this.type = CardType.CREDIT;
    }

    public int getCash() {
        return cash;
    }

    public CardType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                '}';
    }

    public String addCash(String name, int cash) {
        if (iBaseCard.containCard(name) && cash > 0) {
            AbstractCard card = iBaseCard.getCard(name);
            iBaseCard.addNewCard(name, card.getCash() + cash, card.getType());
            return "Good!";
        }
        return error.toString();
    }


}
