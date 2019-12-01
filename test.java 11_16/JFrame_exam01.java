package Test11_16;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class JFrame_exam01  implements ItemListener{
	JCheckBox box;
	JLabel imageLabel;
	JFrame frame = new JFrame();
	public void Jframe_exam01() {
		box = new JCheckBox("是否显示图像");
		ImageIcon  image = new ImageIcon("./imgs/bg.jpg");
		imageLabel = new JLabel();
		imageLabel.setIcon(image);
		imageLabel.setVisible(false);
		frame.add(box, BorderLayout.NORTH);
		frame.add(imageLabel, BorderLayout.CENTER);
		
		frame.validate();
		box.addItemListener((ItemListener) this);
		
		frame.setBounds(300, 300, 450, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public void itemStateChanged(ItemEvent e) {
		JCheckBox box = (JCheckBox)e.getItemSelectable();
		if(box.isSelected()){
			imageLabel.setVisible(true);
		}
		else
			imageLabel.setVisible(false);
		
	}

public static void main(String[] args) {
	JFrame_exam01 test = new JFrame_exam01();
	test.Jframe_exam01();
}
}
