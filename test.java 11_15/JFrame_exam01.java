package Test11_15;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JFrame_exam01 extends JFrame implements ActionListener{
	JFrame frame = new JFrame();
	JPanel pa1 = new JPanel(new GridLayout(3,1));
	JPanel pa2 = new JPanel();
	JTextField tf = new JTextField("one");
	JButton btn1 = new JButton("添加");
	JButton btn2 = new JButton("清空");
	JTextArea ta = new JTextArea("", 5, 5);
	public JFrame_exam01() {
		pa2.add(btn1);
		pa2.add(btn2);
		pa1.add(tf);
		pa1.add(pa2);
		pa1.add(ta);
		frame.add(pa1);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		frame.setTitle("TextDemo");
		frame.setBounds(300, 300, 300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		String str = tf.getText();
		if(e.getSource()==btn1){
			ta.append(str);
		}
		else if(e.getSource()==btn2){
			ta.setText(" ");
		}
	}
	
public static void main(String[] args) {
JFrame_exam01 test = new JFrame_exam01();
}
}
