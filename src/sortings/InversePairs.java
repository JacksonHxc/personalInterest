package sortings;
/* implement inverse pairs counting using the thought of mergesort
 * Date: 2018/07/17
 */
public class InversePairs {
    public static int iPairs(int[] array) {
        if (array == null)
            throw new IllegalArgumentException();
        // ������������
        int length = array.length;
        int[] copy = new int[length];
        System.arraycopy(array, 0, copy, 0, length);
        int numberOfInversePairs = iPairs(array, copy, 0, length - 1);
        return numberOfInversePairs;
    }
    /**
     * @param array δ�鲢���� 
     * @param copy ���ڴ洢�鲢�����ݵ�����
     * @param begin ��ʼλ��
     * @param end ����λ��
     * @return ������
     */
    public static int iPairs(int[] array, int[] copy, int begin, int end) {
        if(begin == end)
            return 0;
        int mid = (begin + end) / 2;
        // �ݹ����
        int left = iPairs(copy, array, begin, mid);
        int right = iPairs(copy, array, mid + 1, end);
        // �鲢
        int i = mid, j = end, pos = end;
        int count = 0; // ��¼�����������������        
        while(i >= begin && j >= mid + 1)
        {
            if(array[i] > array[j]) {
                copy[pos--] = array[i--];
                count += j - mid;
            } else
                copy[pos--] = array[j--];
        }        
        while(i >= begin)
            copy[pos--] = array[i--];
        while(j >= mid + 1)
            copy[pos--] = array[j--];       
        return left + right + count;
    }
    public static void main(String... args) {
        int test[] = { 7, 5, 1, 6, 4 };
        int count = iPairs(test);
        System.out.println(count + " ");
    }
}
