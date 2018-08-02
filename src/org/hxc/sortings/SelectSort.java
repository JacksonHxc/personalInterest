package sortings;
/*
 * A kind of unstable sorting algorithm 
 * Time Complexity -- O(n^2)
 * Space Complexity -- O(1)
 * Date: 2018/07/17
 */

import java.util.*;
public class SelectSort {
	//sort list
	public List<Integer> listSelSort(List<Integer> in) {
		for(int i = 0; i < in.size()-1; i++) {
			int min = i;
			//find current min
			for(int j = i+1; j < in.size(); j++) {
				if(in.get(j) < in.get(min))
					min = j;
			}
			//swap min and the ith element
			Collections.swap(in, min, i);
		}
		return in;
	}
	// sort array
	public int[] arrSelSort(int[] inArr) {
		for(int i = 0; i < inArr.length-1; i++) {
			int min = i;
			int tmp;
			for(int j = i+1; j < inArr.length; j++) {
				if(inArr[j] < inArr[min]) {
					min = j;
				}
			}
			tmp = inArr[min];
			inArr[min] = inArr[i];
			inArr[i] = tmp;
		}
		return inArr;
	}
}
