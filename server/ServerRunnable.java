package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;

public class ServerRunnable implements Runnable {
	private Socket socket;

	public ServerRunnable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		while (true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw;
				String user = socket.getInetAddress() + ":" + socket.getPort() + "的用户";
				String message = null;
				String exit = null;
				String user_message = null;
				try {
					message = br.readLine();
				} catch (SocketException e) {
					exit = user + "退出";
					socket.close();
					SingleServer.list.remove(socket);
					System.out.println(exit);
				}
				user_message = user + ":" + message;
				for (Socket socket : SingleServer.list) {
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					if (exit != null) {
						bw.write(exit);
					} else {
						bw.write(user_message);
					}
					bw.newLine();
					bw.flush();
				}
				if (exit != null) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
