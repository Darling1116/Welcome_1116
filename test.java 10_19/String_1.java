package Test10_19;

import java.util.Arrays;

public class String_1 {

		public static void main(String args[]){
			int[] arr = new int[]{12,23,65,2,9};
			System.out.println("arr[2]="+arr[2]+" length="+arr.length);
	        for(int e : arr){
	        	System.out.print(e+" ");
	        }
			
			int[] a={1,2,3};
			int[] b={1,2,3};
			int[] c = a;
			if(a==b){
				System.out.println("xiangdeng");
			}
			else{
				System.out.println("buxiangdeng");
			}
			System.out.println("a==b "+a.equals(b));
			System.out.println("a==c "+a.equals(c));
		    
			int[][] array1 = new int[2][3];
			array1[0][0] = 1;
			System.out.println("数组的列数为："+array1[0].length);
			System.out.println("数组的行数为："+array1.length);
			
			int[][] array2 = {{1,2,3},{4,5,6},{7,8,9}};
			for(int i=0;i<array2.length;i++){
				for(int j=0;j<array2[0].length;j++){
					System.out.print(array2[i][j]+" ");
				}
				System.out.println();
			}
			int[][] array3 = {{1,2,3},{4,5,6},{7,8,9}};
			System.out.println("array2==array3 "+Arrays.deepEquals(array2, array3));
			
			int arr1[] = {1,2,3,4,5,6,7,8,9};
			int arr2[] = new int [9];
			System.arraycopy(arr1, 1, arr2, 3, 5);
			for(int i=0;i<arr1.length;i++){
				System.out.print(arr1[i]);
			}
			System.out.println();
			for(int i=0;i<arr2.length;i++){
				System.out.print(arr2[i]);
			}
			System.out.println();
			
			Arrays.sort(arr2);
			for(int e:arr2){
				System.out.print(e);
			}
			System.out.println();
			
			int pos = Arrays.binarySearch(arr2, 6);
			System.out.print(pos);
		}
}
