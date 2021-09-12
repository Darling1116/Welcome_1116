package Test9_11;

public class example_1 {
//	//欧几里得法
//	static int max_child(int m, int n){
//		int r = 0;
//		while(n!=0){
//			r = m%n;
//			m = n;
//			n = r;
//		}
//		return m;
//	}
	
//	//连续整数检测法
	static int max_child(int m, int n){
		int t = Math.min(m, n);
		while(t != 0){
			while(m%t != 0){
				t = t-1;
			}
			if(n%t == 0){
				return t;
			}
			else{
			t = t-1;
			}
		}
		return t;
	}
		
	public static void main(String[] args){
		int res = max_child(21,28);
		System.out.print(res);
		
	}
	
}
