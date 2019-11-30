package Test11_7;

import java.util.Scanner;

class Student{
	String id;
	String name;
	int eng;
	int math;
	int comp;
	int sum;
	
	Student(String id, String name, int eng, int math, int comp){
		this.id=id;
		this.name=name;
		this.eng=eng;
		this.math=math;
		this.comp=comp;
	}
	public Student(Student s) {
		this.id=s.id;
		this.name=s.name;
		this.eng=s.eng;
		this.math=s.math;
		this.comp=s.comp;
	}
	String getid(){
		return id;
	}
	String getname(){
		return name;
	}
	int geteng(){
		return eng;
	}
	int getmath(){
		return math;
	}
	int getcomp(){
		return comp;
	}
	int getsum(){
		return eng+math+comp;
	}
	int getavge(){
		return (eng+math+comp)/3;
	}
	void setid(int id){
		this.eng=id;
	}
	void setname(String name){
		this.name=name;
	}
	void seteng(int eng){
		this.eng=eng;
	}
	void setmath(int math){
		this.math=math;
	}
	void setcomp(int comp){
		this.comp=comp;
	}
	public String toString(){
		return getid()+" "+getname()+" "+geteng()+" "
				+getmath()+" "+getcomp()+" "+getsum()+" "+getavge();
	}
	public boolean equals(Object x){
		if(this.getClass()!=x.getClass())
			return false;
		Student A = (Student)x;
		return (this.getid().equals(A.getid()));	
	}
	public int compare(Student A){
		if(this.getsum()>A.getsum())
			return 1;
		else if(this.getsum()==A.getsum())
			return 0;
		else
			return -1;
	}

}
	
class StudentClass{
	String name;
	static int capacity=30;
	Student[] students;
	int size;
	
	StudentClass(String name,int size) {
		this.name=name;
		this.size=size;
		students =new Student[capacity];
	}
	String getname(){
		return name;
	}
	int getcapacity(){
		return capacity;
	}
	int getsize(){
		return size;
	}
	Student[] getstudents(){
		return students;
	}
	void setname(String name){
		this.name=name;
	}
	void setsize(int size){
		this.size=size;
	}
	void setcapacity(int capacity){
		this.capacity=capacity;
	}
	
	void setstudents(Student[] students){
		for(int i=0;i<size;i++){
			this.students[i]=new Student(students[i]);
		}
	}
	 public String toString(){
		 String s;
		 s=""+name+"专业"+"\n"+"容量:"+capacity+"\t"+"实际人数:"+size+"\n";
		 s=s+"学号"+"\t"+"姓名"+"\t"+"英语"+"\t"+"数学"+"\t"+"计算机"+"\t"+"总成绩"+"平均成绩"+"\n";
		 for(int i=0;i<size;i++){
			 s=s+students[i].id+"\t"+students[i].name+"\t"+students[i].eng+"\t"
			 	+students[i].math+"\t"+students[i].comp+"\t"+students[i].getsum()
			 	+"\t"+students[i].getavge()+"\n";
		 }
		 return s;
	 }
	 int find(String id){
		 for(int i=0;i<size;i++){
			 if(students[i].getid().equals(id));
			 return i;
		 }
		return -1;
		 }
	 
	boolean add(Student s){
		if(size==capacity) 
			return false;
		if(this.find(s.getid())>0)
			return false;
		else
		{
		this.students[size] = new Student(s.getid(),s.getname(),s.geteng(),
		s.getmath(),s.getcomp());
		size++;
		return true;
		}	
	}
	
	boolean del(Student s){
		int pos=find(s.getid());
		if(pos==-1)
			return false;
		else{
			for(int i=pos+1;i<size;i++){
				students[i-1] = students[i];
			}
			size--;
			return true;
		}
	}
	void selectionSort(){
		Student temp;
		for(int i=0;i<size-1;i++){
			for(int j=i+1;j<size;j++){
				if (students[j].compare(students[i])>0){
				    temp = students[i];
				    students[i] = students[j];
				    students[j] = temp;
				}
			}
		}
	}

}
class Stu_Class{
	public static void main(String[] args)throws NullPointerException {
		
		StudentClass sc = new StudentClass("信管",2);
		Student[] students = new Student[2];
		
		students[0]=new Student("12","花花",67,78,56);
		students[1]=new Student("13","亮亮",56,78,68);
	//	students[2]=new Student("15","丽丽",90,73,89);
		//students[3]=new Student("16","乃乃",77,78,93);
		//students[4]=new Student("19","西西",89,81,99);
		
		/*for(int i=0;i<sc.size;i++){
		System.out.println("请分别输入第"+i+"个同学的以下信息:");
		System.out.println("学号"+"\t"+"姓名"+"\t"+"英语"+"\t"+
				"数学"+"\t"+"计算机"+"\n");	
		Scanner s1 = new Scanner(System.in);
		String id = s1.next();
		Scanner s2 = new Scanner(System.in);
		String name = s2.next();
		Scanner s3 = new Scanner(System.in);
		int eng = Integer.parseInt(s3.next());
		Scanner s4 = new Scanner(System.in);
		int math = Integer.parseInt(s4.next());
		Scanner s5 = new Scanner(System.in);
		int comp = Integer.parseInt(s5.next());
		students[i]=new Student(id,name,eng,math,comp);
		}*/
		sc.setstudents(students);
		System.out.println(sc);
		System.out.println(sc.find("13"));
		Student s1 = new Student("19","西西",89,81,99);
		sc.add(s1);
		Student s2 = new Student("23","拉拉",89,81,99);
		sc.add(s2);
		sc.del(s1);
		sc.selectionSort();
		System.out.println(sc);
		
	}
}


