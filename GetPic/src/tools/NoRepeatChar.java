package tools;

public class NoRepeatChar {
	public static int lengthOfLongestSubstring(String s) {
		int mx=0;
		int f=0;
		String s0="";
		for(int i=f;i<s.length()-1;i++){
			int len=1;
			for(int j=i+1;j<s.length();j++){
				String t=s.substring(j, j+1);
				s0=s.substring(i, j);
				if(!s0.contains(t)){
					len++;
					if(mx<len)
						mx=len;
				}else {
					f=j;
					if(len>=mx)
						mx=len;
					break;
				}
			}
		}
		if(s.length()==1)
			mx=1;
		if(s.length()==2&&s.substring(0, 1).equals(s.substring(1, 2)))
			mx=1;
		if(s.length()==2&&!(s.substring(0, 1).equals(s.substring(1, 2))))
			mx=2;
		if(s.length()==3){
			String s1=s.substring(0, 1);
			String s2=s.substring(1, 2);
			String s3=s.substring(2, 3);
			if(!s1.equals(s2)&&!s2.equals(s3))
				mx=3;
			if(s1.equals(s2)&&!s2.equals(s3))
				mx=2;
			if(!s1.equals(s2)&&s2.equals(s3))
				mx=2;
			if(!s1.equals(s2)&&s1.equals(s3))
				mx=2;
			if(s1.equals(s2)&&s2.equals(s3))
				mx=1;
		}
        return mx;
    }
	public static void main(String[] args) {
		String s="bank";
		int len=lengthOfLongestSubstring(s);
		System.out.println(len);
	}

}
