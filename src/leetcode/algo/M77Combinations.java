package leetcode.algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class M77Combinations {
	
	public static void main(String[] args) {
		List<List<Integer>> list = new M77Combinations().new Solution().combine(20, 10);
		list.stream().forEach(a -> {
			a.stream().forEach(b -> {
				System.out.print(b+",");
			});
			System.out.println();
		});
	}
	
	class Solution {
	    public List<List<Integer>> combine(int n, int k) {
	    	List<List<Integer>> list = new ArrayList<>();
	    	if(1==k) {
	    		for(int i=1; i<=n; i++) {
	    			List<Integer> items = new ArrayList<>();
	    			items.add(i);
	    			list.add(items);
	    		}
	    	}
	    	else if(n==k) {
	    		List<Integer> items = new ArrayList<>();
	    		for(int i=1; i<=n; i++) {
	    			items.add(i);
	    		}
	    		list.add(items);
	    	}
	    	else {
	    		List<List<Integer>> list1 = combine(n-1, k-1);
	    		for (Iterator<List<Integer>> iterator = list1.iterator(); iterator.hasNext();) {
					List<Integer> items = (List<Integer>) iterator.next();
					items.add(n);
				}
	    		list.addAll(list1);
	    		List<List<Integer>> list2 = combine(n-1, k);
	    		list.addAll(list2);
	    	}
			return list;
	    }
	}

}
