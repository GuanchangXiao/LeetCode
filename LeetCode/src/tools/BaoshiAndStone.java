package tools;

public class BaoshiAndStone {
	public static int numJewelsInStones(String J, String S) {
		int total=0;
		for(int i=0;i<J.length();i++){
			String bs=J.substring(i, i+1);
			for(int j=0;j<S.length();j++){
				String temp=S.substring(j, j+1);
				if(bs.equals(temp))
					total++;
			}
		}
        return total;
    }
	public static void main(String[] args) {
		String J = "aA";
		String S = "aSSAAbb";
		int total=numJewelsInStones(J, S);
		System.out.println(total);
	}

}
