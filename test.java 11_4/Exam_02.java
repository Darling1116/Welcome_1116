package Test11_4;

import javax.swing.*;

public class Exam_02 extends JFrame{
JDialog dialog;

Exam_02(String s, int x, int y, int w, int h){
	super(s);
	setBounds(x,y,w,h);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	dialog = new JDialog();
	dialog.setBounds(250, 250, 400, 200);
	dialog.setTitle("欢迎来到第一个对话框");
	dialog.setVisible(true);
	dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
}
	
	
public static void main(String[] args) {
	Exam_02 frame = new Exam_02("窗口",250,50,400,200);
}
}
