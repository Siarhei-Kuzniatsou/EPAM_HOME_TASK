package homeWork8;

public class CreditCard extends AbstractCard {
    public CreditCard(String name, int cash) {
        super(name, cash, CardType.CREDIT);
    }
}
