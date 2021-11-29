import java.util.Arrays;
import java.util.Scanner;

public class SortingAlgorithms{
    public static void main(String[] args) throws Exception{
        StartSortingProgramme();
    }

    private static void StartSortingProgramme(){
        System.out.println(" ");
        System.out.println("Start Sorting Programme:");
        System.out.println("Press 1 for Bubble Sort:");
        System.out.println("Press 2 for Selection Sort:");
        System.out.println("Press 3 for Counting Sort:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        // Input Empty
        // int[] input = {};
        // Input Positive Number
        // int[] input = { 10, 6, 8, 5, 7, 3, 4 };
        // Input with constant numbers
        // int[] input = { 2, 2, 2, 2, 2, 2, 2 };
        // Input with positive and negative numbers
        int[] input = { 10, -6, -8, -5, -7, 3, 4 };
        switch (userInput) {
            case "1":
                SelectSortingOption("Bubble", input);
                StartSortingProgramme();
                break;
                case "2":
                SelectSortingOption("Selection", input);
                StartSortingProgramme();
                break;
                case "3":
                SelectSortingOption("Counting", input);
                StartSortingProgramme();
                break;
            default:
                 System.out.println("Wrong input, try again!");
                 StartSortingProgramme();
            break;
        }
    }

    private static void SelectSortingOption(String SortName, int[] input){
        System.out.println(" ");
        System.out.println(SortName + " Sort:");
        System.out.println("Input Array: " + Arrays.toString(input));
        switch(SortName){
            case "Bubble":
            System.out.println("Sorted Array: " + Arrays.toString(BubbleSort(input)));
            break;
            case "Selection":
            System.out.println("Sorted Array: " + Arrays.toString(SelectionSort(input)));
            break;
            case "Counting":
            System.out.println("Sorted Array: " + Arrays.toString(CountingSort(input)));
            break;
            default:
            System.out.println("Sort Algorithm for " + SortName + " has not been defined.");
            break;
        }
    }

    private static int[] BubbleSort(int[] array) {
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

                    //System.out.println(Arrays.toString(array));
                }
            }
        }
        return array;
    }

    private static int[] SelectionSort(int[] array) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < array.length - 1; i++) {

            //System.out.println(Arrays.toString(array));

            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
        return array;
    }

    private static int[] CountingSort(int[] array) {
        if (array.length == 0) {
            return new int[0];
        } else {
            //System.out.println(Arrays.toString(array));
            
            int max = Arrays.stream(array).max().getAsInt();
            int min = Arrays.stream(array).min().getAsInt();
            //System.out.println("min = " + min);

            int range = max - min + 1;
            int count[] = new int[range];

            for (int i = 0; i < array.length; i++) {
                count[array[i] - min]++;
            }

            //System.out.println(Arrays.toString(count));

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