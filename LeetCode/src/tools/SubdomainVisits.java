package tools;

import java.util.List;

public class SubdomainVisits {
	public static List<String> subdomainVisits(String[] cpdomains) {
		String[] nums=new String[cpdomains.length];
		String[] cpd=new String[cpdomains.length];
		for(int i=0;i<cpdomains.length;i++){
			nums[i]=cpdomains[i].split(" ")[0];
			
		}
        return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cpdomains ={};
		List<String> list = subdomainVisits(cpdomains);
		for (String string : list) {
			System.out.print(string+",");
		}
	}

}
