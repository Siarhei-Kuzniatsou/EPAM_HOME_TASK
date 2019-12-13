package homeWork8;

public interface IBaseCard {
    void addNewCardInBase(AbstractCard card);
    boolean containCard(String name);
    AbstractCard getCard(String name);
}
