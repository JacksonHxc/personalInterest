package sortings;
/*
 * A kind of stable sorting algorithm
 * Time Complexity -- Worst case O(n^2), best case O(n);
 * Space Complexity -- O(n+m)(Maintaining m size array);
 * 
 * 基数排序
 * 结合桶式排序，分两种从高位到低位和从低位到高位。案例代码为从低位到高位
 * 第一步：得到数组内最大位数
 * 第二步：进行多次 桶式排序，次数为排序最大数字的位数
 * 
 * 例子：52,38,23,72,271
 * 第一步：数组元素最大位数为3,
 * 第二步：第一次桶式排序，针对数组元素的个位：排序结果为：271，52,72,23,38，按个位桶式排序就完成了
 * 继续：     第二次桶式排序，按照数组元素的十位：排序结果为：23,38,52,271,72
 * 继续：     第三次桶式排序，按照数组元素的百位：排序结果为：23,38,52,72,271
 * 排序完成。
 * Date: 2018/07/19
 */
public class RadixSort {
	public static void sort(int[] array) {
		 int maxW = 0;
		 int index=0;
		 //第一步：得到数组内最大元素的位数
		 for(int i=0;i<array.length;i++){
			 if(maxW<array[i]){
				 maxW = array[i];
			 }
		 }
//		 System.out.println("maxW is:"+maxW);
		 maxW = getNumberLength(maxW);
//		 System.out.println("最大位数为："+maxW);
		 //第二步：进行多次 桶式排序，次数为排序最大数字的位数
		 while(index<maxW){
			 int[] tempArray = new int[array.length];
			 int[] bucketArray = new int[10];
			 System.arraycopy(array, 0, tempArray, 0, array.length);
			 for(int i=0;i<array.length;i++){
				 bucketArray[getNumberIndex(index, array[i])]++;
			 }		 
//			 System.out.println("临时数组内容：");
//			 printArray(bucketArray);
//			 System.out.println();
			 for(int i=1;i<bucketArray.length;i++){
				 bucketArray[i]=bucketArray[i]+bucketArray[i-1];
			 }
			 for(int i=array.length-1;i>=0;i--){
				 array[--bucketArray[getNumberIndex(index, tempArray[i])]] = tempArray[i];
			 }
			 index++;
//			 System.out.println("第"+index+"排序后：");
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
		 while((int)(number-Math.pow(10, index))>0){//Math.pow(x,y)计算x的y次幂
			 count++;
			 index++;
		 }
		 System.out.println("count is:"+count);
		 return count;
	 }
}
