package Test11_27;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class JFrame_Counter extends JFrame{

private static final String Arial = null;

public static void main(String[] args) {
    JFrame f = new JFrame("计算器");
    Font font = new Font(Arial,Font.CENTER_BASELINE,26);
    
    JLabel la = new JLabel("0.",JLabel.RIGHT);
    la.setFont(font);
    la.setForeground(Color.orange);
    la.setBackground(Color.lightGray);
 
	JPanel pa2 = new JPanel(new GridLayout(4, 4));
	String[] keys = {"1","2","3","*","4","5","6","+",
			"7","8","9","-","/","0",".","="};
	for(int i=0;i<16;i++){
		Button b = new Button(keys[i]);
		b.setFont(font);
		pa2.add(b);
	}
	
	f.add(la);
	f.add(pa2);
	
	f.setLayout(null);
	la.setBounds(0, 0, 400, 60);
	pa2.setBounds(0, 60, 400, 360);
	f.setBounds(300, 300, 418, 460);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
