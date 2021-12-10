//Made by Nima Jamalian
//https://nima-jamalian.github.io/CV/
#include <iostream>
#include <vector>
#include <algorithm>
#include <memory>
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
    int n = array.size() - 1;
    bool toSwap = true;
    int temp;
    while (toSwap)
    {
        toSwap = false;
        for (int i = 0; i < n; i++)
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
        n--;
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

vector<int> RadixSort(vector<int> array)
{
    // Get maximum element
    int max = *max_element(array.begin(), array.end());
    int size = array.size();
    // Apply counting sort to sort elements based on place value.
    for (int place = 1; max / place > 0; place *= 10)
    {
        //Counting Sort
        vector<int> count(max + 1);
        vector<int> output(size + 1);

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--)
        {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            array[i] = output[i];
    }
    return array;
}


vector<int> BucketSort(vector<int> array)
{
    int n = array.size();
    int max = *max_element(array.begin(), array.end());
    int min = *min_element(array.begin(), array.end());
	int bucketLength = max - min + 1;

    //In C++ "new" means dynamic memory allocation which means it returns a pointer
    vector<int> * bucket = new vector<int>[bucketLength];

	for (int i = 0; i < bucketLength; i++)
	{
		bucket[i] = vector<int>();
	}

	for (int i = 0; i < n; i++)
	{
		bucket[array[i] - min].push_back(array[i]);
	}

	int k = 0;
	for (int i = 0; i < bucketLength; i++)
	{
		int bucketSize = bucket[i].size();

		if (bucketSize > 0)
		{
			for (int j = 0; j < bucketSize; j++)
			{
				array[k] = bucket[i][j];
				k++;
			}
		}
	}
    delete[] bucket;
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
    else if (SortName == "Radix")
    {
        PrintVectorElement(CountingSort(input));
    }
    else if (SortName == "Bucket")
    {
        PrintVectorElement(BucketSort(input));
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
    cout << "Press 4 for Radix Sort:" << endl;
    cout << "Press 5 for Bucket Sort:" << endl;
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
        case 4:
            SelectSortingOption("Radix", input);
            StartSortingProgrammer();
            break;
        case 5:
            SelectSortingOption("Bucket", input);
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
