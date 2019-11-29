package Test11_29;

import java.io.IOException;
import java.io.InputStreamReader;

public class Stream_exam01 {
public static void main(String[] args) {
	InputStreamReader in = new InputStreamReader(System.in);
	boolean first = true;
	int count = 0,i;
	System.out.println("请输入：");
	try{
		while((i=in.read())!='\r'){
			if(first){
				first = false;
				System.out.println("接收到：");
			}
			count++;
			System.out.print((char)i);
		}
		System.out.println();
	}
	catch(IOException e){
		e.printStackTrace();
	}
	System.out.println("一共输入了"+count+"个字符");
}
}
