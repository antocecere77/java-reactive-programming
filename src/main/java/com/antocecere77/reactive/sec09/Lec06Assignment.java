package com.antocecere77.reactive.sec09;

import com.antocecere77.reactive.courseutil.Util;
import com.antocecere77.reactive.sec09.assignment.OrderProcessor;
import com.antocecere77.reactive.sec09.assignment.OrderService;
import com.antocecere77.reactive.sec09.assignment.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Lec06Assignment {

    public static void main(String[] args) {

        Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = Map.of(
                "Kids", OrderProcessor.kidsProcessing(),
                "Automotive", OrderProcessor.automotiveProcessing()
        );

        Set<String> set = map.keySet();

        OrderService.orderStream()
                .filter(p -> set.contains(p.getCategory()))
                .groupBy(PurchaseOrder::getCategory) // 2 keys
                .flatMap(gf -> map.get(gf.key()).apply(gf)) //flux
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
