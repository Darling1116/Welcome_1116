package entity;

public class Emp {

	private int id;
	private String name;
	private String gender;
	private String phone;
	private String empNo;
	private int deptNo;
	private int age;
	
	public Emp(){
		
	}
	
	public Emp(int id, String name, String gender, String phone, String empNo, int deptNo, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.empNo = empNo;
		this.deptNo = deptNo;
		this.age = age;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", empNo=" + empNo
				+ ", deptNo=" + deptNo + ", age=" + age + "]";
	}
	
	
	
}
