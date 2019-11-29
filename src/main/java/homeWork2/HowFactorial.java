package homeWork2;

public class HowFactorial {
    private Factorial factorial;

    public HowFactorial() {
        factorial = new Factorial();
    }

    public void howFactorial(int num, int parameter) {
        if (num == 1) factorial.whileFactorial(parameter);
        if (num == 2) factorial.doFactorial(parameter);
        if (num == 3) factorial.forFactorial(parameter);
        if (num == 4) System.out.println(factorial.recFactorial(parameter));
    }

    ;
}
