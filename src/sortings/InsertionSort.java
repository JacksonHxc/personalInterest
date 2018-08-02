package sortings;
/*
 * A kind of stable sorting algorithm 
 * Time Complexity -- Worst and Amortized O(n^2), Best O(n)
 * Space Complexity -- O(1)
 * Date: 2018/07/17
 */

import java.util.*;
public class InsertionSort {
	//sort list
	public List<Integer> listInsSort(List<Integer> in) {
		for(int i = 1; i < in.size(); i++) {
			for(int j = i-1; j >= 0; j--) {
				if(in.get(j+1) < in.get(j))
					Collections.swap(in, j+1, j);
			}
		}
		return in;
	}
	// sort array
	public int[] arrInsSort(int[] inArr) {
		int tmp;
		for(int i = 1; i < inArr.length; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(inArr[j+1] < inArr[j]) {
					tmp = inArr[j+1];
					inArr[j+1] = inArr[j];
					inArr[j] = tmp;
				}		
			}
		}
		return inArr;
	}
}
