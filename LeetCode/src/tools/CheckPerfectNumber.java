package tools;

import java.util.ArrayList;
import java.util.List;
//对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
public class CheckPerfectNumber {
	public static boolean checkPerfectNumber(int num) {
		int total=0;
		if(num%2==1||num==0)
			return false;
		for(int i=1;i<=num/2;i++){
			if(num%i==0)
				total+=i;
		}
		if(total==num)
			return true;
		else {
			return false;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=99999998;
		boolean b=checkPerfectNumber(num);
		System.out.println(b);
	}

}
