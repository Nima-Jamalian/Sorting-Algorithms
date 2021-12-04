import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortingAlgorithms {

  public static void main(String[] args) throws Exception {
    StartSortingProgramme();
  }

  private static void StartSortingProgramme() {
    System.out.println(" ");
    System.out.println("Start Sorting Programme:");
    System.out.println("Press 1 for Bubble Sort:");
    System.out.println("Press 2 for Selection Sort:");
    System.out.println("Press 3 for Counting Sort:");
    System.out.println("Press 4 for Radix Sort:");
    System.out.println("Press 5 for Bucket Sort:");
    System.out.println("Press 6 for Hybrid (Bubble + Selection) Sort:");
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    // Input Empty
    // int[] input = {};
    // Input Positive Number
    int[] input = { 10, 6, 8, 5, 7, 3, 4 };
    // Input with constant numbers
    // int[] input = { 2, 2, 2, 2, 2, 2, 2 };
    // Input with positive and negative numbers
    //int[] input = { 10, -6, -8, -5, -7, 3, 4 };
    switch (userInput) {
      case "1":
        SelectSortingOption("Bubble", input);
        break;
      case "2":
        SelectSortingOption("Selection", input);
        break;
      case "3":
        SelectSortingOption("Counting", input);
        break;
      case "4":
        SelectSortingOption("Radix", input);
        break;
      case "5":
        SelectSortingOption("Bucket", input);
        break;
      case "6":
        SelectSortingOption("Hybrid", input);
        break;
      default:
        System.out.println("Wrong input, try again!");
        StartSortingProgramme();
        break;
    }
  }

  private static void SelectSortingOption(String SortName, int[] input) {
    System.out.println(" ");
    System.out.println(SortName + " Sort:");
    System.out.println("Input Array: " + Arrays.toString(input));
    switch (SortName) {
      case "Bubble":
        System.out.println(
          "Sorted Array: " + Arrays.toString(BubbleSort(input))
        );
        break;
      case "Selection":
        System.out.println(
          "Sorted Array: " + Arrays.toString(SelectionSort(input))
        );
        break;
      case "Counting":
        System.out.println(
          "Sorted Array: " + Arrays.toString(CountingSort(input))
        );
        break;
      case "Radix":
        System.out.println(
          "Sorted Array: " + Arrays.toString(RadixSort(input))
        );
        break;
      case "Bucket":
        System.out.println(
          "Sorted Array: " + Arrays.toString(BucketSort(input))
        );
        break;
      case "Hybrid":
        System.out.println(
          "Sorted Array: " + Arrays.toString(HybridSort(input))
        );
        break;
      default:
        System.out.println(
          "Sort Algorithm for " + SortName + " has not been defined."
        );
        break;
    }
    StartSortingProgramme();
  }

  private static int[] BubbleSort(int[] array) {
    int n = array.length - 1;
    boolean toSwap = true;
    int temp;
    while (toSwap) {
      toSwap = false;
      for (int i = 0; i < n; i++) {
        if (array[i] > array[i + 1]) {
          temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          toSwap = true;
          //System.out.println(Arrays.toString(array));
        }
      }
      n--;
    }
    return array;
  }

  private static int[] SelectionSort(int[] array) {
    // One by one move boundary of unsorted subarray
    for (int i = 0; i < array.length - 1; i++) {
      //System.out.println(Arrays.toString(array));

      // Find the minimum element in unsorted array
      int min_idx = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[min_idx]) {
          min_idx = j;
        }
      }
      
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

  private static int[] HybridSort(int[] array) { //Combination of Bubble sort and Selection sort
    return array;
  }

  private static void Swap(int[] array, int i, int j) {
    int temp = array[j];
    array[j] = array[i];
    array[i] = temp;
  }

  private static int[] MountainSort(int[] array) { //ModifiedCountingSort
    return array;
  }

  private static int[] RadixSort(int[] array) {
    // int max = Arrays.stream(array).max().getAsInt();
    // System.out.println(max);

    // for(int s = 1; max/s > 0; s *= 10){
    //     int[] countingArray = {0,0,0,0,0,0,0,0,0,0};
    //     for (int i = 0; i < array.length; i++)
    //       countingArray[(array[i] / s) % 10]++;

    //     for (int i = 1; i < 10; i++)
    //       countingArray[i] += countingArray[i - 1];

    //     int[] outputArray = {0,0,0,0,0,0,0,0};
    //     for (int i = array.length - 1; i >= 0; i--)
    //       outputArray[--countingArray[(array[i] / s) % 10]] = array[i];

    //     for (int i = 0; i < array.length; i++)
    //       array[i] = outputArray[i];
    // }
    // System.out.println("Testing");
    return array;
  }

  public static int[] BucketSort(int[] array) {
    return array;
  }
}
