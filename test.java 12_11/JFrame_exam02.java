package Test12_11;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JFrame_exam02 extends Frame{
public JFrame_exam02() {
	setTitle("通过适配器实现接口的关闭");
	setBounds(300, 300, 450, 400);
	setVisible(true);
	addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent arg0) {
			System.exit(0);
		}
	});

}
public static void main(String[] args) {
	JFrame_exam02 frame = new JFrame_exam02();
}
}
