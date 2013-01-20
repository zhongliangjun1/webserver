package com.dianping.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类说明
 * @author liangjun.zhong
 * @version 创建时间：Jan 21, 2013 1:39:01 AM
 */
public class ServerSocketTest {

	public static void testListen() throws InterruptedException{
		try {
			int port = 8080;
			int backlog = 1;
			InetAddress bindAddr = InetAddress.getByName("127.0.0.1");
			ServerSocket se = new ServerSocket(port, backlog, bindAddr);
			
			/**
			Socket socket = se.accept();
			//Thread.sleep(4*1000);
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream);
			out.println("Http/1.1 200 OK");
			out.println("Server: my test programing");
			out.println();
			*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testListen();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
