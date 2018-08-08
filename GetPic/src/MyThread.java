
public class MyThread extends Thread{
	private String url;
	private int page;
	public MyThread(String s,int page){
		url=s;
		this.page=page;
	}
	public void run() {
		Utils.getHtml(url, page);
    }  
}
