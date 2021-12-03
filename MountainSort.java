import java.util.Arrays;
import java.util.stream.IntStream;
import java.lang.Math;

public class ModifiedCountingSort {

	public static void main(String[] args) {
		int[] A= {34, 12, 7, 43, 55, 41, 97, 28, 2, 62};

		System.out.println("Given array: " + Arrays.toString(A));
		System.out.println();

		A = modifiedCountingSort(A);

		System.out.println();
		System.out.println("Array sorted: " + Arrays.toString(A));
	}

	public static int[] modifiedCountingSort(int[] A) {
		int k = Arrays.stream(A).max().getAsInt();
		int counter[] = new int[k+1];
		int hi = A.length;
		int mid = (int) Math.floor(hi / 2);

		System.out.println("the max is: " + k + ", the array length: " + A.length + " and the midpoint in the array: " + mid);
		System.out.println("counter initialised as an empty array of length: " + k);
		System.out.println();

		for (int i: A) {
			counter[i] += 1;
		}

		String msg = "counter updated:";
		System.out.println(msg);
		System.out.println(new String(new char[msg.length()]).replace('\0', '-'));

		int split = (int) Math.floor(counter.length / 4);
		printCounter(counter, split);

		// putting it all back into the list, the smaller half ascending
		// the larger half descending
		int ndx = 0;
		for (int i = 0; i < counter.length; i++) {
			while (0 < counter[i]) { // while more to add
				A[ndx] = i;						 // assign to list
				counter[i] -= 1;			 // decrement counter

				printProgress(A, counter, ndx, i);

				ndx += 1;							 // update index
			}
			if (ndx == mid) { 
				break; 
			}
		}

		msg = "done with the first half";
		System.out.println(new String(new char[msg.length()]).replace('\0', '-'));;
		System.out.println(msg);
		System.out.println(new String(new char[msg.length()]).replace('\0', '-'));;

		for (int i = counter.length-1; i > 0; i--) {
			while (0 < counter[i]) { // while more to add
				A[ndx] = i;						 // assign to list
				counter[i] -= 1;			 // decrement counter

				printProgress(A, counter, ndx, i);

				ndx += 1;							 // update index
			}
			if (ndx == hi) { 
				break; 
			}
		}
		return A;
	}

	// intermediate printing
	static void printProgress(int[] A, int[] counter, int ndx, int i) {
		System.out.print(String.format("A[%2d] now %2d | ", ndx, i));
		for (int j = 0; j < A.length; j++) {
			System.out.print(String.format("%2d", A[j]) + " ");
		}
		System.out.println(String.format("| counter at index %2d decreased to %2d", i, counter[i]));
	}

	// print counter & indices reducing the line width
	static void printCounter(int[] counter, int split) {

		for (int i = 0; i < counter.length; i+=split) {
			if (i + split > counter.length) {
				System.out.print("index: ");
				for (int j = i; j < counter.length; j++) {
					System.out.print(String.format("%2d", j) + " ");
				}
				System.out.println();
				System.out.print("count: ");
				for (int j = i; j < counter.length; j++) {
					System.out.print(String.format("%2d", counter[j]) + " ");
				}
				System.out.println();
			} else {
				System.out.print("index: ");
				for (int j = i; j < i + split; j++) {
					System.out.print(String.format("%2d", j) + " ");
				}
				System.out.println();
				System.out.print("count: ");
				for (int j = i; j < i + split; j++) {
					System.out.print(String.format("%2d", counter[j]) + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println(new String(new char[40]).replace('\0', '-'));;
		System.out.println();
	}
}
