package com.mothaiba.mot.hai;

// Java implementation of iterative Binary Search
class BinarySearch {
    // Returns index of x if it is present in arr[],
    // else return -1
    int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            // Check if x is present at mid
            // TreeNode cur = new TreeNode(arr[m]);
            if (arr[m] == x)
                return m;
            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;
                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    int binarySearchRC(int arr[], int l, int r, int x)
    {
        //base case
        if (l > r)
            return -1;
        int m = l + (r - l) / 2;
        // Check if x is present at mid
        // TreeNode cur = new TreeNode(arr[m]);
        if (arr[m] == x)
            return m;
        // If x greater, ignore left half
        if (arr[m] < x)
            return binarySearchRC(arr, l, m - 1, x);
            // If x is smaller, ignore right half
        return binarySearchRC(arr, m + 1, r, x);
    }
    // Driver method to test above
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 2, 3,1,5,-5,10};
        int n = arr.length-1;

        int result = ob.binarySearchRC(arr,0,n,11);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at "
                    + "index " + result);
    }
}
