package tools;

public class FindWords {
	public static String[] findWords(String[] words) {
		String one="qwertyuiopQWERTYUIOP";
		String two="asdfghjklASDFGHJKL";
		String three="zxcvbnmZXCVBNM";
		String[] res=new String[words.length];
		for(int i=0;i<words.length-1;i++){
			String t=words[i].substring(i, i+1);
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
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words={"Hello", "Alaska", "Dad", "Peace"};
		String[] res=findWords(words);
		String[] ss=new String[res.length];
		for(int i=0;i<res.length;i++){
			if(res[i]!=null)
				ss[i]=res[i];
		}
		for(int i=0;i<ss.length-1;i++){
			if(ss[i]!=null&&ss[i+1]!=null){
				System.out.print("\""+ss[i]+"\",");
			}
			if(ss[i]!=null&&ss[i+1]==null){
				System.out.println("\""+ss[i]+"\"");
			}
		}
	}

}
