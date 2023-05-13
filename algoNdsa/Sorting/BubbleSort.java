package Sorting;
public class BubbleSort {
    static int[] yourArray;

    public static int[] getYourArray() {
        return yourArray;
    }

    public BubbleSort(int[] yourArray) {
        this.yourArray = yourArray;
    }
    private static void swap(int[] newer, int i, int j){
        if(newer[i] == newer[j])
            return;
        int temp = newer[i];
        newer[i] = newer[j];
        newer[j] = temp;
    }
    public static int[] getSorted(){
        int[] arr = getYourArray();
        for(int i= arr.length - 1; i >0; i--){
            for(int j=0; j< i; j++){
                if(arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
        return arr;
    }
}
