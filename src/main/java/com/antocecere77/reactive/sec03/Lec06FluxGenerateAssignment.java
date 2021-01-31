package com.antocecere77.reactive.sec03;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxGenerateAssignment {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);

        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("emitting " + country);
            synchronousSink.next(country);
            atomicInteger.incrementAndGet();
            if(country.equalsIgnoreCase("canada")) {
                synchronousSink.complete();
            }
        })
        .subscribe(Util.subscriber());
    }
}
