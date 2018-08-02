package sortings;
/*
 * A kind of stable/unstable sorting algorithm 
 * stable/unstable depends on the sort algorithm inside each bucket
 * Time Complexity -- Worst case O(n^2), best case O(n);
 * Space Complexity -- O(n+m)(Maintaining m size array)
 * See also link: http://hxraid.iteye.com/blog/647759
  *  一个非常有启发性的特殊应用：如对于单个范围固定的海量数据的排序，从数值取值范围的维度
  *  来进行桶的划分，会非常有效！！！
 * Date: 2018/07/19
 */
import java.util.ArrayList;
import java.util.List;

public class BucketSort {
	/**
	 * 正序
	 * @param array 数组
	 * @param step 步长，即每个桶的区间大小
	 * @return
	 */
	public static int[] asc(int[] array , int step){
		int min = array[0] , max = array[0];
		for( int i = 1 ; i < array.length ; i++ ){
			if( array[i] > max )
				max = array[i];
			if( array[i] < min )
				min = array[i];
		}
		return sort (array , min , max , step );
	}
	
	/**
	 * 正序，只提供数组，步长为(max - min + 1) / 200;经对结果的测算，方法平均时间较快。
	 * @param array 数组
	 * @return
	 */
	public static int[] asc(int[] array){
		int min = array[0] , max = array[0];
		for( int i = 1 ; i < array.length ; i++ ){
			if( array[i] > max )
				max = array[i];
			if( array[i] < min )
				min = array[i];
		}
		int step = (max - min + 1) / 200;
		if( step < 1 )
			step++;
		return sort (array , min , max , step );
	}	
	
	private static int[] sort( int[] array , int min , int max , int step ){		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		// 计算桶个数
		int num = (max - min + 1) / step;
		if( num < 1 )
			num++;
		// 建桶
		for( int i = min; i <= max; i = i + step ){
			List<Integer> bucket = new ArrayList<Integer>();
			list.add(bucket);
		}
		// 将数据放入对应桶内
		for( int i = 0 ; i < array.length ; i++ ){
			int index = ( array[i] - min) / step;
			list.get(index).add(array[i]);
		}
		// 对每个桶内部排序（可以递归桶排序）
		for( int i = 0 ; i < list.size() ; i++ ){
			list.set(i, insert(list.get(i)));
		}
		// 将排序后的桶放回数组
		int k = 0;
		for( int i = 0 ; i < list.size() ; i++ ){
			List<Integer> temp = list.get(i);
			for( int j = 0 ; j < temp.size() ; j++ ){
				array[k] = (int) temp.get(j);
				k++;
			}
		}
		return array;
	}
	/**
	 * 桶内排序，该程序用的是插入排序（仅仅是因为int[]改为List比较方便而已，可以使用其他方法，甚至递归桶排序）
	 * @param list
	 * @return
	 */
	private static List<Integer> insert( List<Integer> list ) {
		for (int i = 1; i < list.size() ; i++) {
			int key = list.get(i);
			int j = i - 1;
			while ( j >= 0 && list.get(j) > key ) {
				list.set(j+1,list.get(j));
				j = j - 1;
			}
			list.set(j+1,key);
		}
		return list;
	}	
	
    public static void main(String... args) {
        int test[] = { 7, 5, 1, 6, 4 };
        int[] newArray = asc(test, 2);
        for(int i = 0; i < newArray.length; i++)
        	System.out.print(newArray[i]+" ");
        //result: 1,4,5,6,7
    }   	
}