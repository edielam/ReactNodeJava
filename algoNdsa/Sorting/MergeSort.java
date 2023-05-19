package Sorting;

public class MergeSort {
    public static void mergeSort(int[] yourArray) {
        if (yourArray.length <= 1)
            return;
        int mid = yourArray.length / 2;
        int[] left = new int[mid];
        int[] right = new int[yourArray.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = yourArray[i];
        }
        for (int i = mid; i < yourArray.length; i++) {
            right[i - mid] = yourArray[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(yourArray, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] intArray = new int[8];
        intArray[0] = 233;
        intArray[1] = -23;
        intArray[2] = 13;
        intArray[3] = -10;
        intArray[4] = 15;
        intArray[5] = 25;
        intArray[6] = -20;

        mergeSort(intArray);
        System.out.println("Sorted array:");
        for (int num : intArray) {
            System.out.print(num + " ");
        }
    }
}