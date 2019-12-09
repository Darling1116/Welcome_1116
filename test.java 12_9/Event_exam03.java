package Test12_9;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Event_exam03 extends JFrame implements ItemListener,ActionListener {
	Choice c;
	JTextField tf;
	JButton b1;
	JButton b2;
	JTextArea ta;
	public Event_exam03() {
		c = new Choice();
		c.add("欢天喜地");
		c.add("天天向上");
		c.add("极速前进");
		c.add("完美日记");
		c.add("流星花园");
		c.setBounds(0, 0, 315, 30);
		
		tf = new JTextField(20);
		tf.setBounds(0, 32, 160, 30);
		
		b1 = new JButton("添加");
		b1.setBounds(180,32, 65, 30);
		b2 = new JButton("删除");
		b2.setBounds(250,32, 65, 30);
		
		ta = new JTextArea(6, 50);
		ta.setBounds(0, 66, 315, 120);
		
		c.addItemListener(this);
		tf.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(null);
		add(c);
		add(tf);
		add(b1);
		add(b2);
		add(ta);
		validate();
		setBounds(300, 300, 450, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	


@Override
public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
	String name = c.getSelectedItem();
	int index = c.getSelectedIndex();
	ta.setText("\n"+index+":"+name);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==b1 || e.getSource()==tf){
		String name = tf.getText();
		if(name.length()>0){
			c.addItem(name);
			ta.append("\n"+"列表添加："+name);
			
		}
	}
	else if(e.getSource()==b2){
		ta.append("\n"+"列表删除："+c.getSelectedItem());
		c.remove(c.getSelectedIndex());
	}
}

public static void main(String[] args) {
	Event_exam03 exam = new Event_exam03();
}
}
