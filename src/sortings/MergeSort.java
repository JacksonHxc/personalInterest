package sortings;
/*
 * A kind of stable sorting algorithm 
 * Time Complexity -- O(nlogn)
 * Space Complexity -- O(n)+ O(logn)
 * Date: 2018/07/17
排序时间与输入无关，最佳情况，最坏情况都是如此, 稳定。
原理：
可以将数组分成二组。依次类推，当分出来的小组只有一个数据时，
可以认为这个小组组内已经达到了有序，然后再合并相邻的二个小组就可以了。
这样通过先递归的分解数列，再合并数列就完成了归并排序
归并排序的时间复杂度，合并耗费O(n)时间，而由完全二叉树的深度可知，
整个归并排序需要进行log_2n次，因此，总的时间复杂度为 O(nlogn)，
而且这是归并排序算法中最好、最坏、平均的时间性能。

由于归并排序在归并过程中需要与原始记录序列同样数量的存储空间存放归并结果
 以及 递归时深度为 log_2n 的栈空间，因此空间复杂度为O(n+logn)。
 
另外，对代码进行仔细研究，发现 Merge 函数中有if (L[i]<R[j]) 语句，
这就说明它需要两两比较，不存在跳跃，因此归并排序是一种稳定的排序算法。
也就是说，归并排序是一种比较占用内存，但却效率高且稳定的算法。
*/
import java.util.*;
public class MergeSort {
	public static void mergeSort(int[] array){
		int middle = array.length/2;//中间标
		if(array.length > 1){
			int[] left = Arrays.copyOfRange(array, 0, middle);//拷贝数组array的左半部分
			int[] right= Arrays.copyOfRange(array, middle, array.length);//拷贝数组array的右半部分
			mergeSort(left);//对左边数组递归
			mergeSort(right);//对右边数组递归
			merge(array,left,right);//数组左、右合并到Array
			
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[j]);
	            System.out.print(",");
	        }
	        System.out.println();
		}
	}
	//合并数组，升序
	private static void merge(int[] result, int[] left, int[] right){
		int i = 0, l = 0, r = 0;
		while(l < left.length && r < right.length){
			if(left[l] < right[r]){
				result[i] = left[l];
				i ++;
				l ++;
			}else{
				result[i] = right[r];
				i ++;
				r ++;
			}
		}
		//如果右边剩下合并右边的
		while(r < right.length){
			result[i] = right[r];
			r ++;
			i ++;
		}
		//如果左边剩下合并左边的
		while(l < left.length){
			result[i] = left[l];
			l ++;
			i ++;
		}
	}	 
	public static void main(String[] args) {
		int[] arr = { 55, 56, 23, 90, 47, 9, 40, 82, 76, 33 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		    System.out.print(",");
		}
		System.out.println();
		mergeSort(arr);
	}
}