package Test1_5;

public class exam06 {
public static void main(String[] args) {
	int x = 0;
	while(x<100/5){
		int y = 0;
		while(y<=100/3){
			int z = 100-x-y;
			if(z%3==0 && 5*x+3*y+z/3==100){
				System.out.println("x="+x+" y="+y+" z="+z);				
			}
			y++;
		}
		x++;
	}
	
	int m=2;
	System.out.println(m++/3);
}
}
