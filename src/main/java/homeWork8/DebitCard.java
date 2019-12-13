package homeWork8;

public class DebitCard extends AbstractCard {
    public DebitCard(String name, int cash) {
        super(name, cash, CardType.DEBIT);
    }
}
