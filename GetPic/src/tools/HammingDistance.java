package tools;

public class HammingDistance {
	public static int hammingDistance(int x, int y) {
		int n=0;
		String str="";
		int total=0;
		if(x>=y)
			n=x-y;
		else
			n=y-x;
	    while(n!=0){
	         str = n%2+str;
	         System.out.println(n%2);
	         n = n/2;
	         if(n==1)
	        	 total++;
	    }
	    System.out.println(str);
        return total;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = hammingDistance(1,6);
		System.out.println(total);
	}

}
