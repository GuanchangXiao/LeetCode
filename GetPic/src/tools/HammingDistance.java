package tools;

public class HammingDistance {
	public static int hammingDistance(int x, int y) {
		String sx = "";
		String sy = "";
		int min=0;
		int total=0;
		int lenx=0;
		int leny=0;
	    while(x!=0){
	         sx = x%2+sx;
	         x = x/2;
	    }
	    while(y!=0){
	         sy = y%2+sy;
	         y = y/2;
	    }
	    lenx=sx.length();
	    leny=sy.length();
	    if(lenx>=leny)
	    	min=leny;
	    else
	    	min=lenx;
	    for(int i=min;i>=0;i--){
	    	if(!sx.substring(i-1, i).equals(sy.substring(i, i-1)))
	    		total++;
	    }
	    System.out.println(sx+","+sy);
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hammingDistance(1,4);
	}

}
