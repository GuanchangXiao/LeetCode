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
		String judue="";
		for(int i=0;i<w.length;i++){
			if(!judue.contains(w[i])){
				total++;
				judue=w[i]+"+"+judue;
			}
		}
		return total;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[]={"gin", "zen", "gig", "msg"};
		int total=uniqueMorseRepresentations(words);
		System.out.println(total);
	}

}
