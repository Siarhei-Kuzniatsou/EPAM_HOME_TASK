package homeWork8;

public abstract class AbstractCard {
    private String name;
    private int cash = 0;
    private CardType type = null;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }
}
