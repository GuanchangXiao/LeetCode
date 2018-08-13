package middle;

import java.text.DecimalFormat;

public class MyPow {
	public static double myPow(double x, int n) {
		double reslut=x;
		if(n>0){
			for(int i=0;i<n-1;i++)
				reslut*=x;
		}if(n<0){
			for(int i=0;i<Math.abs(n+1);i++){
				reslut*=x;
			}
			reslut=1/reslut;
		}if(n==0)
			reslut=1;
        return reslut;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x=2.10000;
		int n=3;
		DecimalFormat df = new DecimalFormat("#.00000");  
		System.out.println(df.format(myPow(x, n)));
	}

}
