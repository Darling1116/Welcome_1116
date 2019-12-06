package Test11_19;
import java.awt.Checkbox;
import java.awt.CheckboxMenuItem;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

class Myframe extends JFrame{
	private static final String Arial = null;
	MenuBar mb;
	Menu m1;
	Menu m2;
	Menu m3;
	Menu m4;
	Menu m5;
	Myframe(String s) {
		setTitle(s);
		mb = new MenuBar();
		m1 = new Menu("�ļ�");
		MenuItem mi1_1 = new MenuItem("�½�");
		MenuItem mi1_2 = new MenuItem("��");
		MenuItem mi1_3 = new MenuItem("����");
		m1.add(mi1_1);
		m1.add(mi1_2);
		m1.add(mi1_3);
		
		m2 = new Menu("�༭");
		MenuItem mi2_1 = new MenuItem("����");
		//MenuItem mi2_2 = new MenuItem("����");
		MenuShortcut ms1 = new MenuShortcut(KeyEvent.VK_C);
		MenuItem mi2_2 = new MenuItem("����",ms1);
		
		//MenuItem mi2_3 = new MenuItem("ճ��");
		MenuShortcut ms2 = new MenuShortcut(KeyEvent.VK_V);
		MenuItem mi2_3 = new MenuItem("ճ��", ms2);
		
		MenuItem mi2_4 = new MenuItem("ɾ��");
		m2.add(mi2_1);
		m2.add(mi2_2);
		m2.add(mi2_3);
		m2.add(mi2_4);
		
		m3 = new Menu("��ʽ");
	    //MenuItem mi3_1 = new MenuItem("�Զ�����");
		MenuItem mi3_1 = new CheckboxMenuItem("�Զ�����");
		MenuItem mi3_2 = new MenuItem("����");
		m3.add(mi3_1);
		m3.add(mi3_2);
		
		m4 = new Menu("�鿴");
		MenuItem mi4_1 = new MenuItem("״̬��");
		m4.add(mi4_1);
		
		m5 = new Menu("����");
		m5.addSeparator();
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		//mb.setHelpMenu(m5);
		setMenuBar(mb);
		
		
		Font f1 = new Font(Arial,Font.CENTER_BASELINE,16);
		/*
		m1.setFont(f1);
		m2.setFont(f1);
		m3.setFont(f1);
		m4.setFont(f1);
		m5.setFont(f1);
		*/
		mb.setFont(f1);
		
		setBounds(300, 300, 450, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}


public class JFrame_exam01 {
	public static void main(String[] args) {
		Myframe frame = new Myframe("���±�����");		
		}
}
