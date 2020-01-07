package client;
/*
 * 该类用来实现客户端接收服务器向客户端返回的数据
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class STCRunnable implements Runnable {
	private Socket socket;

	public STCRunnable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str=null;
			while (true) {
				str = br.readLine();
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
