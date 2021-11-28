package HotelBookingSystem;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUIMain
{
    private static void createGUI()
    {
        //创建框架，具体的框架控件细节封装到MyFrame中
        MyFrame frame = new MyFrame("酒店预订系统");
        //设置退出事件
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置尺寸
        frame.setSize(600, 300);
        //显示窗口
        frame.setVisible(true);
    }



    public static void main(String[] args)
    {

        //开启线程，调用createGUI()
        //Swing中事件处理和绘画代码都在一个单独的线程中执行，这个线程就叫做事件分发线程。
        //这就确保了事件处理器都能串行的执行，并且绘画过程不会被事件打断。
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });

    }


}