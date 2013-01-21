package com.dianping.socket;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
	
	private static final int BUFFER_SIZE = 1024;

	public static void testListen() throws InterruptedException{
		try {
			int port = 8080;
			int backlog = 1;
			InetAddress bindAddr = InetAddress.getByName("127.0.0.1");
			ServerSocket se = new ServerSocket(port, backlog, bindAddr);
			
			while(true){
				Socket socket = se.accept();
				//Thread.sleep(4*1000);
				InputStream inputStream = socket.getInputStream();	
				//String s = inputStream2StringNew(inputStream);
				//System.out.println("get:"+s);
				System.out.println("----------------------------------");
				OutputStream outputStream = socket.getOutputStream();
				File file = new File("/Users/mac/Downloads/ImageLocation/222413_2013-01-18-18-34-08_large_yEQh_61040000469b1190.jpg");
				if(file.exists()){
					FileInputStream fis = new FileInputStream(file);
					byte[] bytes = new byte[BUFFER_SIZE];
			        int ch = fis.read(bytes, 0, BUFFER_SIZE);
			        while (ch!=-1) {
			        	outputStream.write(bytes, 0, ch);
			            ch = fis.read(bytes, 0, BUFFER_SIZE);
			        }
				}
			}
			
			
			/**
			OutputStream outputStream = socket.getOutputStream();			
			//Request request = new Request(inputStream, outputStream);
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
	
	public static String inputStream2StringNew(InputStream in) throws IOException {
	    StringBuffer out = new StringBuffer();
	    byte[] b = new byte[4096];
	    for (int n; (n = in.read(b)) != -1;) {
	        out.append(new String(b, 0, n));
	    }
	    return out.toString();
	}
	
	public static String inputStream2String(InputStream is) throws IOException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i=-1;
		while((i=is.read())!=-1){
		  baos.write(i);
		}
		return baos.toString();
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
