package Test11_17;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFrame_exam02 {
public static void main(String[] args) {
	Object[] obj = {"Read","Basketball","Football","Computer"};
	//String s = (String)JOptionPane.showInputDialog(null,"请选择你的爱好：\n","爱好", JOptionPane.PLAIN_MESSAGE,null,obj,"Basketball");
	JComboBox cbox = new JComboBox(obj);
	JFrame frame = new JFrame("下拉列表：");
	frame.add(cbox);
	frame.setBounds(300, 300, 200, 100);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
}
