package Test12_17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.StringTokenizer;



 class Counter extends Frame {
 TextField tf;
 Panel pan1;
 Button jb0,jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,bot,add,sub,mul,div,equ;
	public Counter() {
		setTitle("计算器");
		TextField  tf = new TextField(40);   
	    add(tf,BorderLayout.NORTH);
	    
	    Button  jb0=new Button("0");
	    Button  jb1=new Button("1");
	    Button  jb2=new Button("2");
	    Button  jb3=new Button("3");
	    Button  jb4=new Button("4");
	    Button  jb5=new Button("5");
	    Button  jb6=new Button("6");
	    Button  jb7=new Button("7");
	    Button  jb8=new Button("8");
	    Button  jb9=new Button("9");
	    Button  bot=new Button(".");
	    Button  add=new Button("+");
	    Button  sub=new Button("-");
	    Button  mul=new Button("*");
	    Button  div=new Button("/");
	    Button  equ=new Button("=");
	    
	    Panel pan1=new Panel();
	    pan1.setLayout(new GridLayout(4,4));
	    pan1.add(jb7);
	    pan1.add(jb8);
	    pan1.add(jb9);
	    pan1.add(div);
	    pan1.add(jb4);
	    pan1.add(jb5);
	    pan1.add(jb6);
	    pan1.add(mul);
	    pan1.add(jb1);
	    pan1.add(jb2);
	    pan1.add(jb3);
	    pan1.add(sub);
	    pan1.add(bot);
	    pan1.add(jb0);
	    pan1.add(equ);
	    pan1.add(add);
	    
	    add(pan1);
	    MyEvent();
	    setBounds(400, 200, 500, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() { 
	            public void windowClosing(WindowEvent e){ 
	             System.exit(0);}});   
	}

	private void MyEvent() {
		Text(jb0);
		Text(jb1);
		Text(jb2);
		Text(jb3);
		Text(jb4);
		Text(jb5);
		Text(jb6);
		Text(jb7);
		Text(jb8);
		Text(jb9);
		Text(add);
		Text(sub);
		Text(mul);
		Text(div);
		Text(bot);
		
		equ.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tf.setText(tf.getText()+equ.getToolkit());
			if(tf.getText().contains("+")){
				StringTokenizer st1=new StringTokenizer(tf.getText(),"+");
				double d1,d2=0;
				d1=Double.parseDouble(st1.nextToken());
				while(st1.hasMoreTokens()){
					StringTokenizer st2=new StringTokenizer(st1.nextToken(),"=");
					d2=Double.parseDouble(st2.nextToken());
				}
				tf.setText(tf.getText()+" "+(d1+d2));
			}
		}
	});
}

	private void Text(final Button b) {
		b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Toolkit str=b.getToolkit();
			tf.setText(tf.getText()+str);	
			}
		});
	}
}
public class JFrame_counter{
	public static void main(String[] args) {
		JFrame_counter frame = new JFrame_counter();
	}
}
