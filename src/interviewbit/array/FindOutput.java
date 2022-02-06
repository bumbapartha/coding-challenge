package interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOutput {

	public static void main(String[] args) {
		ArrayList<Integer> B = performOps((List<Integer>) Arrays.asList(5, 10, 2, 1));
		for (int i = 0; i < B.size(); i++) {
		        System.out.print(B.get(i) + " ");
		}
	}

	static ArrayList<Integer> performOps(List<Integer> A) {
		ArrayList<Integer> B = new ArrayList<Integer>();
		for (int i = 0; i < 2 * A.size(); i++)
			B.add(0);
		for (int i = 0; i < A.size(); i++) {
			B.set(i, A.get(i));
			B.set(i + A.size(), A.get((A.size() - i) % A.size()));
		}
		return B;
	}

}
