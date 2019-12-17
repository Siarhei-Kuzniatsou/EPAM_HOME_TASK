package homeWork8;



public class Atm {
    AbstractCard card = null;
    IBaseCard base = CardBase.getInstance();

    public void addNewCard(AbstractCard card){
        if (!base.containCard(card.getName())) base.addNewCardInBase(card);
    }

    public void addCash(int cash) {
        card.setCash(card.getCash() + cash);
    }


    public void insertCard(String name) {
        card = base.getCard(name);
    }

    public void reduceCash(int cash) {
        if(card.getType() == CardType.CREDIT) card.setCash(card.getCash() - cash);
        if ((card.getType() == CardType.DEBIT)&&(card.getCash() - cash >= 0)) card.setCash(card.getCash() - cash);
        }
}
