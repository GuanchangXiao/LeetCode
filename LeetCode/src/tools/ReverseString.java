package tools;

public class ReverseString {
	public static String reverseString(String s) {
		StringBuffer sb=new StringBuffer(s);
        return sb.reverse().toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="hello";
		String res=reverseString(s);
		System.out.println(res);
	}

}
