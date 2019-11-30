package Test11_9;

class myException extends Exception{
	
}
class CCircle{
	private double radius;
	public void setRadius(double r) throws myException{
		if(r<0) throw new myException();
		else
			radius = r;
	}
	public void show(){
		System.out.println("area="+3.14*radius*radius);
	}
}
public class My_Exception {
public static void main(String[] args) {
	CCircle cir = new CCircle();
	try{
		cir.setRadius(-2.0);
	}
	catch(myException e){
		System.out.println(e+" 被抛出");	
	}
	cir.show();
	
}
}
