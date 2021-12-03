import java.util.*;

public class HybridSort {
	public static void main(String[] args) {
		int[] A = {10, 5, 3, 9, 8, 7, 6};

		System.out.println("Given array: " + Arrays.toString(A));
		System.out.println();

		A = hybridSort(A);

		System.out.println("Array sorted: " + Arrays.toString(A));
		System.out.println();
	}

	public static int[] hybridSort(int[] A) {
		int right_index = A.length;
		int new_right_index = right_index;
		int left_index = 1;
		int tmp_min_index = 0;
		// while left_index <= right_index:
		boolean swapped = true;

		while (swapped) {
			swapped = false;

			System.out.println("New iteration through the entire array");
			System.out.println(new String(new char[40]).replace('\0', '-'));

			for (int i = left_index; i < right_index; i++) {
				// bubble sorting
				if (A[i-1] > A[i]) {

					System.out.println(String.format("Bubbling A[%d]: %d with A[%d]: %d", i-1, A[i-1], i, A[i]));

					System.out.println("\t\t~> A before: " + Arrays.toString(A));

					// swap them and remember something changed
					int tmp = A[i];
					A[i] = A[i-1];
					A[i-1] = tmp;
					swapped = true;

					System.out.println("\t\t~> A after:  " + Arrays.toString(A));

					// on next iteration, loop only until the last swap
					new_right_index = i-1;

					// save temp minimum index
					if (A[i-1] < A[tmp_min_index]) {
						tmp_min_index = i-1;
					}
				}
			}

			System.out.println();

			// swap minimum to the left of the array
			if (A[left_index-1] > A[tmp_min_index]) {

				System.out.println(String.format("Current minimum: A[%d]: %d | Swapping A[%d]: %d with A[%d]: %d", tmp_min_index, A[tmp_min_index], left_index-1, A[left_index-1], tmp_min_index, A[tmp_min_index]));

				System.out.println("\t\t~> A before: " + Arrays.toString(A));

				int tmp = A[tmp_min_index];
				A[tmp_min_index] = A[left_index-1];
				A[left_index-1] = tmp;

				System.out.println("\t\t~> A after:  " + Arrays.toString(A));

				swapped = true;
				left_index += 1;
			}

			right_index = new_right_index;
			if (swapped) {
				System.out.println(new String(new char[40]).replace('\0', '-'));
				System.out.println(String.format("Finished one pass, only need to bubble from index %d up to index %d next time.", left_index-1, right_index));
			} else {
				System.out.println("No swapped occurred, stopping now.");
			}
			System.out.println();
		}
		return A;
	}
}
