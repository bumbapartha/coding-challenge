package leetcode.daily;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class M875KokoEatingBananas {
	
	public static void main(String[] args) {
		System.out.println(new M875KokoEatingBananas().new Solution().minEatingSpeed(new int[] {
				332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184
				}, 823855818));
	}
	
	class Solution {
	    public int minEatingSpeed(int[] piles, int h) {
	       if(piles.length == 1) {
	    	   if(piles[0]> h) {
	    		   return (int) Math.ceil((piles[0]*1.0)/h);
	    	   }
	       }
	       int n = piles.length;
	       List<Integer> s = Arrays.stream(piles).sorted().boxed().collect(Collectors.toList());
	       if(h==n) {
	    	   System.out.println("Result = "+s.get(n-1));
	    	   return s.get(n-1);
	       }
	       
	       int count[] = new int[n];
	       int sum = n;
	       int start = 0;
	       int end = 0;
	       boolean boundryFound = false;
	       int v = 0;
	       for (int i=n-2; i>=0;) {
	    	   v = boundryFound ? (start+end)/2 : s.get(i);
	    	   for(int j=n-1; j>i; j--) {
	    		   int r = (int) Math.ceil((s.get(j)*1.0)/v) - 1;
	    		   sum = sum + r - count[j];
	    		   count[j] = r;
	    		   if(sum>h) {
	    			   break;
	    		   }
	    	   }
	    	   if(sum == h) {
	    		   //System.out.println("Result = "+v);
	    		   return v;
	    	   }
	    	   else if(sum>h) {
	    		   //System.out.println("Result > "+v);
	    		   if(boundryFound) {
	    			  end = v;
	    		   }
	    		   else {
		    		   boundryFound = true;
		    		   start = v;
		    		   end = s.get(i+1);
	    		   }
	    	   }
	    	   else {
	    		   //System.out.println("Result < "+v);
	    		   if(boundryFound) {
	    			   start = v;
	    		   }
	    		   else {
	    			   i--;
	    		   }
	    	   }
	       }
	       return 0;
	    }
	}

}

/*
 * [312884470]
312884469


[332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184]
823855818


*/
