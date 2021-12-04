#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void PrintVectorElement(vector<int> array)
{
    for (int i : array)
    {
        cout << i << " ";
    }
}

vector<int> BubbleSort(vector<int> array)
{
    bool toSwap = true;
    int temp;
    while (toSwap)
    {
        toSwap = false;
        for (int i = 0; i < array.size() - 1; i++)
        {
            if (array[i] > array[i + 1])
            {
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                toSwap = true;
                // PrintVectorElement(array);
            }
        }
    }
    return array;
}

vector<int> SelectionSort(vector<int> array)
{
    for (int i = 0; i < array.size() - 1; i++)
    {
        // PrintVectorElement(array);

        int min_idx = i;
        for (int j = i + 1; j < array.size(); j++)
        {
            if (array[j] < array[min_idx])
            {
                min_idx = j;
            }
        }
        int temp = array[min_idx];
        array[min_idx] = array[i];
        array[i] = temp;
    }
    return array;
}

vector<int> CountingSort(vector<int> array)
{
    int max = *max_element(array.begin(), array.end());
    int min = *min_element(array.begin(), array.end());
    // cout << "Max = " << max << endl;
    // cout <<  "Min = " << min << endl;
    int range = max - min + 1;

    vector<int> count(range);

    for (int i = 0; i < array.size(); i++)
    {
        count[array[i] - min]++;
    }
    // PrintVectorElement(count);

    int array_idx = 0;
    for (int i = 0; i < count.size(); i++)
    {
        while (0 != count[i])
        {
            array[array_idx] = i + min;
            count[i] -= 1;
            array_idx += 1;
        }
    }
    return array;
}

void SelectSortingOption(string SortName, vector<int> input)
{
    cout << " " << endl;
    cout << SortName << " Sort: " << endl;
    cout << "Input Array = ";
    PrintVectorElement(input);
    cout << " " << endl;
    cout << "Sorted Array = ";
    if (SortName == "Bubble")
    {
        PrintVectorElement(BubbleSort(input));
    }
    else if (SortName == "Selection")
    {
        PrintVectorElement(SelectionSort(input));
    }
    else if (SortName == "Counting")
    {
        PrintVectorElement(CountingSort(input));
    }
    else
    {
        cout << "Sort Algorithm for " << SortName << " has not been defined";
    }
    cout << " " << endl;
}

void StartSortingProgrammer()
{
    // Input Empty
    // vector<int> input = {};
    // Input Positive Number
    // vector<int> input = { 10, 6, 8, 5, 7, 3, 4 };
    // Input with constant numbers
    // vector<int> input = { 2, 2, 2, 2, 2, 2, 2 };
    // Input with positive and negative numbers
    vector<int> input = {10, -6, -8, -5, -7, 3, 4};
    int userInput = 0;
    cout << " " << endl;
    cout << "Start Sorting Programme: " << endl;
    cout << "Press 1 for Bubble Sort: " << endl;
    cout << "Press 2 for Selection Sort:" << endl;
    cout << "Press 3 for Counting Sort:" << endl;
    cin >> userInput;
    bool isInputValid = false;
    if (cin.good()) // Validate to see user input is an integer
    {
        isInputValid = true;
        switch (userInput)
        {
        case 1:
            SelectSortingOption("Bubble", input);
            StartSortingProgrammer();
            break;
        case 2:
            SelectSortingOption("Selection", input);
            StartSortingProgrammer();
            break;
        case 3:
            SelectSortingOption("Counting", input);
            StartSortingProgrammer();
            break;
        default:
            cout << "Wrong Number! Try again." << endl;
            StartSortingProgrammer();
            break;
        }
    }
    else
    {
        // User Input is not an interger
        // Something went wrong, we reset the buffer's state to good
        cin.clear();
        // and empty it
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Wrong Input! Try again." << endl;
        StartSortingProgrammer();
    }
}

int main()
{
    StartSortingProgrammer();
    return 0;
}
