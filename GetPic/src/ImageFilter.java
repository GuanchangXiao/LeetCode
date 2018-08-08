import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.DMatch;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.FeatureDetector;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageFilter {
	public static boolean imgFilter(String basePath,String destPath){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat src_base = Imgcodecs.imread(basePath);
		Mat src_test = Imgcodecs.imread(destPath);
		Mat gray_base = new Mat();
		Mat gray_test = new Mat();
		// ת��Ϊ�Ҷ�
		Imgproc.cvtColor(src_base, gray_base, Imgproc.COLOR_RGB2GRAY);
		Imgproc.cvtColor(src_test, gray_test, Imgproc.COLOR_RGB2GRAY);
		// ��ʼ��ORB���������
		FeatureDetector featureDetector = FeatureDetector.create(FeatureDetector.ORB);//�ر���ʾ������opencv��ʱ��֧��SIFT��SURF��ⷽ�������������opencv(windows) java���һ��bug,���������ﱻ���˺þá�
		DescriptorExtractor descriptorExtractor = DescriptorExtractor.create(DescriptorExtractor.ORB);
		// �ؼ��㼰����������������
		MatOfKeyPoint keyPoint1 = new MatOfKeyPoint(), keyPoint2 = new MatOfKeyPoint();
		Mat descriptorMat1 = new Mat(), descriptorMat2 = new Mat();
		// ����ORB�����ؼ���
		featureDetector.detect(gray_base, keyPoint1);
		featureDetector.detect(gray_test, keyPoint2);
		// ����ORB������������
		descriptorExtractor.compute(gray_base, keyPoint1, descriptorMat1);
		descriptorExtractor.compute(gray_test, keyPoint2, descriptorMat2);
		float result = 0;
		// ������ƥ��
		System.out.println("test5��" + keyPoint1.size());
		System.out.println("test3��" + keyPoint2.size());
		if (!keyPoint1.size().empty() && !keyPoint2.size().empty()) {
			// FlannBasedMatcher matcher = new FlannBasedMatcher();
			DescriptorMatcher matcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE_L1);
			MatOfDMatch matches = new MatOfDMatch();
			matcher.match(descriptorMat1, descriptorMat2, matches);
			// ����ƥ���ж�
			double minDist = 100;
			DMatch[] dMatchs = matches.toArray();
			int num = 0;
			for (int i = 0; i < dMatchs.length; i++) {
				if (dMatchs[i].distance <= 2 * minDist) {
					result += dMatchs[i].distance * dMatchs[i].distance;
					num++;
				}
			}
			// ƥ��ȼ���
			result /= num;
		}
		Float rs = new Float(result);
		return rs.isNaN();

	}
	public static void main(String[] args){
		System.out.println(imgFilter("D:\\catch\\11.jpg","D:\\catch\\5.jpg"));
	}
}
