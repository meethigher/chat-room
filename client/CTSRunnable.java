package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
 * 用来实现客户端向服务器发送信息
 */
public class CTSRunnable implements Runnable {
	private Socket socket;

	public CTSRunnable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			boolean isOnline = true;
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String message=null;
			while (isOnline) {
				message = input.readLine();
				bw.write(message);
				bw.newLine();
				bw.flush();
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
