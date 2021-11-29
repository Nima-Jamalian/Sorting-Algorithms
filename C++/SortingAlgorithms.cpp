#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void PrintVectorElement(vector<int> array)
{
    for (auto i : array)
    {
        cout << i << " ";
    }
    cout << " " << endl;
}

vector<int> BubbleSort(vector<int> array)
{
    cout << "Unsorted Array = ";
    PrintVectorElement(array);

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
            }
        }
    }

    cout << "Sorted Array = ";
    return array;
}

vector<int> SelectionSort(vector<int> array)
{
    cout << "Unsorted Array = ";
    PrintVectorElement(array);

    for (int i = 0; i < array.size() - 1; i++)
    {
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

    cout << "Sorted Array = ";
    return array;
}

vector<int> CountingSort(vector<int> array)
{

    cout << "Unsorted Array = ";
    PrintVectorElement(array);

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
    //PrintVectorElement(count);

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

    cout << "Sorted Array = ";
    return array;
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
    vector<int> input = { 10, -6, -8, -5, -7, 3, 4 };
    int userInput;
    cout << " " << endl;
    cout << "Start Programme: " << endl;
    cout << "Press 1 for Bubble Sort: " << endl;
    cout << "Press 2 for Selection Sort:" << endl;
    cout << "Press 3 for Counting Sort:" << endl;
    cin >> userInput;
    switch (userInput)
    {
    case 1:
        PrintVectorElement(BubbleSort(input));
        StartSortingProgrammer();
        break;
    case 2:
        PrintVectorElement(SelectionSort(input));
        StartSortingProgrammer();
        break;
    case 3:
        PrintVectorElement(CountingSort(input));
        StartSortingProgrammer();
        break;
    default:
        cout << " Wrong Input! Try again." << endl;
        break;
    }
}

int main()
{
    StartSortingProgrammer();
    return 0;
}
