package urltest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLConnetionTest {
	public static void main(String[] args) throws Exception {
		URL ojc = new URL("https://comic.naver.com/index");
		URLConnection con = ojc.openConnection();
		
		// text/html; charset=utf-8
		System.out.println(con.getContentType());
		
		//전체 헤더정보 읽어 오기
		Map<String, List<String>> header = con.getHeaderFields();
		System.out.println("--------------------------------------");
		for (Map.Entry<String, List<String>> mp : header.entrySet())
		{
		System.out.print(mp.getKey() + " : ");
		System.out.println(mp.getValue().toString());
		}
		System.out.println("--------------------------------------");

		BufferedReader in = new BufferedReader(new InputStreamReader(
			con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
			in.close();
	}

}
