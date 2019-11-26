package Test11_24;

import java.io.IOException;

public class File_exam03 {
public static void main(String[] args) {
	int count =0,i;
	boolean first = true;
	System.out.println("请输入： ");
	try{
		while((i=System.in.read()) != '\r'){
			if(first){
				System.out.println("接收到：");
				first = false;
			}
			count++;
			System.out.print((char)i);
		}
	}
	catch(IOException e){
		e.printStackTrace();
	}
	System.out.println("\n 共输入了"+count+"个字符");
}
}
