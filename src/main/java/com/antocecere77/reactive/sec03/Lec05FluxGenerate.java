package com.antocecere77.reactive.sec03;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            System.out.println("emitting");
            synchronousSink.next(Util.faker().country().name());   //Only 1 item
            //synchronousSink.next(Util.faker().country().name()); //Thow exception More than one call to onNext
            //synchronousSink.complete();  // With this return only one item
            //synchronousSink.error(new RuntimeException("oops"));
        })
        .take(2) // Without complete method above returns two items
        .subscribe(Util.subscriber());
    }
}
