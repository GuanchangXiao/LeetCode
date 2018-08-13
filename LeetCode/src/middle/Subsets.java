package middle;

import java.util.ArrayList;
import java.util.List;

//获取集合的子集
public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> re=new ArrayList<>();
		int f=1;
		int h=0;
		for(int i=0;i<nums.length;i++){
			List<Integer> list = new ArrayList<>();
			for(int j=i+1;j<nums.length;j++){
				list.add(new Integer(nums[j]));
				f++;
			}
			h++;
			re.add(list);
		}
        return re;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums ={1,2,3};
		List<List<Integer>> res = subsets(nums);
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.println(integer+",");
			}
		}
	}
}
