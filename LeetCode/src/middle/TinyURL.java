package middle;

import java.util.HashMap;
import java.util.Map;
//
public class TinyURL {
	// Encodes a URL to a shortened URL.
	static Map<Integer, String> map = new HashMap<>();
    static int i=0;
    public static String encode(String longUrl) {
    	map.put(i,longUrl);
        return "http://tinyurl.com/"+i++;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
    	return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String longUrl ="https://leetcode.com/problems/design-tinyurl";
		String shortUrl = encode(longUrl);
		System.out.println(shortUrl);
		String re=decode(shortUrl);
		System.out.println(re);
	}

}
