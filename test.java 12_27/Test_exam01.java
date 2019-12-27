package Test12_27;

public class Test_exam01 {
public static void main(String[] args) {
/*	int i=1,j=1,k=1,m=0;
	for(i=1;i<=4;i++){
		for(j=1;j<=4;j++){
			for(k=1;k<=4;k++){
				if(i!=j && i!=k && j!=k){
					System.out.print(100*i+10*j+k+" ");
					m++;
				}
				if(m%5==0){
					System.out.println();
				}
			}
		}
	}
	*/
	
	for(int i=1;i<=9;i++){
		for(int j=1;j<=i;j++){
			System.out.print(i+"*"+j+"="+i*j);
			if(i*j<10){
				System.out.print(" ");
			}
			System.out.print(" ");
		}
		System.out.println();
	}
	
}
}
