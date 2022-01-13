package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class E1137TribonacciNumber {
	public static void main(String[] args) {
		System.out.println(new E1137Solution().tribonacci(37));
	}
}


class E1137Solution {
    
    static Map<Integer, Integer> resultMap = new HashMap<>();
	static {
		resultMap.put(0, 0);
		resultMap.put(1, 1);
		resultMap.put(2, 1);
	}
    
    public int tribonacci(int n) {
    	if(n == 0) return 0;
    	else if(n == 1) return 1;
    	else if(n == 2) return 1;
    	else {
    		if(resultMap.containsKey(n)) {
    			return resultMap.get(n);
    		} else {
    			int data = tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    			resultMap.put(n, data);
    			return data;
    		}
    	}
    }
}