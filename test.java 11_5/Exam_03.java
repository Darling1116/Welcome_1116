package Test11_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Exam_03 {
public static void main(String[] args) {
	int[] arr = new int[8];
	Arrays.fill(arr,1);
	for(int i=0;i<8;i++){
		System.out.print(arr[i]+" ");
	}
	
	int[] arr1 = new int[8];
	Arrays.fill(arr1, 1);
	System.out.println(arr.equals(arr1));
	
	int[] arr2 = {1,1};
	int[] arr3;
	arr3 = arr2;
	System.out.println(Arrays.equals(arr1,arr));
	
	int[] arr4 = {4,6,1,2,1,3};
	Arrays.sort(arr4);
	for(int i=0;i<arr4.length;i++){
		System.out.print(arr4[i]+" ");
	}
	System.out.println();
	System.out.println(Arrays.binarySearch(arr4, 6));
	
    int[] a1 = new int[10];    
	int[] a2 = new int[10];
    Arrays.fill(a1, 47);    
	Arrays.fill(a2, 47);
	System.out.println(Arrays.equals(a1, a2));
	a2[3] = 11;
	System.out.println(Arrays.equals(a1, a2)); 
	
    String[] s1 = new String[5];
	Arrays.fill(s1, "Hi");
	String[] s2 = {"Hi", "Hi", "Hi", "Hi", "Hi"};
	System.out.println(Arrays.equals(s1, s2));
	
	ArrayList al = new ArrayList(Arrays.asList(s1));
	System.out.println(al);
		

	
}
}
