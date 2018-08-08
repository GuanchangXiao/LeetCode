package tools;

public class UniqueMorseRepresentations {
	public static int uniqueMorseRepresentations(String[] words) {
		String[] s={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] w=new String[words.length];
        int total=0;
		for(int i=0;i<words.length;i++){
			String temp="";
        	for(int j=0;j<words[i].length();j++){
        		char c = words[i].charAt(j);
        		int in=(int)c-97;
        		temp=temp+s[in];
        	}
        	w[i]=temp;
        }
		int f=1;
		String[] ju=new String[w.length];
		for(int i=0;i<w.length;i++){
			ju[i]="0";
		}
		for(int i=0;i<w.length;i++){
			f=1;
			for(int j=0;j<ju.length;j++){
				if(w[i].equals(ju[j])){
					f=0;
					break;
				}
			}
			if(f==1)
				ju[i]=w[i];
		}
		for(int i=0;i<ju.length;i++){
			if(!ju[i].equals("0"))
				total++;
		}
		return total;
    }
	public static int tongjichar(String[] words) {
		System.out.println("开始时间："+System.currentTimeMillis());
		int total=0;
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<words.length;i++){
			sb.insert(0, words[i]);
        }
		int f=1;
		String[] ju=new String[sb.length()];
		for(int i=0;i<sb.length();i++){
			f=1;
			for(int j=0;j<ju.length;j++){
				if(sb.substring(i, i+1).equals(ju[j])){
					f=0;
					break;
				}
			}
			if(f==1){
				total++;
				ju[i]=sb.substring(i, i+1);
			}
		}
		System.out.println("结束时间："+System.currentTimeMillis());
		
		return total;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[]={"mevzi","mevzi","gvgs","qhiwg","qhisaffffffffffffffjn","b","b","regesrgsegrsergsergb","b","berwevsdafsfasfasfas"};
		//int total=uniqueMorseRepresentations(words);
		int total2=tongjichar(words);
		System.out.println(total2);
	}

}
