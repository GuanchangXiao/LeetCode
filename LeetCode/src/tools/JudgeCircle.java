package tools;

public class JudgeCircle {
	public static boolean judgeCircle(String moves) {
		int a=0,b=0;
		boolean re=false;
		for(int i=0;i<moves.length();i++){
			String s=moves.substring(i, i+1);
			switch (s) {
			case "U":
				a++;
				break;
			case "D":
				a--;
				break;
			case "L":
				b++;
				break;
			case "R":
				b--;
				break;
			default:
				break;
			}
		}
		if(a==0&&b==0)
			re=true;
		else {
			re=false;
		}
	    return re;   
	}
	public static void main(String[] args) {
		String moves = "UD";
		boolean res = judgeCircle(moves);
		System.out.println(res);
	}

}
