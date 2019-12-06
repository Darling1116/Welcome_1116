package day_03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.MalformedInputException;

public class Server_1 {
	ServerSocket ser;
		
	public Server_1(){
		try{
			ser=new ServerSocket(8080);
			System.out.println("tomcat已经启动");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}		
	
	public void start(){
	try{
		Socket client=ser.accept();
		//发送
		String str="welcome google";
		byte[] data=str.getBytes("ISO-8859-1");
		OutputStream os=client.getOutputStream();
		
		os.write("HTTP/1.1 200 OK".getBytes("iso-8859-1"));
		os.write(13);
		os.write(10);
		os.write("Content-Type: text/html".getBytes("iso-8859-1"));
		os.write(13);
		os.write(10);
		os.write(("Content-Length: "+str.length()).getBytes("iso-8859-1"));
		os.write(13);
		os.write(10);
		os.write("".getBytes("iso-8859-1"));
		os.write(13);
		os.write(10);
		os.write(data);
		os.flush();
		os.close();
	}
	catch(IOException e){
		e.printStackTrace();
	}
	}

	public static void main(String[] args) {
		new Server_1().start();
	}
	
}
