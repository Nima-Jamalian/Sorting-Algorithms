import java.util.Arrays;

public class BubbleSort {
    public int[] Start(int[] array) {
        System.out.println("Input: " + Arrays.toString(array));
        boolean toSwap = true;
        int temp;
        while (toSwap) {
            toSwap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {

                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    toSwap = true;
                    System.out.println(Arrays.toString(array));
                }
            }
        }
        return array;
    }
}