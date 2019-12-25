package Test12_25;

public class Test_exam02 {
public static void main(String[] args) {
	int i=1,j=1,k=1,m=0;
	for(i=1;i<=4;i++){
		for(j=1;j<=4;j++){
			for(k=1;k<=4;k++){
				if(i!=j && j!=k && i!=k){
					m += 1;
					System.out.print(100*i+10*j+k+" ");
					if(m%5==0){
						System.out.println();
					}
					
				}
			}
		}
	}
	System.out.println("这样的三位数共有"+m+"个");
}
}
