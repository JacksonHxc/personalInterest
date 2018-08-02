package sortings;
/*
 * A kind of stable sorting algorithm 
 * Time Complexity -- O(n+k) stable and always in linear time
 * Space Complexity -- O(1)
 * Date: 2018/07/18
 */
//import java.util.*;
public class CountSort {
    public static int[] countSort(int A[]){
        int[] B = new int[A.length]; //to store result after sorting
        int k = Integer.MIN_VALUE;
        for(int n : A)
        	k = Math.max(k, n);
        int [] C = new int[k+1]; // to store temp
        for(int i=0;i<A.length;i++)
            C[A[i]] = C[A[i]] + 1;
        
        // 小于等于A[i]的数的有多少个, 存入数组C
        for(int i=1;i<C.length;i++)
            C[i] = C[i] + C[i-1];
        
        //逆序输出确保稳定-相同元素相对顺序不变
        for(int i=A.length-1;i>=0;i--){
            B[C[A[i]]-1] = A[i]; 
            C[A[i]] = C[A[i]]-1;
        }        
        return B;
    }
//    public static void main(String... args) {
//        int test[] = { 7, 5, 1, 6, 4 };
//        int[] newArray = countSort(test);
//        for(int i = 0; i < newArray.length; i++)
//        	System.out.println(newArray[i]);
//        //result: 1,4,5,6,7
//    }    
}
