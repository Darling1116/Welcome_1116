package test;
import java.util.ArrayList;

import dao.EmpDao;
import entity.Emp;
public class Test {
public static void main(String[] args) {
	EmpDao dao = new EmpDao();
	ArrayList<Emp> list = dao.selectAll(0,5);
	System.out.println(list);
}
}
