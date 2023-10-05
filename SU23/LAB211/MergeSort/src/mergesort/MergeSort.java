package mergesort; // package declaration

public class MergeSort { // class declaration

    public static void main(String[] args) { // main method
        int[] arrayToSort = {8, 2, 5, 3, 4, 7, 6, 1}; // create an array of integers to sort
        mergeSort(arrayToSort); // call the mergeSort method to sort the array

        for (int i = 0; i < arrayToSort.length; i++) { // loop through the sorted array
            System.out.print(arrayToSort[i] + " "); // print each element of the sorted array
        }
    }

    /**
     * Sorts an array of integers using the merge sort algorithm.
     *
     * @param arrayToSort the array to sort
     */
    private static void mergeSort(int[] arrayToSort) {
        int length = arrayToSort.length; // get the length of the array
        if (length <= 1) { // check if the length is less than or equal to 1
            return; // if it is, return because an array of length 1 or less is already sorted
        }
        int middleIndex = length / 2; // calculate the middle index of the array
        int[] leftHalf = new int[middleIndex]; // create a new array for the left half of the input array
        int[] rightHalf = new int[length - middleIndex]; // create a new array for the right half of the input array
        for (int i = 0; i < length; i++) { // loop through the input array
            if (i < middleIndex) { // check if i is less than middleIndex
                leftHalf[i] = arrayToSort[i]; // if it is, add the element at index i to leftHalf
            } else {
                rightHalf[i - middleIndex] = arrayToSort[i]; // otherwise, add it to rightHalf
            }
        }
        mergeSort(leftHalf); // call mergeSort recursively on leftHalf
        mergeSort(rightHalf); // call mergeSort recursively on rightHalf
        merge(leftHalf, rightHalf, arrayToSort); // call the merge method to merge leftHalf and rightHalf into arrayToSort
    }

    /**
     * Merges two sorted arrays into a single sorted array.
     *
     * @param leftArray the first sorted array to merge
     * @param rightArray the second sorted array to merge
     * @param resultArray the resulting merged and sorted array
     */
    private static void merge(int[] leftArray, int[] rightArray, int[] resultArray) {
        int leftLength = leftArray.length; // calculate the length of leftArray (left side of input array)
        int rightLength = rightArray.length; // calculate the length of rightArray (right side of input array)
        int resultIndex = 0; // initialize index resultIndex to 0 (for resultArray)
        int leftIndex = 0; // initialize index leftIndex to 0 (for leftArray)
        int rightIndex = 0; // initialize index rightIndex to 0 (for rightArray)
        while (leftIndex < leftLength && rightIndex < rightLength) { // loop until either leftIndex or rightIndex reaches the end of their respective arrays
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                resultArray[resultIndex] = leftArray[leftIndex];
                resultIndex++;
                leftIndex++;
            } else {
                resultArray[resultIndex] = rightArray[rightIndex];
                resultIndex++;
                rightIndex++;
            }
        }

        // add any remaining elements from leftArray to resultArray
        while (leftIndex < leftLength) {
            resultArray[resultIndex] = leftArray[leftIndex];
            resultIndex++;
            leftIndex++;
        }

        // add any remaining elements from rightArray to resultArray
        while (rightIndex < rightLength) {
            resultArray[resultIndex] = rightArray[rightIndex];
            resultIndex++;
            rightIndex++;
        }
    }

}
