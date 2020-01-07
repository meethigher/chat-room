package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SingleServer {
	public static ArrayList<Socket> list=new ArrayList<Socket>();
	public static void main(String[] args) throws IOException {
		ServerSocket server=null;
		try {
			server=new ServerSocket(8000);
			while(true) {
				Socket socket=server.accept();
				System.out.println("����֪ͨ>>"+socket.getInetAddress()+":"+socket.getPort()+"���û�����");
				list.add(socket);
				new Thread(new ServerRunnable(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
			server.close();
			System.out.println("����˹ر�");
		}
	}
}
