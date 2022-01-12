package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FloodFill733 {

	public static void main(String args[]) {
		new Solution().floodFill(new int[][] { new int[] { 1, 1, 1 }, new int[] { 1, 1, 0 }, new int[] { 1, 0, 1 } }, 1,
				1, 2);
	}
}

class Solution {

	public int[][] floodFill(int[][] image, int r, int c, int newColor) {
		MAX_R = image.length - 1;
		if (MAX_R == 0)
			return image;
		MAX_C = image[0].length - 1;
		if (MAX_C == 0)
			return image;

		int oldColor = image[r][c];
		
		moveNext(image, r, c, oldColor, newColor, 4);

		println(Arrays.deepToString(image));

		return image;
	}

	int MAX_R;
	int MAX_C;
	Map<String, Boolean> alreadyDone = new HashMap<>();

	void moveNext(int[][] image, int r, int c, int oldColor, int newColor, int d) {
		print("-->"+"["+r+","+c+"]");
		if (alreadyDone.containsKey(r + "," + c)) {
			return;
		}
		alreadyDone.put(r + "," + c, true);
		if (image[r][c] == oldColor) {
			if (d != 0 && c > 0 && image[r][c - 1] == oldColor)
				moveNext(image, r, c - 1, oldColor, newColor, 2);
			if (d != 2 && c < MAX_C && image[r][c + 1] == oldColor)
				moveNext(image, r, c + 1, oldColor, newColor, 0);
			if (d != 1 && r > 0 && image[r - 1][c] == oldColor)
				moveNext(image, r - 1, c, oldColor, newColor, 3);
			if (d != 3 && r < MAX_R && image[r + 1][c] == oldColor)
				moveNext(image, r + 1, c, oldColor, newColor, 1);
			image[r][c] = newColor;
		}
		println("");
	}

	void print(String str) {
		System.out.print(str);
	}
	void println(String str) {
		System.out.println(str);
	}
}
