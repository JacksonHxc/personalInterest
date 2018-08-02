package sortings;
/*
 * A kind of unstable sorting algorithm 
 * Time Complexity -- O(n+k) stable and always in linear time
 * Space Complexity -- O(1)
 * Date: 2018/07/18
 */
// 快排思想：挖坑填数法，
//import java.util.*;
public class QuickSort {
	public static void sort(int[] arr) {
		if(arr == null || arr.length == 0)
			return;
		quicksort(arr, 0, arr.length-1);
	}
	public static void quicksort(int[] a, int l, int r) {
		if(a == null || a.length == 0 || l >= r)
			return;
		int pivot = partition(a, l, r);
		quicksort(a, l, pivot-1);
		quicksort(a, pivot+1, r);
	}	
	private static int partition(int[] a, int s, int e) {
		int tmp = a[s];
		while(s < e) {
			while(a[e] >= tmp && s < e)
				e --;
			if(s < e)
				a[s ++] = a[e];
			while(a[s] < tmp && s < e)
				s ++;
			if(s < e)
				a[e --] = a[s];
		}
		a[s] = tmp;
		return s;
	}
}
