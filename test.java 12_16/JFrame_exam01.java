package Test12_16;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JFrame_exam01 extends JFrame{
	
	public JFrame_exam01() {
		
		JTextArea ta = new JTextArea(10, 20);
		String[] listData = {"1","2","3","4","5","6","7"};
		JList l = new JList(listData);
		
		JPanel p = new JPanel();
		p.add(l);
		p.add(ta);
		add(p);
		setVisible(true);
		setBounds(300, 300, 20, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
public static void main(String[] args) {
	JFrame_exam01 frame = new JFrame_exam01();
}
}
