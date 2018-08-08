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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[]={"mevzi","mevzi","gvgs","qhiwg","qhijn","b","b","b","b","b"};
		int total=uniqueMorseRepresentations(words);
		System.out.println(total);
	}

}
