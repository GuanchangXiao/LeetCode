import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int page=5;
		String[] plist={"http://thz4.com/forum-42-","http://thz4.com/forum-56-","http://thz4.com/forum-57-","http://thz4.com/forum-221-","http://thz4.com/forum-239-"};
		List<MyThread> threads = new ArrayList<>();
		//�����̳߳�
		for(int i=0;i<plist.length;i++){
			MyThread temp = new MyThread(plist[i],page);
			threads.add(temp);
		}
		//���̲߳���
		for(MyThread myThread : threads) {
			myThread.start();
		}
		//Utils.getHtml();
	}
}
