package sortings;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
public class SortTest {
    public static void main(String[] args) {
    	
    	//generate random array
        //int test[] = getRd(10000000, 100000000);
    	int[] test = generateIntArray(1000000000);
        NumberFormat f = new DecimalFormat("#0.00000");
        
        //set baseline O(n) time
    	long basStart = System.currentTimeMillis();
    	int dum = 0;
    	for(int i = 0; i < test.length; i++)
    		dum = test[i];
    	long basEnd = System.currentTimeMillis();
    	System.out.println("Execution time of baseline O(n) is " + f.format((basEnd - basStart) / 1000d) + " seconds");
    	
        //test own method quick sort -- 2018.07.18 version
/*        long qsStart = System.currentTimeMillis();
        int[] test0 = test;
        QuickSort.sort(test0);
        long qsEnd = System.currentTimeMillis();
        System.out.println("Execution time of quick sort is " + f.format((qsEnd - qsStart) / 1000d) + " seconds");*/
        
        //test jdk's dual pivot quicksort starting from jdk1.7.0
        long sysStart = System.currentTimeMillis();
        int[] test1 = test;
        IntDualPivotSort.sort(test1);
        long sysEnd = System.currentTimeMillis();
        System.out.println("Execution time of System sort is " + f.format((sysEnd - sysStart) / 1000d) + " seconds"); 
        
        //test countsort -- untunned 2018.07.19 version
        long csStart = System.currentTimeMillis();
        int[] test4 = test;
        test4 = CountSort.countSort(test4);
        long csEnd = System.currentTimeMillis();
        System.out.println("Execution time of count sort is " + f.format((csEnd - csStart) / 1000d) + " seconds");
        
        //test heapsort -- untunned 2018.07.19 version
        long hpStart = System.currentTimeMillis();
        int[] test5 = test;
        HeapSort.heapSort(test5);
        long hpEnd = System.currentTimeMillis();
        System.out.println("Execution time of heap sort is " + f.format((hpEnd - hpStart) / 1000d) + " seconds");
        
//        //test bucketsort -- untunned 2018.07.19 version
//        long bucketsStart = System.currentTimeMillis();
//        int[] dummy1 = BucketSort.asc(test);
//        long bucketsEnd = System.currentTimeMillis();
//        System.out.println("Execution time of bubble sort is " + f.format((bucketsEnd - bucketsStart) / 1000d) + " seconds");
//        
//        //test bucketsort -- untunned 2018.07.19 version
//        long bucketsStart = System.currentTimeMillis();
//        int[] dummy1 = BucketSort.asc(test);
//        long bucketsEnd = System.currentTimeMillis();
//        System.out.println("Execution time of bubble sort is " + f.format((bucketsEnd - bucketsStart) / 1000d) + " seconds");
//        
//        //test bucketsort -- untunned 2018.07.19 version
//        long bucketsStart = System.currentTimeMillis();
//        int[] dummy1 = BucketSort.asc(test);
//        long bucketsEnd = System.currentTimeMillis();
//        System.out.println("Execution time of bubble sort is " + f.format((bucketsEnd - bucketsStart) / 1000d) + " seconds");
//        
//        //test bucketsort -- untunned 2018.07.19 version
//        long bucketsStart = System.currentTimeMillis();
//        int[] dummy1 = BucketSort.asc(test);
//        long bucketsEnd = System.currentTimeMillis();
//        System.out.println("Execution time of bubble sort is " + f.format((bucketsEnd - bucketsStart) / 1000d) + " seconds");
        
        //test bucketsort -- untunned 2018.07.19 version
        long bucketsStart = System.currentTimeMillis();
        int[] test3 = test;
        test3 = BucketSort.asc(test3);
        long bucketsEnd = System.currentTimeMillis();
        System.out.println("Execution time of bucket sort is " + f.format((bucketsEnd - bucketsStart) / 1000d) + " seconds");  
        
        //test bubblesort -- 2018.07.18 version
        long bsStart = System.currentTimeMillis();
        int[] test2 = test;
        test2 = BubbleSort.arrBubbleSort(test2);
        long bsEnd = System.currentTimeMillis();
        System.out.println("Execution time of bubble sort is " + f.format((bsEnd - bsStart) / 1000d) + " seconds");        
        
    }
    
    
    
    public static int[] getRd(int size, int max) {
    	Set<Integer> res = new HashSet<Integer>();
    	int[] arr = new int[size];
    	Random rd = new Random();
    	while(res.size() < size) {
    		Integer next = rd.nextInt(max)+1;
    		res.add(next);
    	}
    	int i = 0;
    	for(int x : res)
    		arr[i++] = x;
    	return arr;
    }
    public static void printArr(int[] a) {
        for(int i = 0; i < a.length; i++)
        	System.out.print(a[i] + " ");    	
    }
    public static int[] generateIntArray(int length) {
    	long gsStart = System.currentTimeMillis();
        int[] intArr = new int[length];
        for (int i = 0; i < length; i++) {
            intArr[i] = new Double(Math.random() * length).intValue();
        }
        long gsEnd = System.currentTimeMillis();
        NumberFormat f = new DecimalFormat("#0.00000");
        System.out.println("Execution time of generate array is " + f.format((gsEnd - gsStart) / 1000d) + " seconds");       
        return intArr;
    }   
}
