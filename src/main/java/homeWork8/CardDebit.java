package homeWork8;

class CardDebit extends AbstractCard {

    private static ErrorType error = ErrorType.ERROR_CARD;

    public CardDebit(String name, int cash, CardType type) {
        super(name, cash, type);
    }

    public String reduceCash(String name, int cash) {
        if (iBaseCard.containCard(name)) {
            AbstractCard card = iBaseCard.getCard(name);
            if(card.getCash() - cash >= 0) {
                iBaseCard.addNewCard(name, card.getCash() - cash, card.getType());
            return "Good!";}
        }
        return error.toString();
    }

}
