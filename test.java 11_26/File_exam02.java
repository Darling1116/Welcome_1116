package Test11_26;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File_exam02 {
public static void main(String[] args) throws IOException {
	String str = "白日依山尽\n";
	char[] arr = str.toCharArray();
	FileWriter fw = new FileWriter("登黄鹤楼.txt");
	try{
		fw.write(str);
		fw.write("黄河入海流\n");
		fw.write("欲穷千里目\n");
		fw.write("更上一层楼\n");
		fw.close();
	}
	catch(IOException e){
		System.out.println("流的创建、写和关闭都可能产生IOException异常");
		System.exit(-1);
	}
	
	try{
		FileReader fr = new FileReader("登黄鹤楼.txt");
		int i=0;
		while((i=fr.read()) != -1){
			System.out.print((char)i);
		}
		System.out.println();
		fr.close();
	}
	catch(FileNotFoundException e){
		System.out.println("文件未找到");
		System.exit(-2);
	}
	catch(IOException e){
		System.out.println("读和关闭都可能产生IOException");
		System.exit(-3);
	}
	
}
}
