package HotelBookingSystem;

import java.util.Random;

/**
 * 每个旅行社都是从类中的相同类(或相同方法)实例化的一个线程。
 * 旅行社的行动是事件驱动的。每个旅行社都包含一个回调方法(事件处理程序)，供酒店供应商在降价事件发生时调用。
 * 例如，旅行社会根据需求以及之前的价格和当前价格之间的差额来计算要预订的房间数量。
 * 此线程将在HotelSupplier线程终止后终止。每个订单都是一个OrderClass对象。对象被发送到编码器进行编码。
 * 已编码的字符串被发送回旅行社。然后，旅行社将以字符串格式将订单发送到MultiCellBuffer。
 * 在将订单发送到MultiCellBuffer之前，必须保存一个时间戳。当收到订单完成确认后，将计算并保存订单时间(或打印)。
 * 您可以在实现中设置N = 5。(10分)
 */


public class TravelAgency implements Runnable{

    //私有化构造器
    private TravelAgency () {}

    //内部创建类的对象
    private static TravelAgency agencyRunnable = new TravelAgency();

    //内部创建五个旅行机构线程
    private static Thread instance1 = new Thread(agencyRunnable);
    private static Thread instance2 = new Thread(agencyRunnable);
    private static Thread instance3 = new Thread(agencyRunnable);
    private static Thread instance4 = new Thread(agencyRunnable);
    private static Thread instance5 = new Thread(agencyRunnable);

    //设置旅行机构线程名
    static {
        instance1.setName("旅行机构:1");
        instance2.setName("旅行机构:2");
        instance3.setName("旅行机构:3");
        instance4.setName("旅行机构:4");
        instance5.setName("旅行机构:5");
    }

    //提供公共的方法，返回类的对象
    public static Thread getInstance(int num) {
        switch (num) {
            case 1 :
                return instance1;
            case 2 :
                return instance2;
            case 3 :
                return instance3;
            case 4 :
                return instance4;
            case 5 :
                return instance5;
            default:
                return instance1;
        }
    }

    /**
     * 随机产生新订单，并将订单送给缓冲区，该线程在主线程中被调用
     */
    @Override
    public void run () {
        MultiCellBuffer multiCellBuffer = MultiCellBuffer.getInstance();

        while (true) {

            //每个TravelAgency刷新一个订单的时间
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (MultiCellBuffer.getInstance()) {
                if (!multiCellBuffer.isFull()) {
                    Random random = new Random();

                    //响应降价事件
                    PriceListener listener = new PriceListener();
                    listener.priceChangePerformed(HotelSupplier.getRunnable().event);

                    //随机生成一个新订单，day不随机，其余随机
                    String senderIdString = Thread.currentThread().getName().split(":")[1];
                    int senderId = Integer.parseInt(senderIdString);
                    int cardNum = random.nextInt(2000) + 5000;
                    int amount = random.nextInt(3) + 1;
                    String dayString = MyFrame.textField.getText();
                    int day = Integer.parseInt(dayString);

                    Order order = new Order(senderId, cardNum, amount, day);

                    //将订单编码成字符串
                    String str = Order.encoder(order);

                    //将订单送入缓冲区
                    multiCellBuffer.setOneCell(str);

                    //显示缓冲区信息
                    MyFrame.textArea_buffer.setText(MultiCellBuffer.getInstance().readCells());

                }
            }
        }
    }



}
