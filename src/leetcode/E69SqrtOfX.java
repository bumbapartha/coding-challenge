package leetcode;

public class E69SqrtOfX {
	
	public static void main(String[] args) {
		System.out.println(new E69SqrtOfX().new Solution().mySqrt(98071));
	}

	class Solution {
	    
	    public int mySqrt(int x) {
	        String s = x+"";
	        int n = s.length();
	        n = n%2==1 ? n+1: n;
	        n = n/2;
	        int a = 0;
	        for(int i=0; i< n; i++) {
	        	a = 10*a+9;
	        }
	        return a;
	    }
	}
}
