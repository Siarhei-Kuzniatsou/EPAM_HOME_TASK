package homeWork2;

public class HowFactarial {
    Factarial factarial = new Factarial();

    public void howFactarial(int num, int parametr){
        if (num == 1) factarial.whileFactarial(parametr);
        if (num == 2) factarial.doFactarial(parametr);
        if (num == 3) factarial.forFactarial(parametr);
    };
}
