package tools;

public class FlipAndInvertImage {
	public static int[][] flipAndInvertImage(int[][] A) {
		int[] temp= null;
		System.out.print("[");
		for(int i=0;i<A.length;i++){
			System.out.print("[");
			for(int j=0;j<A[i].length;j++){
				temp= new int[A[i].length];
				temp[j]=A[i][A[i].length - 1 - j];
				int k=temp[j];
				if(k==1)
					temp[j]=0;
				if(k==0)
					temp[j]=1;
				if(j<A[i].length-1)
					System.out.print(temp[j] + ",");
				else {
					System.out.print(temp[j]);
				}
			}
			if(i<A.length-1)
				System.out.print("],");
			else {
				System.out.print("]");
			}
		}
		System.out.println("]");
        return A;
    }
	public static void main(String[] args) {
		int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
		int[][] B = flipAndInvertImage(A);
	}

}
