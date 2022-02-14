import java.util.*;

public class test {

	public static void main(String[] args) {

		int[][] Tests = {
			{},
			{6, 2, 8, 5, 7, 5, 0, 2},
			{2,2,2,2,2,2,2,2},
			{4, -7, 2, 1, 0, 2, 4, 2, -3, 3, -3, 7, -2, 7, 7},
			{-2, -2, -4, -9, -1, -6, -1, -14, -3, -15, -12, -12, -2, -8, -9},
		};

		System.out.println("--------- HybridSort Test---------");
		for (int[] A: Tests) {
			try {
				System.out.println("Given array: " + Arrays.toString(A));
				A = hybridSort(A);
				System.out.println("Array sorted: " + Arrays.toString(A));
			} catch (Exception e) {
				System.out.println("Error for array: " + Arrays.toString(A));
				System.out.println(e);
			}
		}


		/////////////////////////////////////////////////////


		int[][] Tests = {
			{},
			{6, 2, 8, 5, 7, 5, 0, 2},
			{2,2,2,2,2,2,2,2},
			{4, -7, 2, 1, 0, 2, 4, 2, -3, 3, -3, 7, -2, 7, 7},
			{-2, -2, -4, -9, -1, -6, -1, -14, -3, -15, -12, -12, -2, -8, -9},
		};
		System.out.println("--------- MountainSort Test ----------");
		for (int[] A: Tests) {
			try {
				System.out.println("Given array: " + Arrays.toString(A));
				A = MountainSort(A);
				System.out.println("Array sorted: " + Arrays.toString(A));
				System.out.println();
			} catch (Exception e) {
				System.out.println("Error for array: " + Arrays.toString(A));
				System.out.println(e);
			}
		}

	}
}
