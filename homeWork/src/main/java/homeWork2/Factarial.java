package homeWork2;

public class Factarial {
    private int result = 1;

    void doFactarial(int count) {
        if (count == 0) System.out.println(result);
        else {
            int i = 1;
            do {
                result = result * i;
                i++;
            } while (i != count + 1);
            System.out.println(result);
        }
    }

    void whileFactarial(int count) {
        if (count == 0) System.out.println(result);
        else {
            int i = 1;
            while (i < count + 1) {
                result = result * i;
                i++;
            }
            System.out.println(result);
        }
    }


    void forFactarial(int count) {
        if (count == 0) System.out.println(result);
        for (int i = 1; i < count + 1; i++) {
            result = result * i;
        }
        System.out.println(result);
    }

    public int recFsctarial(int cout) {
        result = 1;
        for (int i = 1; i<=cout; i++)  result *= i;
        return result;
    }

}
