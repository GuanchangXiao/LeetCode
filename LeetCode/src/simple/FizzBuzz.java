package simple;
//写一个程序，输出从 1 到 n 数字的字符串表示。
import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<>();
		for(int i=1;i<=n;i++){
			if(i%3==0&&i%5!=0)
				list.add("Fizz");
			else if(i%3!=0&&i%5==0)
				list.add("Buzz");
			else if(i%3==0&&i%5==0)
				list.add("FizzBuzz");
			else {
				list.add(String.valueOf(i));
			}
		}
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=15;
		List<String> list = fizzBuzz(n);
		System.out.println("[");
		for(int i=0;i<list.size();i++){
			if(i<list.size()-1)
				System.out.println("\""+list.get(i)+"\",");
			else {
				System.out.println("\""+list.get(i)+"\"");
			}
		}
		System.out.println("]");
	}

}
