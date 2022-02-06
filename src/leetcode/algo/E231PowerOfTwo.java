package leetcode.algo;

public class E231PowerOfTwo {
	public static void main(String[] args) {
		System.out.println((Math.log(4)/Math.log(2)));
		System.out.println(new E231PowerOfTwo().new Solution().isPowerOfTwo(536870912));
	}

	class Solution {
		public boolean isPowerOfTwo(int n) {
	        if(n==0) return false;
	        else if(n==1) return true;
        
	    	double d = Math.log(n) / Math.log(2);
	    	d = d - Math.ceil(d);
	    	if(d < 0.000001) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }
	}
}
