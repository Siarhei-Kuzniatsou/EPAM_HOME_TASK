package homeWork2;

public class Fibanachi {
    private int result = 1;
    private int temp = 0;
    private int tempDO;

    void doFibonachi(int count) {
        int i = 1;
        System.out.print("0 ");
        do {
            if (count > 1) {
                System.out.print(result + " ");
            }
            tempDO = temp;
            temp = result;
            result = temp + tempDO;
            i++;
        } while (i != count);
    }



    void whileFibonachi(int count) {
        System.out.print("0 ");
        int i = 1;
        while (i < count) {
            System.out.print(result + " ");
            tempDO = temp;
            temp = result;
            result = temp + tempDO;
            i++;
        }
    }



    void forFibonachi(int count) {
        System.out.print("0 ");
        for (int i = 1; i < count; i++) {
            System.out.print(result + " ");
            tempDO = temp;
            temp = result;
            result = temp + tempDO;
        }
    }
}
