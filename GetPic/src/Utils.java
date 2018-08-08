import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Utils {
	static String pdir="";
	static String rootdir="D:\\catch\\";
	public static void getHtml(String url,int page){
		int i=10;
		Document doc = null;
		System.out.println("-----------------------------线程："+Thread.currentThread().getName()+"-----------");
		//String[] plist={"http://thz4.com/forum-42-","http://thz4.com/forum-56-","http://thz4.com/forum-57-","http://thz4.com/forum-221-","http://thz4.com/forum-239-"};
		List<String> clList = new ArrayList<>();
		for( i=1;i<=page;i++){
			clList=getChildHref(url,i);//获取子页面链接
		}
		for(i=0;i<clList.size();i++){
			getImgSrc(clList.get(i));
		}
	}
	//获取一个父页面下的所有子页面
	private static List<String> getChildHref(String purl,int page){
		String url = purl + page + ".html";
		Document doc = null;
		List<String> childPagelist = new ArrayList<>();
		System.out.println("---------------------------------开始获取子页面链接-------------------------------------");
		try {
			doc = Jsoup.connect(url).get();
			pdir = doc.title();
			Elements links = doc.select("a[href]");
	        for (Element link : links) {
	        	String s = link.attr("abs:href");
	        	if(!childPagelist.contains(s)&&s.contains("http://thz4.com/thread")){
	        		//print("%s", s);
	        		childPagelist.add(s);
	        	}
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File file=new File(rootdir+pdir);
		if(!file.exists()){//如果文件夹不存在
			file.mkdir();//创建文件夹
		}
		return childPagelist;
	}
	//获取某个子页面的所有img链接
	private  static List<String> getImgSrc(String url){
		Document doc = null;
		String title = "";
		List<String> imglist = new ArrayList<>();
		System.out.println("---------------------------------开始获取子页面的图片链接-------------------------------------");
		System.out.println(url);
		try {
			doc = Jsoup.connect(url).get();
			title = doc.title();
			System.out.println(title);
			Elements media = doc.select("img[file]");
			print("\nMedia: (%d)", media.size());
			if(media.size()>0){
				for (Element src : media) {
		        	String s = src.attr("abs:file");
		        	if(!imglist.contains(s))
		        		imglist.add(s);
		        		//print("%s", s);	
		        }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		downImag(imglist,title);//下载图片
		return null;
	}
	//根据传来的url下载图片到本地
	private static void downImag(List<String> url,String fname){
		fname = rootdir+pdir+"\\"+fname;
		File file=new File(fname);
		if(!file.exists()){//如果文件夹不存在
			file.mkdir();//创建文件夹
		}
		for(int i=0;i<url.size();i++){
			try {
				download(url.get(i), fname+"\\"+i+".jpg");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void download(String urlString, String filename) throws Exception {
		System.out.println(Thread.currentThread().getName());
		System.out.println("------------------------正在下载图片-------------------------");
		System.out.println("图片url："+urlString);
		System.out.println("图片地址："+filename);
		URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
	   // URL url = new URL(urlString);
	    // 打开连接
	   // URLConnection con = url.openConnection();
	    // 输入流
	    InputStream is = con.getInputStream();
	    // 1K的数据缓冲
	    byte[] bs = new byte[1024];
	    // 读取到的数据长度
	    int len;
	    // 输出的文件流
	    
	    OutputStream os = new FileOutputStream(filename);
	    // 开始读取
	    while ((len = is.read(bs)) != -1) {
	      os.write(bs, 0, len);
	    }
	    // 完毕，关闭所有链接
	    os.close();
	    is.close();
	}   
	private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
	private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}
