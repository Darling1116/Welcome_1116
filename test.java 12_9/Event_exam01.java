package Test12_9;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Event_exam01 extends JFrame implements ItemListener{
	TextArea ta = new TextArea(6, 26);
	String[] city = {"北京","上海","海南","济南","广州"};
	JCheckBox cb[] = new JCheckBox[5];
	public Event_exam01() {
		setLayout(new FlowLayout());
		add(new JLabel("有城市："));
		add(ta);
		add(new JLabel("请选择你喜欢的城市："));
		for(int i=0;i<5;i++){
			cb[i] = new JCheckBox(city[i]);
			add(cb[i]);
			cb[i].addItemListener(this);
		}
		setBounds(300, 300, 400, 450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
public static void main(String[] args) {
	Event_exam01 exam = new Event_exam01();
}

@Override
public void itemStateChanged(ItemEvent e) {
	ta.append(e.getItem()+"\n");
}
}
