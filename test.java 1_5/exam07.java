package Test1_5;

public class exam07 {
public static void main(String[] args) {
	int count=0;
	for(int i=1;i<=4;i++){
		for(int j=1;j<=4;j++){
			for(int z=1;z<=4;z++){
				if(i!=j && j!=z && z!=i){
					System.out.print(100*i+10*j+z+" ");
					count++;
					if(count%5==0)
						System.out.println();
				}
			}
		}
	}
	System.out.println("count="+count);
}
}
