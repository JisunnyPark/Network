package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTest {
	/**
	 * Socket 선언 - 생성(서버와 연결 요청) - 연결
	 */
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("클라이언트 : 서버와 연결 요청");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("클라이언트 : 서버와 연결 성공");
			
			byte[] bytes = null;
			String message = null;
			
			OutputStream os = socket.getOutputStream();
			message = "클라이언트 : 안녕 서버야";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("클라이언트 : 메세지 보내기 성공");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
