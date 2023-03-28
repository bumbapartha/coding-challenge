package sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SortMainTest {

    private int[] unsortedArray;
    private int[] sortedArray;

    @Before
    public void init() {
        unsortedArray = new int[]{-1, 5, -8, 7, 3, 5, 2, -2, -1, 9, 100, 450, 321, -70, 43, 22, 111, 689, -342, 345, 43, 56, 12, 84, 29, 73, 84, 100};
        sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Arrays.sort(sortedArray);
    }

    @Test
    public void testBubbleSort(){
        BubbleSort bubbleSortAlgorithm = new BubbleSort();
        int[] mySortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        bubbleSortAlgorithm.sort(mySortedArray);
        assertArrayEquals(mySortedArray, sortedArray);
    }

    @Test
    public void testSelectionSort(){
        SelectionSort sortAlgo = new SelectionSort();
        int[] mySortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        sortAlgo.sort(mySortedArray);
        assertArrayEquals(mySortedArray, sortedArray);
    }

    @Test
    public void testInsertationSort(){
        InsertationSort sortAlgo = new InsertationSort();
        int[] mySortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        sortAlgo.sort(mySortedArray);
        assertArrayEquals(mySortedArray, sortedArray);
    }

    @Test
    public void testCountingSort(){
        CountingSort sortAlgo = new CountingSort();
        int[] tempUnsortedArray = new int[]{0, 5, 7, 3, 5, 2, 2, 1, 9, 7, 4, 2, 11, 9, 3, 3, 4, 6, 1, 8, 9, 3, 4, 10};
        int[] tempSortedArray = Arrays.copyOf(tempUnsortedArray, tempUnsortedArray.length);
        Arrays.sort(tempSortedArray);
        int[] mySortedArray = Arrays.copyOf(tempUnsortedArray, tempUnsortedArray.length);
        sortAlgo.sort(mySortedArray);
        assertArrayEquals(mySortedArray, tempSortedArray);
    }
}
