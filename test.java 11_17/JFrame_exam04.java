package Test11_17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrame_exam04 {
	private static final String Arial = null;
	JFrame frame = new JFrame("登录界面");
	 JLabel label = new JLabel("用户");
	 JLabel label2 = new JLabel("密码");
	 JLabel imaglabel = new JLabel();
	public JFrame_exam04() {
		// TODO Auto-generated constructor stub
		ImageIcon icon = new ImageIcon("./imgs/bg.jpg");
		imaglabel.setIcon(icon);
		imaglabel.setVisible(false);
		
		Font font = new Font(Arial,Font.CENTER_BASELINE,22);
		JTextField tf1 = new JTextField("小花");
		JTextField tf2 = new JTextField("123456");
		tf1.setColumns(8);
		tf2.setColumns(8);
		label.add(tf1);
		label2.add(tf2);
		label.setFont(font);
		label2.setFont(font);
		label.setBackground(Color.pink);
		label2.setBackground(Color.pink);
		Font font1 = new Font(Arial,Font.HANGING_BASELINE,16);
	    final JButton Button1 = new JButton("登录");
		final JButton Button2 = new JButton("退出");
		Button1.setFont(font1);
		Button2.setFont(font1);
		
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton button = (JButton)e.getSource();
				if(button==Button1){
					imaglabel.setVisible(true);
					label.setVisible(false);
					label2.setVisible(false);
				}
				if(button==Button2){
					imaglabel.setVisible(false);
					label.setVisible(true);
					label2.setVisible(true);
				}
			}
		};
		Button1.addActionListener(al);
		Button2.addActionListener(al);
		FlowLayout fl= new FlowLayout();
		fl.setAlignment(1);
		fl.setHgap(60);
		fl.setVgap(10);
		frame.setLayout(fl);
		frame.add(label);
		frame.add(tf1);
		frame.add(label2);
		frame.add(tf2);
		frame.add(Button1);
		frame.add(Button2);
		frame.add(imaglabel,BorderLayout.CENTER);
		//frame.setForeground(Color.pink);
		frame.setBounds(300, 300, 350, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
public static void main(String[] args) {
	JFrame_exam04 test = new JFrame_exam04();
}
}
