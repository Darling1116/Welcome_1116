package Test11_4;

import javax.swing.*;

class myframe extends JFrame{
	myframe(String s, int x, int y, int w ,int h){
		super(s);
		setBounds(x,y,w,h);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class Exam_01 {
public static void main(String[] args) {
	myframe frame = new myframe("A Simple GUI",200,200,400,200);
	/*
	JFrame frame = new JFrame("A Simple GUI");
	frame.setBounds(200, 200, 400, 200);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	*/
}
}
