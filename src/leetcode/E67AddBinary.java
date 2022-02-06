package leetcode;

public class E67AddBinary {
	
	public static void main(String[] args) {
		System.out.println(new E67AddBinary().new Solution().addBinary("11", "11"));
	}
	
	
	class Solution {
	    public String addBinary(String a, String b) {
	        
	        int n = a.length() > b.length() ? a.length() : b.length();
	        int k=n-1;
	        int i=a.length()-1;
	        int j=b.length()-1;
	        StringBuilder sb = new StringBuilder();
	        int carry = 0;
	        int r = 0;
	        while(k>=0){
	            char ac = (i>=0) ? a.charAt(i) : '0';
	            char bc = (j>=0) ? b.charAt(j) : '0';
	            
                r = (ac-'0')+(bc-'0')+carry;
                carry = (r>>1);
                r = r & 1;
                
	            sb.insert(0, r);
	            i--;
	            j--;
	            k--;
	        }
	            
	        if(carry == 1){
	            sb.insert(0, 1);
	        }
	        
	        return sb.toString();
	    }
	}

}
