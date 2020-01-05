package Test1_5;

public class exam05 {
public static void main(String[] args) {
	for(int i=0;i<100;i++){
		for(int j=0;j<100;j++){
			int z = 100-i-j;
			if(z%3==0 && 5*i+3*j+z/3==100){
				System.out.println("i="+i+" j="+j+" z="+z);
			}
		}
	}
	System.out.println();
	for(int i=0;i<100;i++){
		for(int j=0;j<100;j++){
			int z = 100-i-j;
			if(z%2==0 && 3*i+2*j+z/2==100){
				System.out.println("i="+i+" j="+j+" z="+z);				
			}
		}
	}
	
	
}
}
