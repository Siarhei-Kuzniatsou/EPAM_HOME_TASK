package homeWork8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    @Test
    public void testCreditCard(){
        Atm atm = new Atm();
        String name = "S";
        AbstractCard creditCard = new CreditCard(name, 1);
        atm.addNewCard(creditCard);
        atm.insertCard(name);
        atm.reduceCash(2);
        assertEquals(-1, creditCard.getCash());
        atm.addCash(10);
        assertEquals(9, creditCard.getCash());
    }

    @Test
    public void testDebitCard(){
        Atm atm = new Atm();
        String name = "A";
        AbstractCard debitCard = new DebitCard(name, 1);
        atm.addNewCard(debitCard);
        atm.insertCard(name);
        atm.reduceCash(2);
        assertEquals(1, debitCard.getCash());
        atm.addCash(10);
        assertEquals(11, debitCard.getCash());
    }

    @Test
    public void testAtm(){
        Atm atm = new Atm();
        AbstractCard creditCard = new CreditCard("Test", 10);
        AbstractCard debitCard = new DebitCard("Sergei", 1);
        AbstractCard card = new DebitCard("Sergei", 0);
        atm.addNewCard(creditCard);
        atm.addNewCard(debitCard);
        atm.addNewCard(card);
        atm.insertCard("Test");
        atm.addCash(10);
        assertEquals(20, creditCard.getCash());
        atm.insertCard("Sergei");
        atm.reduceCash(2);
        assertEquals(1, debitCard.getCash());
        atm.insertCard("Test");
        atm.reduceCash(30);
        assertEquals(-10, creditCard.getCash());

    }
}
