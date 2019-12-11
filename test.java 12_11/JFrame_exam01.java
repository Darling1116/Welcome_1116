package Test12_11;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class JFrame_exam01 extends Frame implements WindowListener{
	
		public JFrame_exam01() {
			setTitle("通过WindowListener接口实现关闭窗口");
			setVisible(true);
			setBounds(300, 300, 400, 450);
			addWindowListener(this);
		}
	public static void main(String[] args) {
		JFrame_exam01 f = new JFrame_exam01();
	}

	public void windowActivated(WindowEvent arg0) {
		
	}

	public void windowClosed(WindowEvent arg0) {
	
	}

	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	public void windowDeactivated(WindowEvent arg0) {
		
	}

	public void windowDeiconified(WindowEvent arg0) {
		
	}

	public void windowIconified(WindowEvent arg0) {
		
	}

	public void windowOpened(WindowEvent arg0) {
		
	}
	
}