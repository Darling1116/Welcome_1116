package Test11_24;

import java.io.File;
import java.io.IOException;

public class File_exam01 {
public static void main(String[] args) throws IOException {
	File f1 = new File("Circle.java");
	System.out.println("绝对路径"+f1.getAbsolutePath());
	System.out.println("相对路径"+f1.getPath());
	System.out.println("文件的唯一标识"+f1.getCanonicalPath());
}
}
