package leetcode.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class M542Matrix01 {

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new M542Matrix01().new Solution()
				.updateMatrix(new int[][] { new int[] { 0, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 1, 1, 1 } })));
	}

	static final int FOUR_SIDE_R[] = new int[] { 1, -1, 0, 0 };
	static final int FOUR_SIDE_C[] = new int[] { 0, 0, 1, -1 };

	class Solution {


        
        class Point {
            int x;
            int y;
        } 

		public int[][] updateMatrix(int[][] mat) {
			int newMat[][] = new int[mat.length][mat[0].length];
            Map<String, Point> points = new HashMap<>();
            int oldData = 0;
			for (int i = 0; i < newMat.length; i++) {
				for (int j = 0; j < newMat[i].length; j++) {
					if (mat[i][j] == 1) {
						newMat[i][j] = 10001;
						Point p = new Point();
                        p.x = i;
                        p.y = j;
                        points.put(p.x+","+p.y, p);
					}
					else {
						oldData = 0;
						if(j<mat[0].length-1 && mat[i][j+1]>=1) {
							newMat[i][j+1] = 1;
							if(points.containsKey(i+","+j)) {
								points.remove(i+","+j);
							}
						}
						if(j>0 && mat[i][j-1]==1) {
							newMat[i][j-1] = 1;
							if(points.containsKey(i+","+j)) {
								points.remove(i+","+j);
							}
						}
						if(i<mat.length-1 && mat[i+1][j]>=1) {
							newMat[i+1][j] = 1;
							if(points.containsKey(i+","+j)) {
								points.remove(i+","+j);
							}
						}
						if(i>0 && mat[i-1][j]==1) {
							newMat[i-1][j] = 1;
							if(points.containsKey(i+","+j)) {
								points.remove(i+","+j);
							}
						}
					}
				}
			}
			for (Iterator<Map.Entry<String,Point>> iterator = points.entrySet().iterator(); iterator.hasNext();) {
				Map.Entry<String,Point> e = (Map.Entry<String,Point>) iterator.next();
				Point p = e.getValue();
				countDistance(mat, p.x, p.y, 4, newMat);
			}
			return newMat;
		}

		public int countDistance(int[][] mat, int r, int c, int d, int[][] newMat) {
			//System.out.println(r+","+c);
			if (newMat[r][c] < 10001) {
				return newMat[r][c];
			} else if (mat[r][c] == 0) {
				newMat[r][c] = 0;
				return 0;
			} else {
				int min = 10001;

				for (int i = 0; i < 4; i++) {
					if(d == 0 && FOUR_SIDE_R[i]==-1) {
						return min;
					} else if(d == 1 && FOUR_SIDE_R[i]==1) {
						return min;
					} else if(d == 2 && FOUR_SIDE_C[i]==-1) {
						return min;
					} else if(d == 3 && FOUR_SIDE_C[i]==1) {
						return min;
					}
					int x = r + FOUR_SIDE_R[i];
					int y = c + FOUR_SIDE_C[i];
					if (0 <= x && x < mat.length && 0 <= y && y < mat[0].length) {
						int v;
						if (newMat[r][c] < 10001) {
							v = newMat[r][c] +1;
						}
						else {
						  v = 1 + countDistance(mat, x, y, i, newMat);
						}
						if (min >= v) {
							min = v;
						}
					}
				}
				newMat[r][c] = min;
				return min;
			}
		}

	}


}
