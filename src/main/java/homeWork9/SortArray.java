package homeWork9;


public class SortArray {
    private int [] nums;

    public int[] sort(){

            for (int i = 0; i < nums.length; i++) {

                int min = summ(nums[i]);
                int min_i = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (summ(nums[j]) < min) {
                        min = summ(nums[j]);
                        min_i = j;
                    }
                }
                if (i != min_i) {
                    int tmp = nums[i];
                    nums[i] = nums[min_i];
                    nums[min_i] = tmp;
                }
            }
            return nums;
        }

        public static int summ(int i){
        int sum = 0;
        while (i!=0){
                sum += i % 10;
                i /= 10;
            }
            return sum;
        }



    public SortArray(int [] nums){
        this.nums = nums;
    }

}
