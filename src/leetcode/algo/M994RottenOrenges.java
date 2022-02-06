package leetcode.algo;

import java.util.LinkedList;
import java.util.Queue;

public class M994RottenOrenges {
	
	public static void main(String[] args) {
			System.out.println(
					new M994RottenOrenges().new Solution()
					.orangesRotting(new int[][] { 
						new int[] { 0, 0}}));
	}

	
	class Solution {
		
	    public int orangesRotting(int[][] grid) {
	    	int m = grid.length;
	    	int n = grid[0].length;
	    	int t=-1;
	    	Queue<Node> queue = new LinkedList<>();
	    	boolean noFreshOrrage = true;
	    	for(int i=0; i<m; i++) {
	    		for (int j = 0; j < n; j++) {
					int e = grid[i][j];
					if(e==2) {
						Node node = new Node(0, i, j);
						queue.add(node);
					}
					else if(e==1) {
						noFreshOrrage = false;
					}
				}
	    	}
	    	
	    	if(noFreshOrrage) {
	    		return 0;
	    	}
	    	
	    	if(queue.isEmpty() && !noFreshOrrage) {
	    		return -1;
	    	}
	    	
	    	while(!queue.isEmpty()) {
	    		Node node = queue.remove();
	    		if(t<node.timeFrame) {
	    			t=node.timeFrame;
	    		}
	    		if(node.x>0) {
	    			if(grid[node.x-1][node.y]==1) {
	    				grid[node.x-1][node.y] = 2;
	    				Node newNode = new Node(node.timeFrame+1,node.x-1, node.y);
	    				queue.add(newNode);
	    			}
	    		}
	    		if(node.y>0) {
	    			if(grid[node.x][node.y-1]==1) {
	    				grid[node.x][node.y-1] = 2;
	    				Node newNode = new Node(node.timeFrame+1,node.x, node.y-1);
	    				queue.add(newNode);
	    			}
	    		}

	    		if(node.x<m-1) {
	    			if(grid[node.x+1][node.y]==1) {
	    				grid[node.x+1][node.y] = 2;
	    				Node newNode = new Node(node.timeFrame+1,node.x+1, node.y);
	    				queue.add(newNode);
	    			}
	    		}

	    		if(node.y<n-1) {
	    			if(grid[node.x][node.y+1]==1) {
	    				grid[node.x][node.y+1] = 2;
	    				Node newNode = new Node(node.timeFrame+1,node.x, node.y+1);
	    				queue.add(newNode);
	    			}
	    		}
	    	}
	    	
	    	for(int i=0; i<m; i++) {
	    		for (int j = 0; j < n; j++) {
					int e = grid[i][j];
					if(e==1) {
						return -1;
					}
				}
	    	}
	    	
			return t; 
	    }
	}
	
	class Node {
		public Node(int t, int i, int j) {
			this.timeFrame = t;
			this.x = i;
			this.y = j;
		}
		int timeFrame = 0;
		int x;
		int y;
	}
}
