package Test12_16;

import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;


class Sel extends Frame{
	String city[]={"北京","南京","西安","杭州","洛阳","开封"};
	Checkbox radio[] = new Checkbox[6];
	CheckboxGroup c=new CheckboxGroup();
	public Sel(String s)
	{ 
	setLayout(new FlowLayout());
	add(new Label("选择喜欢的城市: "));
	for(int i=0;i<6;i++){
	radio[i]=new Checkbox(city[i],c,false);
	add(radio[i]);
	}
	setBounds(100,100,300,300);
	setVisible(true);
	addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowListener e)
			{ 
				System.exit(0); 
			}
		} );
	}
	}


		public class JFrame_exam02
		{ 
			public static void main(String args[])
			{
				Sel win=new Sel("选择框");
			}
		}

