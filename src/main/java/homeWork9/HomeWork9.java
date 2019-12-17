package homeWork9;

public class HomeWork9 {
    public static void main(String[] args) {

        int nums [] = new int[args.length];
        for (int i=0; i!=args.length; i++){
            nums[i] = Integer.parseInt(args[i]);
        }
        SortArray sortArray = new SortArray(nums);
        sortArray.sort();
    }
}
