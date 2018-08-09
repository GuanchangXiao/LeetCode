package tools;
/**¾ØÕóµ¹ÖÃ**/
public class Transpose {
	public static int[][] transpose(int[][] A) {
		int x = A.length;
		int y = A[0].length;
		int[][] B = new int[y][x];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[i].length;j++){
				B[j][i]=A[i][j];
			}
		}
        return B;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] B = transpose(A);
		System.out.print("[");
		for(int i=0;i<B.length;i++){
			System.out.print("[");
			for(int j=0;j<B[i].length;j++){
				if(j<B[i].length-1)
					System.out.print(B[i][j] + ",");
				else {
					System.out.print(B[i][j]);
				}
			}
			if(i<A.length-1)
				System.out.print("],");
			else {
				System.out.print("]");
			}
		}
		System.out.println("]");
	}

}
