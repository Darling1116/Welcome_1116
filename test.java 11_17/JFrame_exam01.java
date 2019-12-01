package Test11_17;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JFrame_exam01 {
	JFrame frame = new JFrame("Test Buttons");
	JRadioButton radio1 = new JRadioButton("Radio Button1:");
	JRadioButton radio2 = new JRadioButton("Radio Button2:");
	JRadioButton radio3 = new JRadioButton("Radio Button3:");
	JLabel label = new JLabel("请选择单选按钮：");
	public JFrame_exam01() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		ButtonGroup group = new ButtonGroup();
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton radio = (JRadioButton)e.getSource();
				if(radio==radio1){
				label.setText("You selected Radio Button1");
				}
				else if(radio==radio2){
					label.setText("You selected Radio Button2");
				}
				else{
					label.setText("You selected Radio Button3");
				}
			}
		};
		radio1.addActionListener(al);
		radio2.addActionListener(al);
		radio3.addActionListener(al);
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		frame.add(radio1);
		frame.add(radio2);
		frame.add(radio3);
		frame.add(label);
		frame.setBounds(300, 300, 400, 200);
		frame.setVisible(true);
	}
	
public static void main(String[] args) {
JFrame_exam01 test = new JFrame_exam01();
}
}
