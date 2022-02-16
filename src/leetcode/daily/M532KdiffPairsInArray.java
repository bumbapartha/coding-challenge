package leetcode.daily;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class M532KdiffPairsInArray {
	
	
	public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int count = 0;
        for(int i=0; i<nums.length; i++){
        	int a = nums[i]-k;
        	
            if(map.containsKey(a)) {
            	int x = nums[i];
            	int y =  a;
            	int i1 = Math.min(x, y);
            	int i2 = Math.max(x, y);
            	if(set.add(i1+":"+i2)) {
            		//System.out.println(i1+":"+i2);
            		count++;
            	}
            }
            
            int b = nums[i]+k;
            if(map.containsKey(b)) {
            	int x = nums[i];
            	int y =  b;
            	int i1 = Math.min(x, y);
            	int i2 = Math.max(x, y);
            	if(set.add(i1+":"+i2)) {
            		//System.out.println(i1+":"+i2);
            		count++;
            	}
            }
            
            map.put(nums[i], i);
            
        }
        return count;
    }
	
	@Test
	public void test() {
		assertEquals(2, findPairs(new int[] {3,1,4,1,5}, 2));
		assertEquals(4, findPairs(new int[] {1,2,3,4,5}, 1));
		assertEquals(1, findPairs(new int[] {1,3,1,5,4}, 0));
		assertEquals(3, findPairs(new int[] {0,1,-1,1,2}, 1));
		assertEquals(5, findPairs(new int[] {6,3,5,7,2,3,3,8,2,4}, 2));
		//3,5 : 7,5: 6,8; 2:4, 6:4
	}
	
}
