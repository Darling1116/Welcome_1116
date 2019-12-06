package day_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_2 {
	ServerSocket ser;
	private FileInputStream fis;
	
	public Server_2(){
		try{
			ser=new ServerSocket(8080);
			System.out.println("tomcat11ÒÑ¾­Æô¶¯");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}		
	
	public void start(){
	try{
		Socket client=ser.accept();
		
		File file=new File("./file/index_01.html");
		fis = new FileInputStream(file);
		byte[] b = new byte[(int)file.length()];
		fis.read(b);
		
		
		OutputStream os=client.getOutputStream();
		
		os.write("HTTP/1.1 200 OK".getBytes("iso-8859-1"));
		os.write(13);
		os.write(10);
		os.write("Content-Type: text/html".getBytes("iso-8859-1"));
		os.write(13);
		os.write(10);
		os.write(("Content-Length: "+file.length()).getBytes("iso-8859-1"));
		os.write(13);
		os.write(10);
		os.write("".getBytes("iso-8859-1"));
		os.write(13);
		os.write(10);
		os.write(b);
		os.flush();
		os.close();
	}
	catch(IOException e){
		e.printStackTrace();
	}
	}

	public static void main(String[] args) {
		new Server_2().start();
	}
}
