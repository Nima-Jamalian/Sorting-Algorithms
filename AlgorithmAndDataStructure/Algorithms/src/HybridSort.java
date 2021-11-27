import java.util.Arrays;

/*
Hybrid Sort is an algorithm that mixes the ideas behind Bubble Sort and Selection
Sort.
At the end of the first iteration of Bubble Sort (when sorting from smallest to largest),
the greatest value is stored in the last position of the array whilst at the end of the first
iteration of Selection Sort (when sorting from smallest to largest) the lowest element
is stored in the first position of the array.
Hybrid sort will mix both sorting algorithms in such a way that at the end of the first
iteration the largest element is in the last position of the array (due to Bubble Sort)
and the lowest element will be stored in the first position of the array (due to
Selection Sort).
*/
public class HybridSort {
    public int[] Start(int[] array) {
        System.out.println("Input: " + Arrays.toString(array));
        int temp;
        int min_idx = 0;
        for (int i = 0; i < array.length - 1; i++) {
            min_idx = i;
            if (array[i] > array[i + 1]) {
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                System.out.println(Arrays.toString(array));
            }
            if (array[min_idx] > array[i + 1]) {
                min_idx = i + 1;
                System.out.println(Arrays.toString(array));
            }
        }
        temp = array[0];
        array[0] = array[min_idx];
        array[min_idx] = temp;
        return array;
    }
}
