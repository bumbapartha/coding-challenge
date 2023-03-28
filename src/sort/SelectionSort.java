package sort;

public class SelectionSort {
    public void sort(int[] array) {
        for(int i=0; i<array.length; i++){
            int minIndex = i;
            for(int j=i+1; j<array.length; j++) {
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
