//Made by Nima Jamalian
//https://nima-jamalian.github.io/CV/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

  private static int[] RadixSort1(int[] array) {
    // Get the maximum element
    int max = Arrays.stream(array).max().getAsInt();

    //Apply counting sort to sort the elements based on place value.
    for (int place = 1; max / place > 0; place *= 10) {
      int[] countingArray = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
      for (int i = 0; i < array.length; i++) countingArray[(array[i] / place) %
        10]++;

      for (int i = 1; i < 10; i++) countingArray[i] += countingArray[i - 1];

      int[] outputArray = { 0, 0, 0, 0, 0, 0, 0, 0 };
      for (int i = array.length - 1; i >= 0; i--) outputArray[--countingArray[(
            array[i] / place
          ) %
          10]] =
        array[i];

      for (int i = 0; i < array.length; i++) array[i] = outputArray[i];
    }
    return array;
  }

  private static int[] RadixSort(int[] array) {
    // Get maximum element
    int max = Arrays.stream(array).max().getAsInt();
    int size = array.length;
    // Apply counting sort to sort elements based on place value.
    for (int place = 1; max / place > 0; place *= 10) {
      //Counting Sort
      int[] output = new int[size + 1];
      max = array[0];
      for (int i = 1; i < size; i++) {
        if (array[i] > max) max = array[i];
      }
      int[] count = new int[max + 1];

      for (int i = 0; i < max; ++i) count[i] = 0;

      // Calculate count of elements
      for (int i = 0; i < size; i++) count[(array[i] / place) % 10]++;

      // Calculate cumulative count
      for (int i = 1; i < 10; i++) count[i] += count[i - 1];

      // Place the elements in sorted order
      for (int i = size - 1; i >= 0; i--) {
        output[count[(array[i] / place) % 10] - 1] = array[i];
        count[(array[i] / place) % 10]--;
      }

      for (int i = 0; i < size; i++) array[i] = output[i];
    }
    return array;
  }

  public static int[] BucketSort(int[] array) {
    int n = array.length;
    if (n <= 0) {
      return new int[0];
    } else {
      int noOfBuckets = 10;
      // Create bucket array
      List<Integer>[] buckets = new List[noOfBuckets];
      // Associate a list with each index
      // in the bucket array
      for (int i = 0; i < noOfBuckets; i++) {
        buckets[i] = new LinkedList<>();
      }
      // Assign numbers from array to the proper bucket
      // by using hashing function
      for (int num : array) {
        //System.out.println("hash- " + hash(num));
        buckets[hash(num)].add(num);
      }
      // sort buckets
      for (List<Integer> bucket : buckets) {
        Collections.sort(bucket);
      }
      int i = 0;
      // Merge buckets to get sorted array
      for (List<Integer> bucket : buckets) {
        for (int num : bucket) {
          array[i++] = num;
        }
      }
      return array;
    }
  }

  // A very simple hash function
  private static int hash(int num) {
    return num / 10;
  }
}
