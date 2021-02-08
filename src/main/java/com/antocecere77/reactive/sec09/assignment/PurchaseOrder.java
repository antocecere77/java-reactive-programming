package com.antocecere77.reactive.sec09.assignment;

import com.antocecere77.reactive.courseutil.Util;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private double price;
    private String category;

    public PurchaseOrder() {
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price().replaceAll(",", "."));
        this.category = Util.faker().commerce().department();
    }
}
