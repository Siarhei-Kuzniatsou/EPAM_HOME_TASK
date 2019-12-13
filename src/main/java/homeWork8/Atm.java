package homeWork8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Atm {
    static InputStreamReader isr = new InputStreamReader(System.in);
    AbstractCard card = null;
    void menu() throws IOException {
        ErrorType errorType = ErrorType.ERROR_CARD;
        IBaseCard baseCard = CardBase.getInstance();
//        AbstractCard card = null;
        int var = 0;

        do {
            System.out.println("1. New card\n2. Insert card\n3. Exit");
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            var = Integer.parseInt(getLinesFromConsole());
            switch (var){
                case 1: {
                    System.out.println("Enter Name:");
                    String name = getLinesFromConsole();
                    System.out.println("Enter Cash:");
                    int cash = Integer.parseInt(getLinesFromConsole());
                    System.out.println("1. Credit or 2. Debit\nEnter Type:");
                    int type = Integer.parseInt(getLinesFromConsole());
                    switch (type){
                        case 1: System.out.println(baseCard.addNewCard(name, cash, CardType.CREDIT)); break;
                        case 2: System.out.println(baseCard.addNewCard(name, cash, CardType.DEBIT)); break;
                        default: break;
                }
                break;
            }
                case 2: {
                    System.out.println("Name: ");
                    String name = getLinesFromConsole();
                    if(name.equals("")) name=getLinesFromConsole();

                    if (baseCard.containCard(name)) {
                        card = baseCard.getCard(name);
                        System.out.println("1. Balance\n2. Add Cash\n3. Reduce Cash");
                        int varTemp = Integer.parseInt(getLinesFromConsole());
                        switch (varTemp){
                            case 1: System.out.println(card.getCash()); break;
                            case 2: {
                                System.out.println("Cash: ");
                                System.out.println(card.setCash(Integer.parseInt(getLinesFromConsole())));
                                break;
                            }
                            case 3: {
                                System.out.println("Cash: ");
                                System.out.println(card.reduceCash(Integer.parseInt(getLinesFromConsole())));
                                break;
                            }
                            default: break;
                        }
                    }
                    else {System.out.println(errorType); break;}
                }
                default:break;
            }
        }
        while (var!=3);
    }

    public static String getLinesFromConsole() throws IOException {

            BufferedReader br = new BufferedReader(isr);
            String strLine = br.readLine();
            return strLine;
    }


    public void insertCard(AbstractCard creditCard) {
        card = creditCard;
    }

    public void reduceCash(int cash) {
        if(card.getType() == CardType.CREDIT) card.setCash(card.getCash() - cash);
        if ((card.getType() == CardType.DEBIT)&&(card.getCash() - cash >= 0)) card.setCash(card.getCash() - cash);
        }
}
