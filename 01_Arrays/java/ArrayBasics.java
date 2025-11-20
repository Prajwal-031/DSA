/**
 * Arrays - Basic Operations in Java
 * ==================================
 * This file covers fundamental array operations
 */

public class ArrayBasics {
    
    public static void main(String[] args) {
        // ============================================
        // 1. Array Declaration & Initialization
        // ============================================
        
        // Fixed size array with values
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.print("Array 1: ");
        printArray(arr1);
        
        // Empty array with size
        int[] arr2 = new int[10];  // All zeros by default
        System.out.print("Array with 10 zeros: ");
        printArray(arr2);
        
        // Array with specific size
        int[] arr3 = new int[5];
        System.out.print("Empty array size 5: ");
        printArray(arr3);
        
        // ============================================
        // 2. Accessing Elements
        // ============================================
        
        int[] arr = {10, 20, 30, 40, 50};
        
        System.out.println("\nFirst element: " + arr[0]);      // 10
        System.out.println("Last element: " + arr[arr.length - 1]);  // 50
        System.out.println("Second element: " + arr[1]);      // 20
        
        // ============================================
        // 3. Modifying Elements
        // ============================================
        
        int[] arr4 = {1, 2, 3, 4, 5};
        arr4[0] = 100;  // O(1) operation
        System.out.print("\nAfter update: ");
        printArray(arr4);  // [100, 2, 3, 4, 5]
        
        // ============================================
        // 4. Array Length
        // ============================================
        
        int[] arr5 = {1, 2, 3, 4, 5};
        System.out.println("\nArray length: " + arr5.length);  // 5
        
        // ============================================
        // 5. Iteration Methods
        // ============================================
        
        int[] arr6 = {1, 2, 3, 4, 5};
        
        System.out.println("\nMethod 1 - Traditional for loop:");
        for (int i = 0; i < arr6.length; i++) {
            System.out.print("arr[" + i + "] = " + arr6[i] + ", ");
        }
        System.out.println();
        
        System.out.println("Method 2 - Enhanced for loop:");
        for (int element : arr6) {
            System.out.print(element + " ");
        }
        System.out.println();
        
        // ============================================
        // 6. Searching Elements
        // ============================================
        
        int[] arr7 = {10, 20, 30, 40, 50};
        int target = 30;
        boolean found = false;
        int index = -1;
        
        for (int i = 0; i < arr7.length; i++) {
            if (arr7[i] == target) {
                found = true;
                index = i;
                break;
            }
        }
        
        System.out.println("\nSearch for 30:");
        System.out.println("Found: " + found);
        System.out.println("Index: " + index);
        
        // ============================================
        // 7. Finding Maximum and Minimum
        // ============================================
        
        int[] arr8 = {3, 1, 4, 1, 5, 9, 2, 6};
        
        int max = arr8[0];
        int min = arr8[0];
        
        for (int i = 1; i < arr8.length; i++) {
            if (arr8[i] > max) {
                max = arr8[i];
            }
            if (arr8[i] < min) {
                min = arr8[i];
            }
        }
        
        System.out.println("\nArray: " + java.util.Arrays.toString(arr8));
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        
        // ============================================
        // 8. Sum of Array Elements
        // ============================================
        
        int[] arr9 = {1, 2, 3, 4, 5};
        int sum = 0;
        
        for (int num : arr9) {
            sum += num;
        }
        
        System.out.println("\nSum of array: " + sum);  // 15
        
        // ============================================
        // 9. Multi-dimensional Arrays
        // ============================================
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("\n2D Array:");
        for (int[] row : matrix) {
            printArray(row);
        }
        
        System.out.println("Element at [1][2]: " + matrix[1][2]);  // 6
        
        // ============================================
        // 10. ArrayList (Dynamic Array)
        // ============================================
        
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        
        // Add elements
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("\nArrayList: " + list);
        
        // Access element
        System.out.println("Element at index 1: " + list.get(1));  // 2
        
        // Remove element
        list.remove(0);
        System.out.println("After removing index 0: " + list);
        
        // Size
        System.out.println("Size: " + list.size());
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.println(java.util.Arrays.toString(arr));
    }
}

