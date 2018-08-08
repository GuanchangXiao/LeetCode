package zhengwu;

public class MyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="http://zwfw.cq.gov.cn/icity/govservice/project?type=gr";
		//MyUtil.getChildUrl(url);
		String url2="http://zwfw.cq.gov.cn/icity/govservice/deptitemlist?id=5000000110";
		MyUtil.getItem(url2);
	}

}
