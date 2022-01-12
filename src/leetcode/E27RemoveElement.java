package leetcode;

public class E27RemoveElement {

	public static void main(String args[]) {
		System.out.println(new E27Solution().removeElement(new int[]{3,2,2,3}, 3));
		System.out.println(new E27Solution().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
		System.out.println(new E27Solution().removeElement(new int[]{}, 2));
		System.out.println(new E27Solution().removeElement(new int[]{2}, 2));
	}
}

class E27Solution {
    public int removeElement(int[] nums, int val) {
    	int j=0;
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i]==val) {
    			
    		}
    		else {
    			nums[j++] = nums[i];
    		}
    	}
		return j;
    }
}