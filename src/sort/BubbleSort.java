package sort;

import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] array) {
        for(int i=0; i<array.length; i++){
            boolean swap = false;
            for(int j=i+1; j<array.length; j++) {
                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    swap = true;
                }
            }
            if(!swap) {
                break;
            }
        }
    }
}
