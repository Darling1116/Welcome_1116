package Test12_4;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;


class Event1 extends JFrame implements ActionListener{
	JTextField tf1,tf2,tf3;
	public Event1() {
		 tf1 = new JTextField(12);
		 tf2 = new JTextField(12);
		 tf3 = new JTextField(12);
		setLayout(new GridLayout(3, 1));
		add(tf1);
		add(tf2);
		add(tf3);
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		setBounds(300, 300, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tf1){
			String word = tf1.getText();
			if(word.equals("天空")){
				tf3.setText("sky");
			}
			else if(word.equals("海洋")){
				tf3.setText("ocean");
			}
			else if(word.equals("太阳")){
				tf3.setText("sun");
			}
			else{
				tf3.setText("没有匹配的单词");
			}
		}
		else if(e.getSource() == tf2){
			String word = tf2.getText();
			if(word.equals("sky")){
				tf3.setText("天空");
			}
			else if(word.equals("oncen")){
				tf3.setText("海洋");
			}
			else if(word.equals("sun")){
				tf3.setText("太阳");
			}
			else{
				tf3.setText("没有匹配的单词");
			}
		}
	}
}
public class Event_exam01 {
public static void main(String[] args) {
	Event1 e1 = new Event1();
}


}
