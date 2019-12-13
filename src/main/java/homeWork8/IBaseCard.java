package homeWork8;

public interface IBaseCard {
    String addNewCard(String name, int cash, CardType type);
    boolean containCard(String name);
    AbstractCard getCard(String name);
}
