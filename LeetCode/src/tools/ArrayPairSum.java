package tools;
//给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
public class ArrayPairSum {
	public static int arrayPairSum(int[] nums) {
		int start = 0,total=0;
        int end = nums.length-1;
		sort(nums, start, end);
		for(int i = 0; i<nums.length; i++){
            if(i%2==0)
            	total+=nums[i];
        }
        return total;
    } 
	public static void sort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];
        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
               start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) sort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) sort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,2,1,3};
		int res = arrayPairSum(nums);
		System.out.println(res);
	}

}
