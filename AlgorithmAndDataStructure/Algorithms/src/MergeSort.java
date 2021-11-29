public class MergeSort {
    /*
     * Merge Sort:
     * Divide: In this step, we divide the input array into 2 halves, the pivot
     * being the midpoint of the array.
     * This step is carried out recursively for all the half arrays until there are
     * no more half arrays to divide.
     * 
     * Conquer: In this step, we sort and merge the divided arrays from bottom to
     * top and get the sorted array.
     */
    /*
     * Time Complexity: T(n) = 2T(n/2) + O(n)
     * 2T(n/2) corresponds to the time required to sort the sub-arrays and O(n) time
     * to merge the entire array.
     * the time complexity will come to O(nLogn).
     * 
     * Big O means your algorithm will execute in no more steps than in given
     * expression(n^2)
     * 
     * Big Omega means your algorithm will execute in no fewer steps than in the
     * given expression(n^2)
     * 
     * When both condition are true for the same expression, you can use the big
     * theta notation....
     */
    public void mergeSort(int[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = array[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(array, l, r, mid, n - mid);
    }

    public void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k++] = l[i++];
            } else {
                array[k++] = r[j++];
            }
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }
}
