package homeWork2;

public class RecFibonchi {
    void printFibonachi (int cout) {
        for (int i = 0; i != cout; i++) System.out.print(recFibonachi(i) + " ");
    }
    int recFibonachi(int cout) {
        if (cout == 1) return 1;
        if (cout == 0) return 0;
        else return recFibonachi(cout - 1) + recFibonachi(cout - 2);

    }
}
