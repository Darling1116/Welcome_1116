package Test1_5;

public class exam02 {
public static void main(String[] args) {
	int j=10;
	System.out.println("j is:"+j);
	calculate(j);
	System.out.println("At last,j is:"+j);
}
static void calculate(int j){
	for(int i=0;i<10;i++)
		j++;
	System.out.println("j in claculate() is:"+j);
}
}
