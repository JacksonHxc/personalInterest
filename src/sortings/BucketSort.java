package sortings;
/*
 * A kind of stable/unstable sorting algorithm 
 * stable/unstable depends on the sort algorithm inside each bucket
 * Time Complexity -- Worst case O(n^2), best case O(n);
 * Space Complexity -- O(n+m)(Maintaining m size array)
 * See also link: http://hxraid.iteye.com/blog/647759
  *  һ���ǳ��������Ե�����Ӧ�ã�����ڵ�����Χ�̶��ĺ������ݵ����򣬴���ֵȡֵ��Χ��ά��
  *  ������Ͱ�Ļ��֣���ǳ���Ч������
 * Date: 2018/07/19
 */
import java.util.ArrayList;
import java.util.List;

public class BucketSort {
	/**
	 * ����
	 * @param array ����
	 * @param step ��������ÿ��Ͱ�������С
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
	 * ����ֻ�ṩ���飬����Ϊ(max - min + 1) / 200;���Խ���Ĳ��㣬����ƽ��ʱ��Ͽ졣
	 * @param array ����
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
		// ����Ͱ����
		int num = (max - min + 1) / step;
		if( num < 1 )
			num++;
		// ��Ͱ
		for( int i = min; i <= max; i = i + step ){
			List<Integer> bucket = new ArrayList<Integer>();
			list.add(bucket);
		}
		// �����ݷ����ӦͰ��
		for( int i = 0 ; i < array.length ; i++ ){
			int index = ( array[i] - min) / step;
			list.get(index).add(array[i]);
		}
		// ��ÿ��Ͱ�ڲ����򣨿��Եݹ�Ͱ����
		for( int i = 0 ; i < list.size() ; i++ ){
			list.set(i, insert(list.get(i)));
		}
		// ��������Ͱ�Ż�����
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
	 * Ͱ�����򣬸ó����õ��ǲ������򣨽�������Ϊint[]��ΪList�ȽϷ�����ѣ�����ʹ�����������������ݹ�Ͱ����
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