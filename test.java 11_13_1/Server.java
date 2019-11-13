package tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	ServerSocket ser;
	
public Server(){
	try{
		ser=new ServerSocket(8080);
		System.out.println("tomcat启动");
		System.out.println("消耗了0.01s");
	}
	catch(IOException e){
		e.printStackTrace();
	}
}
	
public void start(){
	try{
		Socket client=ser.accept();
		InputStream is=client.getInputStream();
		InputStreamReader isr=new InputStreamReader(is, "ISO-8859-1");//hppt的默认编码方式
		BufferedReader br=new BufferedReader(isr);
		String str="";
		while(!(str=br.readLine()).equals("")){
			System.out.println(str);
		}
	}
	catch(UnsupportedOperationException e){
		e.printStackTrace();
	}
	catch(IOException e){
		e.printStackTrace();
	}
}
	
	
	
	
	
public static void main(String[] args) throws IOException{
	new Server().start();
	/*
	ServerSocket server = new ServerSocket(8080);
	System.out.println("服务器运行成功，端口号为8080");
	System.out.println("等待客户端连接");
	
	Socket socket = server.accept();
	System.out.println("客户端连接成功");
	InputStream is = socket.getInputStream();//存放从浏览器传来的数据
	BufferedReader br = new BufferedReader(new InputStreamReader(is));
	System.out.println("以下是客户端发过来的信息：");
	for(; ;){
	br.readLine();
	}
	
	*/

}
}
