package leetcode.algo;

import java.util.List;

public class M120Traingle {
	
	
	class Solution {
	    public int minimumTotal(List<List<Integer>> triangle) {
	    	return minimumTotal(triangle, triangle.size()).sum;
        }
	    
	    public Node minimumTotal(List<List<Integer>> triangle, int depth) {
	        if(depth == 1) {
	        	return new Node(triangle.get(0).get(0), 0);
	        }
	        Node temp = minimumTotal(triangle, depth-1);
	        if(temp.i+1 < triangle.get(depth-1).size() 
	        		&& triangle.get(depth-1).get(temp.i) > triangle.get(depth-1).get(temp.i+1)) {
                temp.i = temp.i+1;
	        	temp.sum += triangle.get(depth-1).get(temp.i+1);
	        }
	        else {
	        	temp.i = temp.i;
	        	temp.sum += triangle.get(depth-1).get(temp.i);
	        }
	        return temp;
        }
    }
	
	class Node {
		int i;
		int sum;
		Node(int i, int sum){
			this.i = i;
			this.sum = sum;
		}
	}
}

