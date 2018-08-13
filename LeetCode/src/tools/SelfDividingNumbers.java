package tools;

import java.util.ArrayList;
import java.util.List;

//自除数 是指可以被它包含的每一位数除尽的数。
public class SelfDividingNumbers {
	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<>();
		for(int i=left;i<=right;i++){
			String s=String.valueOf(i);
			if(s.length()==1){
				list.add(i);
				continue;
			}
			else if(s.contains("0"))
				continue;
			else {
				boolean b = true;
				for(int j=0;j<s.length();j++){
					int temp = Integer.valueOf(s.substring(j, j+1));
					if(i%temp!=0){
						b=false;
						break;
					}
				}
				if(b==true)
					list.add(i);
			}
			
		}
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int left = 1;
		int right=22;
		List<Integer> list = selfDividingNumbers(left,right);
		System.out.print("[");
		for(int i=0;i<list.size();i++){
			if(i<list.size()-1)
				System.out.print(list.get(i)+",");
			else {
				System.out.print(list.get(i));
			}
		}
		System.out.println("]");	
	}

}
