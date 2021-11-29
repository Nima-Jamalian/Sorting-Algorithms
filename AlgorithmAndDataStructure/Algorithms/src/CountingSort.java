import java.util.Arrays;

//Time complexity is O(n)
public class CountingSort {
    public int[] Start(int[] array) {
        if (array.length == 0) {
            return new int[0];
        } else {
            System.out.println(Arrays.toString(array));
            int max = Arrays.stream(array).max().getAsInt();
            int min = Arrays.stream(array).min().getAsInt();
            System.out.println("min = " + min);

            int range = max - min + 1;
            int count[] = new int[range];

            for (int i = 0; i < array.length; i++) {
                count[array[i] - min]++;
            }

            System.out.println(Arrays.toString(count));

            int array_idx = 0;
            for (int i = 0; i < count.length; i++) {
                while (0 != count[i]) {
                    array[array_idx] = i + min;
                    count[i] -= 1;
                    array_idx += 1;
                }
            }
            return array;
        }
    }
}

/*
 * int max = Arrays.stream(array).max().getAsInt();
 * int min = Arrays.stream(array).min().getAsInt();
 * int range = max - min + 1;
 * int count[] = new int[range];
 * int output[] = new int[array.length];
 * for (int i = 0; i < array.length; i++) {
 * count[array[i] - min]++;
 * }
 * 
 * for (int i = 1; i < count.length; i++) {
 * count[i] += count[i - 1];
 * }
 * 
 * for (int i = array.length - 1; i >= 0; i--) {
 * output[count[array[i] - min] - 1] = array[i];
 * count[array[i] - min]--;
 * }
 * 
 * for (int i = 0; i < array.length; i++) {
 * array[i] = output[i];
 * }
 * return array;
 */
/*
 * For simplicity, consider the data in the range 0 to 9.
 * Input data: 1, 4, 1, 2, 7, 5, 2
 * 1) Take a count array to store the count of each unique object.
 * Index: 0 1 2 3 4 5 6 7 8 9
 * Count: 0 2 2 0 1 1 0 1 0 0
 * 
 * 2) Modify the count array such that each element at each index
 * stores the sum of previous counts.
 * Index: 0 1 2 3 4 5 6 7 8 9
 * Count: 0 2 4 4 5 6 6 7 7 7
 * 
 * The modified count array indicates the position of each object in
 * the output sequence.
 * 
 * 3) Rotate the array clockwise for one time.
 * Index: 0 1 2 3 4 5 6 7 8 9
 * Count: 0 0 2 4 4 5 6 6 7 7
 * 
 * 4) Output each object from the input sequence followed by
 * increasing its count by 1.
 * Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 0.
 * Put data 1 at index 0 in output. Increase count by 1 to place
 * next data 1 at an index 1 greater than this index.
 */