package tools;

public class FindWords {
	public static String[] findWords(String[] words) {
		String one="qwertyuiopQWERTYUIOP";
		String two="asdfghjklASDFGHJKL";
		String three="zxcvbnmZXCVBNM";
		String[] res=new String[words.length];
		for(int i=0;i<words.length;i++){
			String t=words[i].substring(0,1);
			String th="";
			boolean f=true;
			if(one.contains(t))
				th=one;
			if(two.contains(t))
				th=two;
			if(three.contains(t))
				th=three;
			for(int j=0;j<words[i].length();j++){
				String temp = words[i].substring(j, j+1);
				if(!th.contains(temp)){
					f=false;
					break;
				}
			}
			if(f){
				res[i]=words[i];
			}
		}
		int num=0;
		for(int i=0;i<res.length;i++){
			if(res[i]!=null)
				num++;
		}
		String[] ss=new String[num];
		int j=0;
		for(int i=0;i<res.length;i++){
			if(res[i]!=null){
				ss[j]=res[i];
				j++;
			}
				
		}
        return ss;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words={"Hello", "Alaska", "Dad", "Peace"};
		String[] ss=findWords(words);
		
		for(int i=0;i<ss.length;i++){
			if(i<ss.length-1){
				System.out.print("\""+ss[i]+"\",");
			}
			else{
				System.out.println("\""+ss[i]+"\"");
			}
		}
	}

}
