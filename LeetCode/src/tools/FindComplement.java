package tools;

public class FindComplement {
	public static int findComplement(int num) {
		String str="";
		double total=0;
		StringBuffer sy=new StringBuffer("");
		while(num!=0){
			str=num%2+str;
			num=num/2;
		}
		for(int i=0;i<str.length();i++){
			if(str.substring(i, i+1).equals("0")){
				sy.insert(0,"1");
			}
			if(str.substring(i, i+1).equals("1")){
				sy.insert(0,"0");
			}
		}
		for(int i=0;i<sy.length();i++){
			total=total+Integer.valueOf(sy.substring(i, i+1))*Math.pow(2, i);
		}
		
        return (int)total;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=3;
		int res = findComplement(num);
		System.out.println(res);
	}

}
