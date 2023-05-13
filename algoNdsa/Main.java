import Sorting.BubbleSort;
import Sorting.InsertionSort;
import Sorting.SelectionSort;

public class Main {
    public static void main(String[] args) {
        int[] intArray = new int[7];
        intArray[0] = 233;
        intArray[1] = -23;
        intArray[2] = 13;
        intArray[3] =-10;
        intArray[4] = 5;
        intArray[5] = 25;

//        BubbleSort bSort = new BubbleSort(intArray);
//        int[] ans = bSort.getSorted();
//        for(int i=0; i< ans.length; i++){
//            System.out.println(ans[i]);
//        }
//        SelectionSort sSort = new SelectionSort(intArray);
//        int[] ans2 = sSort.sorted();
//        for(int i=0; i< ans2.length; i++){
//            System.out.println(ans2[i]);
//        }
        InsertionSort iSort = new InsertionSort(intArray);
        int[] ans = iSort.sorted();
        for(int i=0; i< ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}
