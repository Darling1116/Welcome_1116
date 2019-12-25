package Test12_25;

public class Test_exam01 {
public static void main(String[] args) {
/*	int x=0;
	while(x <= 100/3){
		int y=0;
		while(y <=100/2){
			int z = 100-x-y;
			if(z%2==0 && x*3+y*2+z/2==100){
				System.out.println("大马的数量为"+x+" 中马的数量为"+y+" 小马的数量为"+z);
			}
			++y;
		}
		++x;
	}
	*/
	
	
	for(int x=1;x<100;x++){
		for(int y=1;y<100;y++){
			int z=100-x-y;
			if(z%2==0 && x*3+y*2+z/2==100){
				System.out.println("大马的数量为"+x+" 中马的数量为"+y+" 小马的数量为"+z);				
			}
		}
	}
}
}
