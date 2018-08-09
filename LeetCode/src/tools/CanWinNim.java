package tools;

public class CanWinNim {
	 public static boolean canWinNim(int n) {
	 	 if(n%4==0)
	 		 return false;
	 	 else {
	 		return true;
		}
		 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=8;
		boolean b=canWinNim(n);
		System.out.println(b);
	}

}
