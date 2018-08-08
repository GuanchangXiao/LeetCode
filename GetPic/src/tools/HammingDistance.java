package tools;

public class HammingDistance {
	public static int hammingDistance(int x, int y) {
		int len=0;
		String sx="";
		String sy="";
		StringBuffer syy = null;
		StringBuffer sxx = null;
		int total=0;
	    while(x!=0){
	         sx = x%2+sx;
	         x = x/2;
	    }
	    while(y!=0){
	         sy = y%2+sy;
	         y = y/2;
	    }
	    if(sy.length()>sx.length()){
	    	len=sy.length()-sx.length();
	    	String s="";
	    	for(int i=0;i<len;i++){
	    		s=0+s;
	    	}
	    	sxx = new StringBuffer(sx);
			sxx.insert(0,s);
	    }
	    if(sy.length()<sx.length()){
	    	len=sx.length()-sy.length();
	    	String s="";
	    	for(int i=0;i<len;i++){
	    		s=0+s;
	    	}
	    	syy = new StringBuffer(sy);
			syy.insert(0,s);
	    }
	    if(syy==null){
	    	syy=new StringBuffer(sy);
	    }
	    if(sxx==null){
	    	sxx = new StringBuffer(sx);
	    }
	    
	    for(int i=0;i<sxx.length();i++){
	    	if(!sxx.substring(i, i+1).equals(syy.substring(i, i+1)))
	    		total++;
	    }
        return total;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = hammingDistance(1,4);
		System.out.println(total);
	}

}
