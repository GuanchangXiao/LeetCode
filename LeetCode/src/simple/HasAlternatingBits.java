package simple;
//����һ����������������Ƿ�Ϊ����λ�������������仰˵���������Ķ����������ڵ�����λ��������ȡ�
public class HasAlternatingBits {
	public static boolean hasAlternatingBits(int n) {
		String s="";
		while(n!=0){
			s+=n%2;
			n=n/2;
		}
		for(int i=0;i<s.length()-1;i++){
			if(s.substring(i, i+1).equals(s.substring(i+1,i+2)))
				return false;
		}
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		System.out.println(hasAlternatingBits(n));
	}

}
