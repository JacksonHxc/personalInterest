package sortings;
/*
 * A kind of stable sorting algorithm 
 * Time Complexity -- O(nlogn)
 * Space Complexity -- O(n)+ O(logn)
 * Date: 2018/07/17
����ʱ���������޹أ��������������������, �ȶ���
ԭ��
���Խ�����ֳɶ��顣�������ƣ����ֳ�����С��ֻ��һ������ʱ��
������Ϊ���С�������Ѿ��ﵽ������Ȼ���ٺϲ����ڵĶ���С��Ϳ����ˡ�
����ͨ���ȵݹ�ķֽ����У��ٺϲ����о�����˹鲢����
�鲢�����ʱ�临�Ӷȣ��ϲ��ķ�O(n)ʱ�䣬������ȫ����������ȿ�֪��
�����鲢������Ҫ����log_2n�Σ���ˣ��ܵ�ʱ�临�Ӷ�Ϊ O(nlogn)��
�������ǹ鲢�����㷨����á����ƽ����ʱ�����ܡ�

���ڹ鲢�����ڹ鲢��������Ҫ��ԭʼ��¼����ͬ�������Ĵ洢�ռ��Ź鲢���
 �Լ� �ݹ�ʱ���Ϊ log_2n ��ջ�ռ䣬��˿ռ临�Ӷ�ΪO(n+logn)��
 
���⣬�Դ��������ϸ�о������� Merge ��������if (L[i]<R[j]) ��䣬
���˵������Ҫ�����Ƚϣ���������Ծ����˹鲢������һ���ȶ��������㷨��
Ҳ����˵���鲢������һ�ֱȽ�ռ���ڴ棬��ȴЧ�ʸ����ȶ����㷨��
*/
import java.util.*;
public class MergeSort {
	public static void mergeSort(int[] array){
		int middle = array.length/2;//�м��
		if(array.length > 1){
			int[] left = Arrays.copyOfRange(array, 0, middle);//��������array����벿��
			int[] right= Arrays.copyOfRange(array, middle, array.length);//��������array���Ұ벿��
			mergeSort(left);//���������ݹ�
			mergeSort(right);//���ұ�����ݹ�
			merge(array,left,right);//�������Һϲ���Array
			
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[j]);
	            System.out.print(",");
	        }
	        System.out.println();
		}
	}
	//�ϲ����飬����
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
		//����ұ�ʣ�ºϲ��ұߵ�
		while(r < right.length){
			result[i] = right[r];
			r ++;
			i ++;
		}
		//������ʣ�ºϲ���ߵ�
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