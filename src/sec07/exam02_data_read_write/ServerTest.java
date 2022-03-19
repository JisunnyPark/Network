package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	/**
	 * 1. serverSocket ���� - ���� - bind
	 * 2. while(true) ���� �õ�/���� Ʋ - socket/serverSocket ���� Ȯ�� - ���� ȣ��Ʈ Ȯ�� - �ٽ� ���� �õ�(���� ����)
	 * 
	 * socket : ������ Ŭ���̾�Ʈ�� ����� �� �ֵ���, ���� ��ü ����
	 */
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {	
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			while(true) {
				System.out.println("���� : Ŭ���̾�Ʈ�� ���� ��ٸ�");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("���� : ���Ἲ�� - " + isa.getHostName());
				
				byte[] bytes = null;
				String message = null;
				
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readCount = is.read(bytes);
				message = new String(bytes, 0, readCount, "UTF-8");
				System.out.println("���� : Ŭ���̾�Ʈ�� ���� ���� �޼��� - " + message);
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
