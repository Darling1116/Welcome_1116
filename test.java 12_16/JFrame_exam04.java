package Test12_16;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrame_exam04 extends Frame implements ActionListener {
	public  JFrame_exam04() {
	
		Button btn = new Button("Exit");
		setLayout(new FlowLayout());
		add(btn);
		btn.addActionListener(this);
		setSize(400,300);
		setVisible(true);
	}
	
public static void main(String[] args) {
		JFrame_exam04 fr =  new JFrame_exam04();
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
		System.exit(0);
}
}
