package homeWork8;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void testCreditCard(){
        Atm atm = new Atm();
        String name = "S";
        AbstractCard creditCard = new CreditCard(name, 1);
        atm.addNewCard(creditCard);
        atm.insertCard(name);
        atm.reduceCash(2);
        Assert.assertEquals(-1, creditCard.getCash());
        atm.addCash(10);
        Assert.assertEquals(9, creditCard.getCash());
    }

    @Test
    public void testDebitCard(){
        Atm atm = new Atm();
        String name = "A";
        AbstractCard debitCard = new DebitCard(name, 1);
        atm.addNewCard(debitCard);
        atm.insertCard(name);
        atm.reduceCash(2);
        Assert.assertEquals(1, debitCard.getCash());
        atm.addCash(10);
        Assert.assertEquals(11, debitCard.getCash());
    }
}
