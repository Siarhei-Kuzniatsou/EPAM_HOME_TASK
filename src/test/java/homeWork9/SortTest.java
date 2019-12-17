package homeWork9;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class SortTest {

    @Test
    public void sortTest(){
        int [] nums = {12, 100, 3, 11};
        int [] result = {100, 11, 3, 12};
        SortArray sortArray = new SortArray(nums);
        Assert.assertArrayEquals(result, sortArray.sort());
    }

}
