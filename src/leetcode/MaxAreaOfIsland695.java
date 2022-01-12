package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxAreaOfIsland695 {
	public static void main(String[] args) {
		System.out.println(new Solution695().maxAreaOfIsland(
				new int[][] {
					new int[]{0,0,1,0,0,0,0,1,0,0,0,0,0},
					new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0},
					new int[]{0,1,1,0,1,0,0,0,0,0,0,0,0},
					new int[]{0,1,0,0,1,1,0,0,1,0,1,0,0},
					new int[]{0,1,0,0,1,1,0,0,1,1,1,0,0},
					new int[]{0,0,0,0,0,0,0,0,0,0,1,0,0},
					new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0},
					new int[]{0,0,0,0,0,0,0,1,1,0,0,0,0}
				}
		));
		
		
		System.out.println(new Solution695().maxAreaOfIsland(
				new int[][] {
					new int[]{0,0,1,0,0,0,0,1,0,0,0,0,0}
				}
		));
		
		System.out.println(new Solution695().maxAreaOfIsland(
				new int[][] {
					new int[]{0}
				}
		));
	}
}

class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
    	Map<String, IntValue> visitedMap = new HashMap<>(); 
    	int maxCount = 0;
    	for(int r=0; r<grid.length; r++) {
    		for(int c=0; c<grid[0].length; c++) {
	    		if(grid[r][c]==1) {
	    			IntValue current =  new IntValue(0);
	    			dfs(grid, r, c, visitedMap, 4, current);
	    			//System.out.println(r+","+c+"=>"+ current.val);
	    			if(current.val>maxCount) {
	    				maxCount =current.val;
	    			}
    			}
	    	    else {
	    	    	String key = r+","+c;
	    	    	visitedMap.put(key, new IntValue(0));	
	    		}
        	}
    	}
        return maxCount;
    }
    
    void dfs(int[][] grid, int r, int c, Map<String, IntValue> visitedMap, int d, IntValue count){
    	String key = r+","+c;
    	if(r<0 || r>=grid.length || c<0 || c>=grid[0].length) {
    		return;
    	}
    	else if(visitedMap.containsKey(key)) {
			return;
		}
    	else if(grid[r][c] == 0) {
			visitedMap.put(key, new IntValue(0));
			return;
		}
    	else if(grid[r][c] == 1) {
    		count.val = count.val+1;
    		visitedMap.put(key, count);
    		
    		//up
    		if(d != 1 && r>0) { dfs(grid, r-1, c, visitedMap, 0, count); }
    		//bottom
    		if(d != 0  && r<grid.length-1) { dfs(grid, r+1, c, visitedMap, 1, count); }
    		//left
    		if(d != 3 && c>0) {  dfs(grid, r, c-1, visitedMap, 2, count); }
    		//right
    		if(d != 2 && c<grid[0].length-1) { dfs(grid, r, c+1, visitedMap, 3, count); }
    		
    		return;
    		
    	}
    	else {
    		//Should not reach in this condition
    		throw new RuntimeException("Should Not reach here");
    	}
    	
    }
    
}

class IntValue {
	int val;
	IntValue(int val){
		this.val = val;
	}
}