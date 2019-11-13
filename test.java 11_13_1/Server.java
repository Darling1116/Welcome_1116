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
		System.out.println("tomcat����");
		System.out.println("������0.01s");
	}
	catch(IOException e){
		e.printStackTrace();
	}
}
	
public void start(){
	try{
		Socket client=ser.accept();
		InputStream is=client.getInputStream();
		InputStreamReader isr=new InputStreamReader(is, "ISO-8859-1");//hppt��Ĭ�ϱ��뷽ʽ
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
	System.out.println("���������гɹ����˿ں�Ϊ8080");
	System.out.println("�ȴ��ͻ�������");
	
	Socket socket = server.accept();
	System.out.println("�ͻ������ӳɹ�");
	InputStream is = socket.getInputStream();//��Ŵ����������������
	BufferedReader br = new BufferedReader(new InputStreamReader(is));
	System.out.println("�����ǿͻ��˷���������Ϣ��");
	for(; ;){
	br.readLine();
	}
	
	*/

}
}
