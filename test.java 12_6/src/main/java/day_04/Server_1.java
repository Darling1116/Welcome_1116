package day_04;
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
		InputStream is = client.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "iso-8859-1");
		BufferedReader br = new BufferedReader(isr);
		String str = "";
		while(!(str=br.readLine()).equals("")){
			System.out.println(str);
		}
		//发送
		 str="你好";
		byte[] b = str.getBytes("GBK");
		
		//byte[] data=str.getBytes("ISO-8859-1");
		OutputStream os=client.getOutputStream();
		//http协议默认的是iso-8859-1格式，但是http里面的正文默认是gbk格式
		os.write("HTTP/1.1 200 OK".getBytes("iso-8859-1"));
		os.write(13);
		os.write(10);
		os.write("Content-Type: text/html".getBytes("iso-8859-1"));
		os.write(13);
		os.write(10);
		os.write(("Content-Length: "+b.length).getBytes("iso-8859-1"));
		os.write(13);
		os.write(10);
		//os.write(("Content-Length: "+b.length").getBytes("iso-8859-1"));
		os.write("\r\n".getBytes("iso-8859-1"));
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
		new Server_1().start();
	}
	
}
