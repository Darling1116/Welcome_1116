package Test10_30;
public class Exam_03 {
	public static void main(String[] args) {
		String t = new String("wearefamilly");
		String b = new String("wearefamilly");
		String j = new String("wearefamilly");
		char[] arr1 = new char[10];
		t.getChars(0, 5, arr1, 0);
		System.out.println(arr1);
		
		char[] arr2 = t.toCharArray();
		System.out.println(arr2);
		
		System.out.println(t.equals(b));
		System.out.println(t.equals(j));
		
		System.out.println(t.indexOf('e', 3));
		String[] s1 = t.split("a");
		for(int i=0;i<s1.length;i++){
			System.out.println(s1[i]+' ');
		}
		
		char[] arr = {'1','2','3','4','5','6','7','8'};
		String s2 = new String(arr,0,6);
		System.out.println(s2);
		
		String str = new String("哈哈");
		byte[] b1 = str.getBytes();
		System.out.println("哈哈的长度为 "+b1.length);
		String str0 = new String(b1,0,3);
		System.out.println(str0);
		
		int num = 123456;
		String binaryString = Long.toBinaryString(num);
		System.out.println(binaryString);
		System.out.println(Long.toString(num, 16));
		
		String ss = "c:\\myfile";
		System.out.println(ss.length());
//判断一个字符串中出现几个en:
		  int number=0; 
	       String s="student;entropy;engage,english,client";
	       for(int k=0;k<s.length();k++)
	        {  if(s.regionMatches(k,"en",0,2))
	             {  number++;
	             }
	         } 
	       System.out.println("number="+number);

	       
	   	String a = "Hello";
		String c = a.substring(0, 2);
		System.out.println(c);
		
		System.out.println("abc"=="abc");
		
		int m = Short.parseShort("567");
		
		

	}
}
