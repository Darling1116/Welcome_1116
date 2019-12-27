package Test12_27;

public class Test_exam02 {
public static void main(String[] args) {
	/*int i=1,sum=0;
	while(i<=100){
		sum +=sum+i;
		if(sum>100){
			System.out.println(sum);
			break;
		}
		else{
			i++;
		}
	}
	*/
	
	int i=0,sum=0;
	while(sum<=100){
		sum += i;
		i += 2;
		if(sum>100){
			System.out.println(sum);
		}
	}
	
	

}
}
