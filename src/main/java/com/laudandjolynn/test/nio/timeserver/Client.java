package com.laudandjolynn.test.nio.timeserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */

public class Client {
	public Client() {
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Thread t = new T("client"+(i+1));
			t.start();
			t.join();
		}
	}

	private static class T extends Thread {
		private String name = null;
		public T(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			System.out.println("client name: "+name);
			Socket client = null;
			DataOutputStream out = null;
			DataInputStream in = null;
			try {
				client = new Socket("localhost", 5100);
				client.setSoTimeout(10000);
				out = new DataOutputStream((client.getOutputStream()));

				String query = "GB";
				byte[] request = query.getBytes();
				out.write(request);
				out.flush();
				client.shutdownOutput();

				in = new DataInputStream(client.getInputStream());
				byte[] reply = new byte[40];
				in.read(reply);
				System.out.println("Time: " + new String(reply, "GBK"));

				in.close();
				out.close();
				client.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
