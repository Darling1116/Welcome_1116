package Test11_5;

import java.util.Arrays;

public class Exam_04 {
public static void main(String[] args) {
    int[] i = new int[25];
    int[] j = new int[25];
    Arrays.fill(i, 47);
    Arrays.fill(j, 99);   
    System.arraycopy(i, 0, j, 0, i.length);
    
    int[] k = new int[10];
    Arrays.fill(k, 103);
    System.arraycopy(i, 0, k, 0, k.length);
    Arrays.fill(k, 103);
    System.arraycopy(k, 0, i, 0, k.length);
    
    System.out.println("i数组的长度是"+i.length+"    j数组的长度是"+j.length+"    k数组的长度是"+k.length);
    for(int m=1;m<=25;m++)
    	System.out.println(" i[" +m+"]="+i[m-1]);
    for(int m=1;m<=25;m++)
    	System.out.println(" j[" +m+"]="+j[m-1]);
    for(int m=1;m<=10;m++)
    	System.out.println(" k[" +m+"]="+k[m-1]);

}
}
