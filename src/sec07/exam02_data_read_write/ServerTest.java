package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	/**
	 * 1. serverSocket 선언 - 생성 - bind
	 * 2. while(true) 연결 시도/수락 틀 - socket/serverSocket 연결 확인 - 연결 호스트 확인 - 다시 연결 시도(무한 루프)
	 * 
	 * socket : 서버와 클라이언트가 통신할 수 있도록, 연결 매체 느낌
	 */
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {	
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			while(true) {
				System.out.println("서버 : 클라이언트와 연결 기다림");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("서버 : 연결성공 - " + isa.getHostName());
				
				byte[] bytes = null;
				String message = null;
				
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readCount = is.read(bytes);
				message = new String(bytes, 0, readCount, "UTF-8");
				System.out.println("서버 : 클라이언트로 부터 받은 메세지 - " + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
