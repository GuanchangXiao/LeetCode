package tools;

public class PeakIndexInMountainArray {
	public static int peakIndexInMountainArray(int[] A) {
		int f=0;
		int max=A[f];
		boolean left=true;
		boolean right=true;
		for(int i=0;i<A.length;i++){
			max=A[i];
			f=i;
			left=true;
			right=true;
			for(int j=0;j<f;j++){
				if(A[j]>=max){
					left=false;
					break;
				}
			}
			for(int j=f+1;j<A.length;j++){
				if(A[j]>=max){
					right=false;
					break;
				}
			}
			if(left&&right){
				break;
			}
		}
        return f;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,2,4,0};
		int res = peakIndexInMountainArray(A);
		System.out.println(res);
	}

}
