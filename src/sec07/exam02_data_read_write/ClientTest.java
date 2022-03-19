package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTest {
	/**
	 * Socket ���� - ����(������ ���� ��û) - ����
	 */
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("Ŭ���̾�Ʈ : ������ ���� ��û");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("Ŭ���̾�Ʈ : ������ ���� ����");
			
			byte[] bytes = null;
			String message = null;
			
			OutputStream os = socket.getOutputStream();
			message = "Ŭ���̾�Ʈ : �ȳ� ������";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ŭ���̾�Ʈ : �޼��� ������ ����");
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
