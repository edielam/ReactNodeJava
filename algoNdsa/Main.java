import Sorting.BubbleSort;

public class Main {
    public static void main(String[] args) {
        int[] intArray = new int[7];
        intArray[0] = 3;
        intArray[1] = -23;
        intArray[2] = 13;
        intArray[3] =-10;
        intArray[4] = 5;
        intArray[5] = 25;

        BubbleSort bSort = new BubbleSort(intArray);
        int[] ans = bSort.getSorted();
        for(int i=0; i< ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}
