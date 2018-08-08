package zhengwu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyUtil {
	
	public static void getChildUrl(String url){
		Document doc = null;
		List<String> childPagelist = new ArrayList<>();
		System.out.println("---------------------------------开始获取子页面链接-------------------------------------");
		try {
			doc = Jsoup.connect(url).get();
			Elements links = doc.select("a[index]");
			System.out.println(links.size());
	        for (Element link : links) {
	        	String name = link.attr("name");
	        	String s = link.attr("code");
	        	System.out.println(name+s);
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return ;
	}
	public static void getItem(String url){
		Document doc = null;
		List<String> childPagelist = new ArrayList<>();
		System.out.println("---------------------------------开始获取子页面链接-------------------------------------");
		try {
			doc = Jsoup.connect(url).get();
			Elements links = doc.select("div.qlqdsxmc");
			System.out.println(links.size());
	        for (Element link : links) {
	        	String name = link.attr("title");
	        	System.out.println(name);
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return ;
	}
	
}
