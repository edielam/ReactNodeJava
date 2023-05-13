package Sorting;

public class InsertionSort {
    static int[] yourArray;
    public InsertionSort(int[] yourArray) {
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
        int[] arr2 = getYourArray();
        for(int i = 0; i<arr2.length; i++){
            for(int j= i; j> 0; j--){
                if(arr2[j] < arr2[j-1])
                    swap(arr2, j, j-1);
            }
        }
        return arr2;
    }
}
