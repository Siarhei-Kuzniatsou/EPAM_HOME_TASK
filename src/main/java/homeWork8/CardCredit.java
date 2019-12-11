package homeWork8;

class CardCredit extends AbstractCard {

    public CardCredit(String name, int cash, CardType type) {
        super(name, cash, type);
    }

    public String reduceCash(String name, int cash) {
        if (iBaseCard.containCard(name)) {
            AbstractCard card = iBaseCard.getCard(name);
            iBaseCard.addNewCard(name, card.getCash() - cash, card.getType());
            return "Good!";
        }
        return error.toString();
    }

}
