package HotelBookingSystem;

import java.util.EventListener;

public class PriceListener implements EventListener {

    /**
     * 价格变化事件发生时调用的方法（actionPerformed）
     * @param event
     */
    public void priceChangePerformed(PriceEvent event) {

        String str_travel_agency = "";

        if (event.getPriceState() != null && event.getPriceState().equals("rise")) {
            str_travel_agency = "酒店价格有所上涨！";
        } else if (event.getPriceState() != null && event.getPriceState().equals("fall")) {
            str_travel_agency = "酒店价格有所下跌！";
        } else {
            //todo:抛一个异常
        }

        //显示信息
        MyFrame.textArea_agency.setText(str_travel_agency);

    }
}