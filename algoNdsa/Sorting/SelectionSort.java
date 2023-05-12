package Sorting;

public class SelectionSort {
    static int[] yourArray;

    public SelectionSort(int[] yourArray) {
        this.yourArray = yourArray;
    }
    public static int[] getYourArray() {
        return yourArray;
    }
    public static void swap(int[] arr, int i, int j){
        if(i==j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] sorted(){
        int[] arr = getYourArray();
        for(int i= arr.length -1; i > 0; i--){
            int max = 0;
            for(int j=1; j< i; j++){
                if(arr[max] < arr[j]) {
                    max = j;
                }
            }
            swap(arr, max, i);
        }
        return arr;
    }
}
