import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        StartPrograme();
    }

    public static void StartPrograme(){
        System.out.println("Start Programme:");
        System.out.println("Press 1 for Bubble Sort:");
        System.out.println("Press 2 for Selection Sort:");
        System.out.println("Press 3 for Hybrid Sort:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        int[] input = {9,8,7,6};
        switch(userInput){
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
            default:
        }
    }
}
