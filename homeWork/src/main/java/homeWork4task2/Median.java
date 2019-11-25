package homeWork4task2;

import java.util.*;

public class Median {
    public static void median(Integer[] arr){
        List<Integer> arrList = Arrays.asList(arr);
//        for(int i=0; i<arr.length; i++) arrList.add(arr[i]);
        Collections.sort(arrList);
        if (isEven(arr.length)) {
            System.out.println((arrList.get(arrList.size() / 2) + arrList.get(arrList.size() / 2 +1) / 2));
        }
        else {
            Collections.sort(arrList);
            System.out.println((arrList.get(arrList.size() / 2)));
        }

        }


    public static void median(double [] arr){

    }

    static boolean isEven(int size){
        return (size%2 == 0);
    }


}
