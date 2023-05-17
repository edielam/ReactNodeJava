package Sorting;

public class ShellSort {
    static int[] yourArray;
    public ShellSort(int[] yourArray) {
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
        for(int i = arr2.length/2; i>0; i/=2){ // i is the gap
            for(int j=i; j< arr2.length; j++ ){
                if(arr2[j]< arr2[j-i])
                    swap(arr2, j, j-i);
            }
        }
        return arr2;
    }
}
