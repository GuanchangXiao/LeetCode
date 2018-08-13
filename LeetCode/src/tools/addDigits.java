package tools;
//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
public class addDigits {
	public static int addDigits(int num) {
		String s="";
		int t=0;
		String ns = String.valueOf(num);
		if(ns.length()==1)
			return Integer.valueOf(ns);
		else {
			for(int i=0;i<ns.length();i++){
				t+=Integer.valueOf(ns.substring(i, i+1));
			}
			return addDigits(t);
		}
       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=38;
		int res = addDigits(num);
		System.out.println(res);
	}

}
