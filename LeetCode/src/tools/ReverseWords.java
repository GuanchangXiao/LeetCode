package tools;

public class ReverseWords {
	public static String reverseWords(String s) {
		StringBuffer sb = new StringBuffer(s);
		String ss=sb.reverse().toString();
		String[] sa=ss.split(" ");
		String res="";
		for(int i=sa.length-1;i>=0;i--){
			if(i==0)
				res+=sa[i];
			else
				res+=sa[i]+" ";
		}
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="Let's take LeetCode contest";
		String reString = reverseWords(s);
		System.out.println(reString);
	}

}
