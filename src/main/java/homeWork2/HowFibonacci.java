package homeWork2;

public class HowFibonacci {
    private Fibonacci fibonacci;
    private RecFibonchi recFibonchi;

    public HowFibonacci() {
        fibonacci = new Fibonacci();
        recFibonchi = new RecFibonchi();
    }

    public void howFibonacci(int num, int parameter) {
        if (num == 1) fibonacci.whileFibonacci(parameter);
        if (num == 2) fibonacci.doFibonacci(parameter);
        if (num == 3) fibonacci.forFibonacci(parameter);
        if (num == 4) recFibonchi.printFibonachi(parameter);
    }
}
