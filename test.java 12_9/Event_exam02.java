package Test12_9;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class Event_exam02 extends JFrame implements ItemListener,ActionListener{
JComboBox cb;
JTextField tf;
JButton b1;
JButton b2;
JTextArea ta;
	
	public Event_exam02() {
		String[] str = {"天天向上","快乐大本营","极速前进","完美日记"};
		cb = new JComboBox();
		for(int i=0;i<str.length;i++){
		cb.addItem(str[i]);
		}
		cb.setBounds(0, 0, 315, 30);
		
		tf = new JTextField(20);
		tf.setBounds(0, 32, 160, 30);
		
		b1 = new JButton("添加");
		b1.setBounds(180,32, 65, 30);
		b2 = new JButton("删除");
		b2.setBounds(250,32, 65, 30);
		
		ta = new JTextArea(6, 50);
		ta.setBounds(0, 66, 315, 120);
		
		cb.addItemListener(this);
		tf.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(null);
		add(cb);
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
	String name = (String)cb.getSelectedItem();
	int index = cb.getSelectedIndex();
	ta.setText("\n"+index+":"+name);
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1 || e.getSource()==tf){
		String name = tf.getText();
		if(name.length()>0){
			cb.addItem(name);
			ta.append("\n"+"列表添加："+name);
			
		}
	}
	else if(e.getSource()==b2){
		ta.append("\n"+"列表删除："+cb.getSelectedItem());
		cb.remove(cb.getSelectedIndex());
	}
}

public static void main(String[] args) {
	Event_exam02 exam = new Event_exam02();
}
}
