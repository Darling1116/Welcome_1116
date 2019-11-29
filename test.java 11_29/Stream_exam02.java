package Test11_29;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Stream_exam02 {
public static void main(String[] args) throws IOException {
	int i;
	InputStream is = null;
	InputStreamReader ir = null;
	try{
		is = new FileInputStream("登黄鹤楼.txt");
		ir = new InputStreamReader(is, "utf8");
		System.out.println("从文件读入的编码为："+ir.getEncoding());
		System.out.println("从文件读入的是：");
		while((i=ir.read()) != -1){
			System.out.print((char)i);
		}
	}
	catch(FileNotFoundException e){
		System.out.println("发生了FileNotFoundException异常。");
	}
	catch(UnsupportedEncodingException e){
		System.out.println("发生了UnsupportedEncodingException异常");
	}
	finally{
		is.close();
		ir.close();
	}
}
}
