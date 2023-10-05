import java.util.Scanner;

public class Quick_Sort2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt(); // Read the number of elements to sort
        int[] array = new int[arrayLength]; // Create an array to store the elements
        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt(); // Read the elements from the user
        }
        quickSort(array, 0, arrayLength - 1); // Sort the array using Quick Sort algorithm
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " "); // Print the sorted array
        }
    }

    private static void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (rightIndex <= leftIndex) { // Base case: if the right index is less than or equal to the left index, return
            return;
        }
        int pivotValue = (array[leftIndex] + array[rightIndex]) / 2; // Choose the pivot as the average of the first and last elements
        int leftPointer = leftIndex; // Set leftPointer to the left index
        int rightPointer = rightIndex; // Set rightPointer to the right index
        while (leftPointer <= rightPointer) { // While leftPointer is less than or equal to rightPointer
            while (array[leftPointer] < pivotValue) { // Move leftPointer to the right until an element greater than or equal to the pivot is found
                leftPointer++;
            }
            while (array[rightPointer] > pivotValue) { // Move rightPointer to the left until an element less than or equal to the pivot is found
                rightPointer--;
            }
            if (leftPointer <= rightPointer) { // If leftPointer is less than or equal to rightPointer
                int temp = array[leftPointer]; // Swap the elements at positions leftPointer and rightPointer
                array[leftPointer] = array[rightPointer];
                array[rightPointer] = temp;
                leftPointer++; // Increment leftPointer
                rightPointer--; // Decrement rightPointer
            }
        }
        quickSort(array, leftIndex, rightPointer); // Recursively sort the left partition
        quickSort(array, leftPointer, rightIndex); // Recursively sort the right partition
    }

}