package homeWork8;

class CardCredit extends AbstractCard {

    public CardCredit(String name, int cash) {
        super(name, cash, CardType.CREDIT);
    }

    public String reduceCash( int cash) {

       super.setCash(super.getCash()-cash);
       return "GOOD!";

    }

}
