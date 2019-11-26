package Test11_26;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_exam01 {
public static void main(String[] args) throws IOException {
	int i=0;
/*	File myDir = new File("myDir");
	if(!myDir.exists()){
		myDir.mkdir();
	}
	File myFile = new File(myDir,"my.txt");
*/	
	try{
		FileOutputStream fot = new FileOutputStream("my.txt");
		System.out.println("请输入(以#号结束)");
		while((i=System.in.read())!='#'){
			fot.write(i);
		}
		fot.close();
	}
	catch(FileNotFoundException e){
		System.out.println("文件未找到");
		System.exit(-1);
	}
	catch(IOException e){
		System.out.println("IO异常");
		System.exit(-2);
	}
	
	FileInputStream fin = null;
	try{
		fin = new FileInputStream("my.txt");
		while((i=fin.read())!=-1){
			System.out.println((char)i);
		}
	}
		catch(FileNotFoundException e){
			System.out.println("文件未找到");
			System.exit(-1);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("用法：java ShowFile 文件名");
		}
		catch(IOException e){
			System.out.println("读取数据时发生IOException异常");
		}
		finally{
			fin.close();
		}
		
	
}
}
