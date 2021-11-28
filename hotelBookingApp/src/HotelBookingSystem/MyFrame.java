package HotelBookingSystem;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame
{
    //todo:调整控件的格式
    //定义控件

    JLabel label = new JLabel("请输入1-7的数字，表示今天星期几：");
    public static JTextField textField = new JTextField(5);
    JButton button_ok = new JButton("ok");

    JLabel label2 = new JLabel("旅行代理机构：");
    public static JTextArea textArea_agency = new JTextArea(1, 10);

    JLabel label3 = new JLabel("缓冲池队首元素：");
    public static JTextArea textArea_buffer = new JTextArea(1, 20);

    JLabel label4 = new JLabel("酒店供应商：");
    public static JTextArea textArea_supplier = new JTextArea(3, 10);


    public MyFrame(String title)
    {
        super(title);

        // 内容面板 (ContentPane)
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        // 向内容面板里添加控件
        contentPane.add(label);
        contentPane.add(textField);
        contentPane.add(button_ok);

        contentPane.add(label2);
        contentPane.add(textArea_agency);

        contentPane.add(label3);
        contentPane.add(textArea_buffer);

        contentPane.add(label4);
        contentPane.add(textArea_supplier);
        textArea_supplier.setText("卡号为xxxx的用户您好！您在旅行机构x上总共预定x间房，房间单价为xxx.xx，总计xxx.xx元！");


        // 创建监听器对象并把监听器注册给按钮ok
        // 监听器中重写actionPerformed方法，里面就是按钮被点击时执行的操作
        button_ok.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //点击按钮后执行的操作

                //获取五个旅行代理实例，开启五个旅行代理的循环线程，会开始不断将订单送入缓冲区
                TravelAgency.getInstance(1).start();
                TravelAgency.getInstance(2).start();
                TravelAgency.getInstance(3).start();
                TravelAgency.getInstance(4).start();
                TravelAgency.getInstance(5).start();

                //获取酒店供应商实例，开启酒店供应商的循环线程，不断从缓冲区获取订单
                HotelSupplier.getInstance().start();

            }
        });


    }


}
