package tools;

public class ToLower {
	public static String toLowerCase(String str) {
		String st="";
		for(int i=0;i<str.length();i++){
			char t=str.charAt(i);
			int n = (int)t;
			if(t<91&&t>64)
				t=(char) (n+32);
			String s = String.valueOf(t);
			st=st+s;
		}
	    return st; 
	}
	public static void main(String[] args) {
		String string="He%&llO";
		String s=toLowerCase(string);
		System.out.println(s);
	}

}
