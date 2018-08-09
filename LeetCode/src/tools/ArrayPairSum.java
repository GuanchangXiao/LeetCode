package tools;
//��������Ϊ 2n ������, ��������ǽ���Щ���ֳ� n ��, ���� (a1, b1), (a2, b2), ..., (an, bn) ��ʹ�ô�1 �� n �� min(ai, bi) �ܺ����
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
            //�Ӻ���ǰ�Ƚ�
            while(end>start&&a[end]>=key)  //���û�бȹؼ�ֵС�ģ��Ƚ���һ����ֱ���бȹؼ�ֵС�Ľ���λ�ã�Ȼ���ִ�ǰ����Ƚ�
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //��ǰ����Ƚ�
            while(end>start&&a[start]<=key)//���û�бȹؼ�ֵ��ģ��Ƚ���һ����ֱ���бȹؼ�ֵ��Ľ���λ��
               start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        //��ʱ��һ��ѭ���ȽϽ������ؼ�ֵ��λ���Ѿ�ȷ���ˡ���ߵ�ֵ���ȹؼ�ֵС���ұߵ�ֵ���ȹؼ�ֵ�󣬵������ߵ�˳���п����ǲ�һ���ģ���������ĵݹ����
        }
        //�ݹ�
        if(start>low) sort(a,low,start-1);//������С���һ������λ�õ��ؼ�ֵ����-1
        if(end<high) sort(a,end+1,high);//�ұ����С��ӹؼ�ֵ����+1�����һ��
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,2,1,3};
		int res = arrayPairSum(nums);
		System.out.println(res);
	}

}
