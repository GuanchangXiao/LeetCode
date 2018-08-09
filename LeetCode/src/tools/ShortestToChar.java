package tools;
//给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
public class ShortestToChar {
	public static int[] shortestToChar(String S, char C) {
		char[] sc = S.toCharArray();
		int[] A = new int[S.length()];
		int[] B = new int[S.length()];
		int f=0;
		for(int i=0;i<sc.length;i++){
			B[i]=-1;
			for(int j=f;j<sc.length;j++){
				if(C==sc[j]){
					B[i]=j;
					f=j+1;
					break;
				}
			}
		}
		for(int i=0;i<sc.length;i++){
			int min=sc.length;
			for(int j=0;j<B.length;j++){
				if(B[j]!=-1&&min>Math.abs((B[j]-i))){
					min=Math.abs((B[j]-i));
				}
			}
			A[i]=min;
		}
        return A;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "baaa";
		char C = 'b';
		int[] A = shortestToChar(S, C);
		System.out.print("[");
		for(int i=0;i<A.length;i++){
			if(i<A.length-1)
				System.out.print(A[i]+",");
			else
				System.out.print(A[i]);
		}
		System.out.println("]");
	}

}
