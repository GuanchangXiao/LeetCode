package tools;

public class TitleToNumber {
	public static int titleToNumber(String s) {
		s = new StringBuffer(s).reverse().toString();
		double lh=0;
		for(int i=0;i<s.length();i++){
			char c = s.substring(i, i+1).charAt(0);
			int t = (int) c-64;
			double temp = t*Math.pow(26, i);
			lh+=temp;
		}
		
        return (int)lh;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ZY";
		int lh = titleToNumber(s);
		System.out.println(lh);
	}

}
