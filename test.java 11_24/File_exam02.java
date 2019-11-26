package Test11_24;

import java.io.File;
import java.io.IOException;

public class File_exam02 {
public static void main(String[] args) throws IOException{
	File mydir1 = new File("d://mydir1");
	System.out.println(mydir1.getAbsolutePath());
	if(!mydir1.exists()){
		mydir1.mkdir();
	}
	System.out.println(mydir1.getAbsolutePath());
	
	File mydir2 = new File(mydir1,"mydir2");
	System.out.println(mydir2.getAbsolutePath());
	if(!mydir2.exists()){
		mydir2.mkdir();
	}

	File file1 = new File(mydir2,"my.txt");
	System.out.println(file1.getAbsolutePath());
	if(!file1.exists()){
		file1.createNewFile();
	}
	
	listDir(mydir1);
}
	
	private static void listDir(File dir) {
	File[] listF = dir.listFiles();
	String info = "目录: "+dir.getName()+"{";
	
	for(int i=0;i<listF.length;i++){
		info += listF[i].getName()+" ";
	}
	
	info += "}";
	System.out.println(info);
	
	for(int i=0;i<listF.length;i++){
		File f = listF[i];
		if(f.isFile()){
			printFileInfo(f);
		}
		else{
			listDir(f);
		}
	}
	}
	
	private static void printFileInfo(File f){
		System.out.println("文件名字: "+f.getName());
		System.out.println("绝对路径: "+f.getAbsolutePath());
		System.out.println("父路径: "+f.getParent());
		System.out.println("文件可读: "+f.canRead());
		System.out.println("文件长度: "+f.length()+"字节");
		
	}
	 
}

