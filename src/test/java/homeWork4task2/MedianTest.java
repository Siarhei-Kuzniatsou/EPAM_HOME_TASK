package homeWork4task2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for Median utility class.
 */
public class MedianTest {
    @Test
    public void test(){
        double a = Median.median(new double[] {3.0});
        assertEquals(3.0, a, 0);
    }

    @Test
    public void testIntMedian() {
        float result = Median.median(new int[] { 5, 5, 5, 100, 5, 5, 5, 5 });
        assertEquals(5, result, 0);
    }

    @Test
    public void testIntMedianOddNumber() {
        float result = Median.median(new int[] {1, 5, 2, 8, 7});
        assertEquals(5, result, 0);
    }

    @Test
    public void testIntMedianEvenNumber() {
        float result = Median.median(new int[] {1, 6, 2, 8, 7, 2});
       assertEquals(4, result, 0);
    }

    @Test
    public void testIntMedianEvenAverage() {
        float result = Median.median(new int[] {1, 2, 3, 4});
        assertEquals(2.5, result, 0);
    }

    @Test
    public void testDoubleMedian() {
        double result = Median.median(new double[] { 1, 0.5, 0.5, 0.5, 0.5, 0.55, 0.5, 0.5});
        assertEquals(0.5, result, 0);
    }

    @Test
    public void testDoubleMedianOddNumber() {
        double result = Median.median(new double[] { 0.5, 0.2, 0.4, 0.3, 0.1});
        assertEquals(0.3, result, 0);
    }

    @Test
    public void testDoubleMedianEvenAverage() {
        double result = Median.median(new double[] { 0.1, 0.2, 0.3, 0.4, 0.2, 0.5});
        assertEquals(0.25, result, 0);
    }

}
