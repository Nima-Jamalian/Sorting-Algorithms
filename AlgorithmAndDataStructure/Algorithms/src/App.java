import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        StartPrograme();
    }

    public static void StartPrograme() {
        System.out.println("Start Programme:");
        System.out.println("Press 1 for Bubble Sort:");
        System.out.println("Press 2 for Selection Sort:");
        System.out.println("Press 3 for Hybrid Sort:");
        System.out.println("Press 4 for Quick Sort:");
        System.out.println("Press 5 for Merge Sort:");
        System.out.println("Press 6 for Counting Sort:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        // int[] input = { 9, 8, 7, 6 };
        int[] input = { 10, 6, 8, 5, 7, 3, 4 };
        switch (userInput) {
            case "1":
                BubbleSort bubbleSort = new BubbleSort();
                System.out.println("Bubble Sort: " + Arrays.toString(bubbleSort.Start(input)));
                System.out.println("");
                StartPrograme();
                break;
            case "2":
                SelectionSort selectionSort = new SelectionSort();
                System.out.println("Selection Sort: " + Arrays.toString(selectionSort.Start(input)));
                System.out.println("");
                StartPrograme();
                break;
            case "3":
                HybridSort hybridSort = new HybridSort();
                System.out.println("Hybrid Sort: " + Arrays.toString(hybridSort.Start(input)));
                System.out.println("");
                StartPrograme();
                break;
            case "4":
                // Quick Sort
                break;
            case "5":
                MergeSort mergeSort = new MergeSort();
                mergeSort.mergeSort(input, input.length);
                System.out.println("Merge Sort: " + Arrays.toString(input));
                break;
            case "6":
                CountingSort countingSort = new CountingSort();
                System.out.println("Counting Sort: " + Arrays.toString(countingSort.Start(input)));
                break;
            default:
        }
    }
}
