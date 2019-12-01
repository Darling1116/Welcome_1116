package Test11_19;

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
		m1 = new Menu("文件");
		MenuItem mi1_1 = new MenuItem("新建");
		MenuItem mi1_2 = new MenuItem("打开");
		MenuItem mi1_3 = new MenuItem("保存");
		m1.add(mi1_1);
		m1.add(mi1_2);
		m1.add(mi1_3);
		
		
		m2 = new Menu("编辑");
		MenuItem mi2_1 = new MenuItem("剪切");
		//MenuItem mi2_2 = new MenuItem("复制");
		MenuShortcut ms1 = new MenuShortcut(KeyEvent.VK_C);
		MenuItem mi2_2 = new MenuItem("复制", ms1);
		//MenuItem mi2_3 = new MenuItem("粘贴");
		MenuShortcut ms2 = new MenuShortcut(KeyEvent.VK_V);
		MenuItem mi2_3 = new MenuItem("粘贴", ms2);
		MenuItem mi2_4 = new MenuItem("删除");
		m2.add(mi2_1);
		m2.add(mi2_2);
		m2.add(mi2_3);
		m2.add(mi2_4);
		
		
		m3 = new Menu("格式");
		MenuItem mi3_1 = new CheckboxMenuItem("自动换行");
		MenuItem mi3_2 = new MenuItem("字体");
		m3.add(mi3_1);
		m3.add(mi3_2);
		
		
		m4 = new Menu("查看");
		MenuItem mi4_1 = new MenuItem("状态栏");
		m4.add(mi4_1);
		
		
		m5 = new Menu("帮助");
		m5.addSeparator();
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		setMenuBar(mb);
		
		Font font = new Font(Arial,Font.CENTER_BASELINE,16);
		mb.setFont(font);
		
		setBounds(300, 300, 450, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}



public class JFrame_exam01 {
	public static void main(String[] args) {
		Myframe frame = new Myframe("记事本窗体");		
		}
}
