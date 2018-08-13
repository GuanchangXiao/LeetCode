package middle;

public class MaxProfitAssignment {
	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		int[] p = new int[worker.length];
		int max=0;
		for(int i=0;i<worker.length;i++){
			int min = 0;
			int t = 0;
			for(int j=0;j<difficulty.length;j++){
				if(worker[i]==difficulty[j]){
					p[i]=j;
					break;
				}
				if(worker[i]>difficulty[j]){
					t=min;
					min=j;
					if(difficulty[j]>=difficulty[t])
						min=j;
					else
						min=t;
				}
			}
			System.out.println(min);
			p[i]=min;
		}
		for(int i=0;i<p.length;i++)
			max+=profit[p[i]];
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] difficulty={2,3,9,20,10};
		int[] profit={10,20,30,40,50};
		int[] worker={4,5,6,7};
		int max = maxProfitAssignment(difficulty, profit, worker);
		System.out.println(max);
	}

}
