import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        StartPrograme();

    }

    public static void StartPrograme(){
        int[] input = {7,6,4,3};
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Start Programme:");
        System.out.println("Press 1 for Bubble Sort:");
        System.out.println("Press 2 for Selection Sort:");
        String userInput = scanner.nextLine();
        switch(userInput){
            case "1":
            System.out.println(Arrays.toString(bubbleSort.Start(input)));
            StartPrograme();
            break;
            case "2":
            System.out.println(Arrays.toString(selectionSort.Start(input)));
            StartPrograme();
            break;
            default:
        }
    }
}
