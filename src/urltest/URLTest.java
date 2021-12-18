package urltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) {
		try {
			URL aURL = new URL("https://comic.naver.com/index");
			// http
			System.out.println("protocol name:" + aURL.getProtocol());
			// comic.naver.com
			System.out.println("host name:" + aURL.getHost());
			// /index
			System.out.println("file name:" + aURL.getFile());
			// null
			System.out.println("Query:" + aURL.getQuery()); 
			// /index
			System.out.println("Path:" + aURL.getPath());
			//생성자에서 포트번호가 기술되는 경우에 표시, 아니면 -1
			System.out.println("port name:" + aURL.getPort());
			//HTML 문서 내부의 위치를 지정하는 <a name="..."> 태그의 값을 구한다.
			//URL에서 '#'로 표시된 부분
			System.out.println("ref : " + aURL.getRef());
			BufferedReader br = new BufferedReader(new InputStreamReader(aURL.openStream()));
			String line;
			while((line = br.readLine()) != null) {
			System.out.println(line);
			}
		} catch(MalformedURLException e) {
			System.out.println("MalformedURLException : "+e);
		} catch(IOException e) {
			System.out.println("IOException :"+ e);
		}
	}
}