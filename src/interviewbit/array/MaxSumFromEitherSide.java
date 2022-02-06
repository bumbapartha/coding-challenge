package interviewbit.array;

import java.util.Arrays;
import java.util.List;

public class MaxSumFromEitherSide {
	
	public static void main(String[] args) {
		System.out.println(new MaxSumFromEitherSide().solve(Arrays.asList(5, -2, 3, 1, 2), 3));
	}
	
    public int solve(List<Integer> A, int B) {
        int a[] = new int[B];
        
        for(int i=0; i<B; i++) {
        	insertToArray(a, A.get(i));
        	int j=A.size()-1-i;
        	if(j<B) {
        		insertToArray(a, A.get(j));
        	}
        }
        
        int sum=0;
        for(int i=0; i<B; i++) {
        	sum = sum+a[i];
        }
        return sum;
    }

	private void insertToArray(int[] a, int val) {
		int i=0;
		int j=0;
		while(i<a.length && a[i]>val) {
			i++;
		}
		j = i;
		while(i<a.length-1) {
			a[i+1] = a[i];
			i++;
		}
		
		if(j<a.length) {
			a[j] = val;
		}
		
	}
        
}


