package Test11_17;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFrame_exam03 {
private static final String Arial = null;

public static void main(String[] args) {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField tf = new JTextField("文本");
	JButton bt = new JButton("按钮");
	Font font = new Font(Arial,Font.CENTER_BASELINE,14);
	tf.setBackground(Color.gray);
	tf.setFont(font);
	tf.setBounds(400, 400, 50, 50);
	bt.setBackground(Color.orange);
	bt.setFont(font);
	bt.setBounds(300, 300, 20, 20);
	panel.add(bt);
	panel.setLayout(null);
	frame.add(panel);
	frame.add(bt);
	frame.add(tf);
	frame.setBounds(300, 300, 300, 450);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
}
