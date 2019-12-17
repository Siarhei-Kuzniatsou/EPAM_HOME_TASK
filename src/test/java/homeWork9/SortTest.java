package homeWork9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SortTest {

    @Test
    public void sortTest(){
        int [] nums = {12, 100, 3, 11};
        int [] result = {100, 11, 3, 12};
        SortArray sortArray = new SortArray(nums);
        Assertions.assertArrayEquals(result, sortArray.sort());
    }

}
