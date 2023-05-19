import Sorting.*;
;

public class Main {
    //Recursion
    public static int recursiveFactorial(int num){
        if(num == 0)
            return 1;
        return num * recursiveFactorial(num -1 );
    }
    public static void main(String[] args) {
        int[] intArray = new int[8];
        intArray[0] = 233;
        intArray[1] = -23;
        intArray[2] = 13;
        intArray[3] =-10;
        intArray[4] = 5;
        intArray[5] = 25;
        intArray[6] =-20;

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
//        InsertionSort iSort = new InsertionSort(intArray);
//        int[] ans = iSort.sorted();
//        for(int i=0; i< ans.length; i++){
//            System.out.println(ans[i]);
//        }
//        ShellSort shellSort = new ShellSort(intArray);
//        int[] ans = shellSort.sorted();
//        for(int i=0; i< ans.length; i++){
//            System.out.println(ans[i]);
//        }
//        System.out.println("Factorial of 5 is: "+recursiveFactorial(5));
        System.out.println("Sorted array:");
        for (int num : intArray) {
            System.out.print(num + " ");
        }
    }
}
