package sortings;
/*
 * A kind of stable sorting algorithm 
 * Time Complexity -- O(n^2)
 * Space Complexity -- O(1)
 * Date: 2018/07/17
 */
import java.util.*;
public class BubbleSort {
	//sort list
	public List<Integer> listBubbleSort(List<Integer> in) {
		for(int i = 0; i < in.size()-1; i++) {
			for(int j = in.size()-1; j >= i+1; j--) {
				if(in.get(j) < in.get(j-1)) {
					Collections.swap(in, j, j-1);
				}
			}
		}
		return in;
	}
	// sort array
	public static int[] arrBubbleSort(int[] inArr) {
		for(int i = 0; i < inArr.length-1; i++) {
			for(int j = inArr.length-1; j >= i+1; j--) {
				if(inArr[j] < inArr[j-1]) {
					int tmp = inArr[j];
					inArr[j] = inArr[j-1];
					inArr[j-1] = tmp;
				}
			}
		}
		return inArr;
	}	
}
