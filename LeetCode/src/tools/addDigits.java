package tools;
//����һ���Ǹ����� num������������λ�ϵ�������ӣ�ֱ�����Ϊһλ����
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
