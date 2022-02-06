package leetcode.algo;

import java.util.HashMap;
import java.util.Map;

public class M198HouseRobber {

	class Solution {
	    Map<Integer,Integer> map= new HashMap<>();
	    public int rob(int[] nums) {
	        map= new HashMap<>();
	        return f(nums, nums.length);
	    }
	    
	    public int f(int[] nums, int n) {
	        if(map.containsKey(n))  return map.get(n);
	        else if(n==1) return nums[0];
	        else if(n==2) return Math.max(nums[0], nums[1]);

	        int x = f(nums, n-2) + nums[n-1]; 
	        int y = f(nums, n-1);
	        int z = Math.max(x, y);
	        map.put(n, z);
	        return z;
	    }
	}
}
