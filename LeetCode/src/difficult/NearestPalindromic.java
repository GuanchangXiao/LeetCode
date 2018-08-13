package difficult;
//给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。最近的”定义为两个整数差的绝对值最小。
public class NearestPalindromic {
	public static String nearestPalindromic(String n) {
		int m = Integer.valueOf(n);
		int small= 0;
		int big=m+1;
		for(int i=1;i<m;i++){
			int temp = m-i;
			StringBuffer sb=new StringBuffer(String.valueOf(temp));
			StringBuffer sb2 = new StringBuffer(String.valueOf(temp));
			if((sb.toString()).equals(sb.reverse().toString())){
				small = temp;
				break;
			}
		}
		while(true){
			StringBuffer sb=new StringBuffer(String.valueOf(big));
			StringBuffer sb2 = new StringBuffer(String.valueOf(big));
			if((sb.toString()).equals(sb.reverse().toString())){
				break;
			}
			big++;
		}
		System.out.println(big+","+small);
		if(Math.abs(m-small)>Math.abs(m-big)){
			return String.valueOf(big);
		}else
			return String.valueOf(small);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n="2147483647";
		String res = nearestPalindromic(n);
		System.out.println(res);
	}

}
