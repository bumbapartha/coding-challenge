package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class E1TwoSum {

	
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	    	
	    	
	    	
	    	
	        Map<Integer, Integer> map = new HashMap<>();
	        List<Integer> list = new ArrayList<>();
	        IntStream.range(0, nums.length)
	            .filter((i) -> {
	                if(map.containsKey(i)){
	                	list.add(map.get(i));
	                	list.add(i);
	                    return true;
	                }
	                else {
	                    map.put(target-nums[i], i);
	                    return false;
	                }
	                
	        });
	        return new int[] {list.get(0), list.get(1)};
	    }
	}
	
	public int missingNumber(int[] nums) {
        int n = nums.length;
        int e = (int) Math.floor(Math.log(n*1.0));
        return e;
    }
}
