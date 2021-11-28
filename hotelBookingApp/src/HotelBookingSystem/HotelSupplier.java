package HotelBookingSystem;

import java.util.Random;


public class HotelSupplier implements Runnable{

    //私有化构造器
    private HotelSupplier() {}

    //内部创建类的对象
    private static HotelSupplier supplierRunnable = new HotelSupplier();

    //内部创建酒店供应商线程
    private static Thread instance = new Thread(supplierRunnable);

    //提供公共的方法，返回supplierRunnable
    public static HotelSupplier getRunnable() {
        return supplierRunnable;
    }

    //提供公共的方法，返回instance
    public static Thread getInstance() {
        return instance;
    }

    public static double previous_price = 0;
    public PriceEvent event = new PriceEvent(this, "rise");

    /**
     * 价格模型方法：一个星期的每一天有一个基准数，再加上一个随机数
     * TODO:还可以根据给定时间段内收到的订单和同一时间段内酒店供应商的可用客房数量来确定价格
     */
    public double pricingModel(int day) {
        Random random = new Random();
        double price = 0;
        switch (day) {
            case 1:
                price = 140 + random.nextInt(20);
                break;
            case 2:
                price = 120 + random.nextInt(20);
                break;
            case 3:
                price = 120 + random.nextInt(20);
                break;
            case 4:
                price = 120 + random.nextInt(20);
                break;
            case 5:
                price = 180 + random.nextInt(20);
                break;
            case 6:
                price = 180 + random.nextInt(20);
                break;
            case 7:
                price = 160 + random.nextInt(20);
                break;
            default:
                break;
        }
        if (price < previous_price) {
            //发出一个降价事件
            event.setPriceState("rise");
        } else if (price > previous_price) {
            //发出一个涨价事件
            event.setPriceState("fall");
        }
        return price;
    }

    /**
     * 从缓冲中获取订单，该线程在主线程中被调用
     */

    @Override
    public void run() {
        MultiCellBuffer multiCellBuffer = MultiCellBuffer.getInstance();

        while (true) {
            synchronized (MultiCellBuffer.getInstance()) {
                if (!multiCellBuffer.isEmpty()) {

                    //从缓冲区获取字符串
                    String str = multiCellBuffer.getOneCell();

                    //将字符串解码成订单
                    Order order = Order.decoder(str);

                    //将拿到的订单送入处理线程
                    orderProcessing(order);
                }

            }

        }

    }


    /**
     * 订单处理：每当需要处理订单时，就会从这个类(或方法)实例化一个新线程来处理订单
     * 它将检查信用卡号码的有效性。定义您的信用卡格式：两个给定数字之间的数字(5000到7000之间)
     * 每个OrderProcessing线程将计算总费用：单价 * 房间数
     */
    public void orderProcessing(Order order) {
        //开启一个线程来处理订单
        new Thread(new Runnable() {
            @Override
            public void run() {

                int amount = order.getAmount();
                int cardNum = order.getCardNum();
                int senderId = order.getSenderId();
                int day = order.getDay();

                double price = pricingModel(day);
                previous_price = price; //保存最新的价格，以供比较
                double sum = amount * price;
                //校验卡号
                if (cardNum >= 5000 && cardNum < 7000) {
                    System.out.println("卡号" + cardNum + "校验成功！\n");
                } else {
                    System.out.println("卡号校验失败！\n");
                }

                //显示信息
                String str_hotel_supplier = "卡号为" + cardNum + "的用户您好！" + "您在旅行机构" + senderId
                        + "上总共预定" + amount + "间房" + "，房间单价为" + price
                        + "，总计" + sum + "元！\n";

                MyFrame.textArea_supplier.setText(str_hotel_supplier);
                System.out.println(str_hotel_supplier);

            }
        }).start();

    }

}

