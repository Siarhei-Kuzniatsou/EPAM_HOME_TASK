package homeWork4task2;

import java.util.*;

public class Median {
    public static float median(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
        return isEven(arr.length) ? ((float) (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2) : (arr[((arr.length - 1 )/ 2)]);
    }


    public static double median(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            double min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                double tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
        return isEven(arr.length) ? ((arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2) : (arr[(arr.length / 2)]);

    }

    static boolean isEven(int size) {
        return (size % 2 == 0);
    }


}
