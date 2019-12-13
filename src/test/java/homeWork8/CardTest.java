package homeWork8;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void testCreditCard(){
        Atm atm = new Atm();
        AbstractCard creditCard = new CardCredit("S", 1);
        atm.insertCard(creditCard);
        atm.reduceCash(2);
        Assert.assertEquals(-1, creditCard.getCash());
    }
}
