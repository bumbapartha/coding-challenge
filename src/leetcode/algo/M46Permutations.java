package leetcode.algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class M46Permutations {

	public List<List<Integer>> permute(int[] nums) {
		return permute(nums, nums.length-1);
	}
	
	
	public List<List<Integer>> permute(int[] nums, int n) {
		if(n==0) {
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			List<Integer> items = new ArrayList<Integer>();
			items.add(nums[n]);
			list.add(items);
			return list;
		}
		else {
			List<List<Integer>> list = permute(nums, n-1);
            List<List<Integer>> newlist = new ArrayList<>();
			for (Iterator<List<Integer>> iterator = list.iterator(); iterator.hasNext();) {
				List<Integer> list2 = (List<Integer>) iterator.next();
				for(int i=0; i<list2.size(); i++) {
					List<Integer> items = new ArrayList<>(list2);
					items.add(i, nums[n]);
					newlist.add(items);
				}
				list2.add(nums[n]);
			}
            list.addAll(newlist);
			return list;
		}
	}

}
