package Test1_5;

public class exam08 {
public static void main(String[] args) {
	int elements[] = {1,2,3,4};
	int hold[] = {4,3,2,1,4,3,2,1};
	System.arraycopy(elements, 0, hold, 0,elements.length-2);
	for(int i=0;i<hold.length;i++){
		System.out.print(hold[i]+" ");
	}
}
}
