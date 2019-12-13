package homeWork8;

class CardDebit extends AbstractCard {

    private static ErrorType error = ErrorType.ERROR_CARD;

    public CardDebit(String name, int cash, CardType type) {
        super(name, cash, type);
    }

        public String reduceCash( int cash) {

        if(super.getCash()-cash >= 0) {
            super.setCash(super.getCash()-cash);
            return "GOOD!";
        }
        else return error.toString();
    }

}
