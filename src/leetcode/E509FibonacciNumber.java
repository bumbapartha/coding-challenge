package leetcode;

import java.util.HashMap;
import java.util.Map;

public class E509FibonacciNumber {
	public static void main(String[] args) {
		System.out.println(new E509Solution().fib(130));
	}
}

class E509Solution {
    
	static Map<Integer, Integer> resultMap = new HashMap<>();
	static {
		resultMap.put(0, 0);
		resultMap.put(1, 1);
		resultMap.put(2, 1);
		resultMap.put(3, 2);
	}
    
    public int fib(int n) {
    	if(n == 0) return 0;
    	else if(n == 1) return 1;
    	else if(n == 2) return 1;
    	else if(n == 3) return 2;
    	else {
    		if(resultMap.containsKey(n)) {
    			return resultMap.get(n);
    		} else {
    			//System.out.println("Fib("+(n)+") => " + "Fib("+(n-1)+") + "+"Fib("+(n-2)+")");
    			int data = fib(n-1)+fib(n-2);
    			resultMap.put(n, data);
    			return data;
    		}
    	}
    }
}
