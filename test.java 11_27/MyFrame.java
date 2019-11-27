package Test11_27;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	private static final String Arial = null;
	JFrame frame;
	JPanel panel;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	
	MyFrame(){
    frame = new JFrame("图书借阅");
/*	MenuBar mb = new MenuBar();
	Menu m = new Menu("读者借阅信息");
	mb.add(m);
	setMenuBar(mb);
*/	
	panel = new JPanel();
	panel.setLayout(new GridLayout(1,6,11,12));
	//panel.setBackground(Color.lightGray);
	Font font = new Font(Arial,Font.CENTER_BASELINE,18);
	JLabel la1 = new JLabel("读者编号:");
	JLabel la2 = new JLabel("读者姓名:");
	JLabel la3 = new JLabel("读者类别:");
	la1.setFont(font);
	la2.setFont(font);
	la3.setFont(font);
	TextField tf1 = new TextField(10);
	TextField tf2 = new TextField(10);
	TextField tf3 = new TextField(10);
	panel.add(la1);
	panel.add(tf1);
	panel.add(la2);
	panel.add(tf2);
	panel.add(la3);
	panel.add(tf3);
	
	panel2 = new JPanel();
	panel2.setLayout(new FlowLayout());
	JLabel label2 = new JLabel("读者借阅信息");
	panel2.add(label2);
	JTextArea ta = new JTextArea("",13,52);
	ta.setBackground(Color.LIGHT_GRAY);
	panel2.add(panel);
	panel2.add(ta);
	
	
	panel3 = new JPanel();
	panel3.setLayout(new GridLayout(5, 4, 40, 6));
	JLabel lab1 = new JLabel("ISBN:");
	JLabel lab2 = new JLabel("类别:");
	JLabel lab3 = new JLabel("书名:");
	JLabel lab4 = new JLabel("作者:");
	JLabel lab5 = new JLabel("出版社:");
	JLabel lab6 = new JLabel("出版日期:");
	JLabel lab7 = new JLabel("印刷次数:");
	JLabel lab8 = new JLabel("单价:");
	JLabel lab9 = new JLabel("当前日期:");
	JLabel lab10 = new JLabel("操作人员:");
	lab1.setFont(font);
	lab2.setFont(font);
	lab3.setFont(font);
	lab4.setFont(font);
	lab5.setFont(font);
	lab6.setFont(font);
	lab7.setFont(font);
	lab8.setFont(font);
	lab9.setFont(font);
	lab10.setFont(font);
	JTextField tfi1 = new JTextField(11);
	JTextField tfi2 = new JTextField(11);
	JTextField tfi3 = new JTextField(11);
	JTextField tfi4 = new JTextField(11);
	JTextField tfi5 = new JTextField(11);
	JTextField tfi6 = new JTextField(11);
	JTextField tfi7 = new JTextField(11);
	JTextField tfi8 = new JTextField(11);
	JTextField tfi9 = new JTextField("2019-11-27");
	JTextField tfi10 = new JTextField(11);
	panel3.add(lab1);
	panel3.add(tfi1);
	panel3.add(lab2);
	panel3.add(tfi2);
	panel3.add(lab3);
	panel3.add(tfi3);
	panel3.add(lab4);
	panel3.add(tfi4);
	panel3.add(lab5);
	panel3.add(tfi5);
	panel3.add(lab6);
	panel3.add(tfi6);
	panel3.add(lab7);
	panel3.add(tfi7);
	panel3.add(lab8);
	panel3.add(tfi8);
	panel3.add(lab9);
	panel3.add(tfi9);
	panel3.add(lab10);
	panel3.add(tfi10);
	
	panel4 = new JPanel();
	JLabel label4 = new JLabel("图书借阅",JLabel.LEFT);
	label4.setBounds(0, 0, 50, 20);
	panel4.add(label4,Label.LEFT);
	panel3.setBounds(0, 0, 620, 160);
	panel4.add(panel3);
	
	
	JButton b1 = new JButton("借阅");
	JButton b2 = new JButton("关闭");
	
	add(panel2);
	add(panel4);
	add(b1);
	add(b2);
	
	
	setLayout(null);
	panel2.setBounds(0, 0, 660, 200);
	panel4.setBounds(0, 210, 660, 180);
	b1.setBounds(250, 400, 60, 30);
	b2.setBounds(340, 400, 60, 30);
	setBounds(400, 400, 680, 500);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
public static void main(String[] args) {
	MyFrame f = new MyFrame();
}
}
