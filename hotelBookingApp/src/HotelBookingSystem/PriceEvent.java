package HotelBookingSystem;

import java.util.EventListener;
import java.util.EventObject;


public class PriceEvent extends EventObject {

    private static final long serialVersionUID = 6496098798146410884L;

    private String PriceState = ""; // 表示价格状态，有"rise"和"fall"两种

    public PriceEvent(Object source, String priceState) { // source为事件源
        super(source);
        PriceState = priceState;
    }

    public String getPriceState() {
        return PriceState;
    }

    public void setPriceState(String priceState) {
        PriceState = priceState;
    }
}
