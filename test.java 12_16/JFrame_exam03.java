package Test12_16;


import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
 class MyWindow extends Frame implements  ItemListener {
Checkbox box1;
Checkbox box2;
TextField text;
	MyWindow(String s) {
		super(s);
		setBounds(100, 100, 400, 200);
		TextField text=new TextField(10);
		Checkbox box1=new Checkbox("台式机");
		Checkbox box2=new Checkbox("笔记本");
		setLayout(new GridLayout(2, 2));
		
		add(new Label("计算机产品介绍", Label.CENTER));
		add(box1);
		add(box2);
		add(text);
		box1.addItemListener(this);
		box2.addItemListener(this);
		setVisible(true); 
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);}
		});
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getItemSelectable() == box1){
			text. setText("厂商 1"); 
		}
		else if(e.getItemSelectable()== box2){
			text. setText("厂商 2"); }
		}


	}
 
public class JFrame_exam03 {
	public static void main(String args[])
	{
		new MyWindow("我的产品");
	}
}
