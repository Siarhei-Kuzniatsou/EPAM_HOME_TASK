package homeWork2;

public class HowFibanachi {
    Fibanachi fibanachi = new Fibanachi();
    RecFibonchi recFibonchi = new RecFibonchi();
    public void howFibanachi(int num, int parametr){
        if (num == 1) fibanachi.whileFibonachi(parametr);
        if (num == 2) fibanachi.doFibonachi(parametr);
        if (num == 3) fibanachi.forFibonachi(parametr);
        if (num == 4) recFibonchi.printFibonachi(parametr);
    };
}
