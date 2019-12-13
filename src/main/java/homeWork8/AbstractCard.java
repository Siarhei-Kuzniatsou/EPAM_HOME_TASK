package homeWork8;

public abstract class AbstractCard implements ICard{
    private String name;
    private int cash = 0;
    private CardType type = null;
    protected static ErrorType error = ErrorType.ERROR_CARD;

    public AbstractCard(String name, int cash, CardType type) {
        this.name = name;
        this.cash = cash;
        this.type = type;
    }

    public int getCash() {
        return cash;
    }

    public String setCash(int cash) {
        this.cash = cash;
        return "GOOD!";
    }

    @Override
    public  AbstractCard addNewCard(String name, int cash, CardType type) {
//        switch (type){
//            case DEBIT: return new CardDebit(name, cash, type);
//            case CREDIT:return new CardCredit(name, cash, type);
//            default:
//                System.out.println(error);
//        }
        return null;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }
}
