package sortings;
/*
 * A kind of unstable sorting algorithm 
 * Time Complexity -- O(nlogn) unstable depends on input
 * Space Complexity -- O(1) a kind of in-place sort algorithm, that's
 * why when dealing with data in billion size, we use heap sort instead
 * of Merge Sort
 * Date: 2018/07/18
 */
public class HeapSort {
    public static void heapSort(int[] array){
        buildHeap(array);
        int n = array.length;
        int i=0;
        //ȡ�������ѵĸ��ڵ㣬ͬʱ��ȡ��ĩβ��Ҷ�ӽڵ�����Ϊ���ڵ㣬�Ӵ˸��ڵ㿪ʼ�����ѣ�ʹ���������ѵ�����
        //ֱ���ѵĴ�С��n��Ԫ�ؽ���2��
        for(i=n-1;i>=1;i--){
            swap(array,0,i);
            heapify(array,0,i);
//            for (int j = 0; j < array.length; j++) {
//                System.out.print(array[j]);
//                System.out.print(",");
//            }
            //System.out.println();
        }
    } 
     //������
    public static void buildHeap(int[] array){
        for(int i=array.length/2-1;i>=0;i--){
             heapify(array,i,array.length);
        }
    } 
    //������
    public static void heapify(int[] data,int parentNode,int heapSize){
        int leftChild = 2*parentNode+1;// ���������±�
        int rightChild =2*parentNode+2;// ���������±꣨������ڵĻ���
        int largest = 0;
        //Ѱ��3���ڵ������ֵ�ڵ���±�
        if(leftChild<heapSize && data[leftChild]>data[parentNode]){
            largest = leftChild;
        }else if(rightChild<heapSize && data[rightChild]>data[largest]){
            largest = rightChild;
        }else{
            largest = parentNode;
        }
        //������ֵ���Ǹ��ڵ㣬��ô������������������
        if(largest!=parentNode){
            swap(data,largest,parentNode);
            heapify(data,largest,heapSize);            
        }    
    }
    //��������
    public static void swap(int[] array,int i,int j){
        int temp =0;
        temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public static void main(String[] args) {
        int[] arr = { 55, 56, 23, 90, 47, 9, 40, 82, 76, 33 };
        for (int i = 0; i < arr.length; i++) {
            //System.out.print(arr[i]);
            //System.out.print(",");
        }
        //System.out.println();
        heapSort(arr);
    }
}

