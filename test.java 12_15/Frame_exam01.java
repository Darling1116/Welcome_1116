package Test12_15;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public  class Frame_exam01 extends Frame {
	
	
	public Frame_exam01() {
		MenuBar mb = new MenuBar();
		
		Menu m1 = new Menu("文件");
		MenuItem m1_1 = new MenuItem("新建");
		MenuItem m1_2 = new MenuItem("打开");
		MenuItem m1_3 = new MenuItem("保存");
		m1.add(m1_1);
		m1.add(m1_2);
		m1.add(m1_3);
		Menu m2 = new Menu("编辑");
		MenuItem m2_1 = new MenuItem("粘贴");
		MenuItem m2_2 = new MenuItem("查看");
		m2.add(m2_1);
		m2.add(m2_2);
		Menu m3 = new Menu("格式");
		Menu m4 = new Menu("查看");
		Menu m5 = new Menu("帮助");
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		setMenuBar(mb);
		setVisible(true);
		setBounds(300, 300, 450, 500);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
public static void main(String[] args) {
	Frame_exam01 frame = new Frame_exam01();
}


}
