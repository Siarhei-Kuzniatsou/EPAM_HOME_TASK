package homeWork4task2;

import java.util.*;

public class HomeWork4Task2 {
    public static void main(String[] args) {
        System.out.println("Enter number of type:\n 1.int \n2.double\nEnter your choice: ");
        Scanner in = new Scanner(System.in);
        int size = args.length;;
        switch (in.nextInt()){
            case 1:
                int [] arr = new int[size];
                for(int i=0; i<size; i++) arr[i] = Integer.parseInt(args[i]);
                System.out.println(Median.median(arr));
                break;
            case 2:
                double [] arrd = new double [size];
                for(int i=0; i<size; i++) arrd[i] = Double.parseDouble(args[i]);
                System.out.println(Median.median(arrd));
                break;
        }
    }
}
