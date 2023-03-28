package sort;

public class CountingSort {
    public void sort(int[] array) {
        int max = 0;
        int[] tempArray = new int[array.length];
        for(int i=0; i<array.length; i++){
            if(array[i] < 0){
                throw new RuntimeException("Negative Number not supported");
            }
            if(max < array[i]){
                max = array[i];
            }
            tempArray[i] = array[i];
        }

        int[] count = new int[max+1];
        for(int i=0; i<array.length; i++){
            count[array[i]]++;
        }

        for(int i=1; i<count.length; i++){
            count[i] += count[i-1];
        }

        for(int i=0; i<array.length; i++){
            array[count[tempArray[i]]-1] = tempArray[i];
            count[tempArray[i]]--;
        }
    }
}
