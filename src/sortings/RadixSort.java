package sortings;
/*
 * A kind of stable sorting algorithm
 * Time Complexity -- Worst case O(n^2), best case O(n);
 * Space Complexity -- O(n+m)(Maintaining m size array);
 * 
 * ��������
 * ���Ͱʽ���򣬷����ִӸ�λ����λ�ʹӵ�λ����λ����������Ϊ�ӵ�λ����λ
 * ��һ�����õ����������λ��
 * �ڶ��������ж�� Ͱʽ���򣬴���Ϊ����������ֵ�λ��
 * 
 * ���ӣ�52,38,23,72,271
 * ��һ��������Ԫ�����λ��Ϊ3,
 * �ڶ�������һ��Ͱʽ�����������Ԫ�صĸ�λ��������Ϊ��271��52,72,23,38������λͰʽ����������
 * ������     �ڶ���Ͱʽ���򣬰�������Ԫ�ص�ʮλ��������Ϊ��23,38,52,271,72
 * ������     ������Ͱʽ���򣬰�������Ԫ�صİ�λ��������Ϊ��23,38,52,72,271
 * ������ɡ�
 * Date: 2018/07/19
 */
public class RadixSort {
	public static void sort(int[] array) {
		 int maxW = 0;
		 int index=0;
		 //��һ�����õ����������Ԫ�ص�λ��
		 for(int i=0;i<array.length;i++){
			 if(maxW<array[i]){
				 maxW = array[i];
			 }
		 }
//		 System.out.println("maxW is:"+maxW);
		 maxW = getNumberLength(maxW);
//		 System.out.println("���λ��Ϊ��"+maxW);
		 //�ڶ��������ж�� Ͱʽ���򣬴���Ϊ����������ֵ�λ��
		 while(index<maxW){
			 int[] tempArray = new int[array.length];
			 int[] bucketArray = new int[10];
			 System.arraycopy(array, 0, tempArray, 0, array.length);
			 for(int i=0;i<array.length;i++){
				 bucketArray[getNumberIndex(index, array[i])]++;
			 }		 
//			 System.out.println("��ʱ�������ݣ�");
//			 printArray(bucketArray);
//			 System.out.println();
			 for(int i=1;i<bucketArray.length;i++){
				 bucketArray[i]=bucketArray[i]+bucketArray[i-1];
			 }
			 for(int i=array.length-1;i>=0;i--){
				 array[--bucketArray[getNumberIndex(index, tempArray[i])]] = tempArray[i];
			 }
			 index++;
//			 System.out.println("��"+index+"�����");
//			 printArray(array);
//			 System.out.println();
		 }
	 }	 
	 private static int getNumberIndex(int index,int number){
		 int num=0;
		 num = (int)(number/Math.pow(10, index))%10;
//		 System.out.println("number is:"+num);
		 return num;
	 }	 
	 private static int getNumberLength(int number){
		 int count = 1;
		 int index = 1;
//			 System.out.println("math:"+((int)(number/Math.pow(10, index))));
		 while((int)(number-Math.pow(10, index))>0){//Math.pow(x,y)����x��y����
			 count++;
			 index++;
		 }
		 System.out.println("count is:"+count);
		 return count;
	 }
}
