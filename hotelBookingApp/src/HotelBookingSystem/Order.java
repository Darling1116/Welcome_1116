package HotelBookingSystem;

public class Order {

    private int senderId;
    private int cardNum; //有效卡号：5000-7000
    private int amount;
    private int day;

    public Order() {
    }

    public Order(int senderId, int cardNum, int amount, int day) {
        this.senderId = senderId;
        this.cardNum = cardNum;
        this.amount = amount;
        this.day = day;
    }


    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    @Override
    public String toString() {
        return  "senderId=" + senderId +
                ", cardNum=" + cardNum +
                ", amount=" + amount +
                ", day=" + day;
    }

    /**
     * 将Order类转化为String
     * @param order
     * @return
     */
    public static String encoder (Order order) {
        return order.toString();
    }

    /**
     * 将String转化为Order类
     * @param str
     * @return
     */
    public static Order decoder (String str) {
        String [] temp = str.split(",");
        int senderId_ = Integer.parseInt(temp[0].split("=")[1]);
        int cardNum_ = Integer.parseInt(temp[1].split("=")[1]);
        int amount_ = Integer.parseInt(temp[2].split("=")[1]);
        int day_ = Integer.parseInt(temp[3].split("=")[1]);
        return new Order(senderId_, cardNum_, amount_, day_);
    }


}


