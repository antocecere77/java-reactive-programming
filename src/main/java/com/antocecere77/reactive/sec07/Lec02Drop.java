package com.antocecere77.reactive.sec07;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.Queues;

public class Lec02Drop {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");

        Flux.create(fluxSink -> {
            for (int i = 0; i < 501; i++) {
                fluxSink.next(i);
                System.out.println("Pushed: " + i);
                Util.sleepMillis(1);
            }
            fluxSink.complete();
        }).onBackpressureDrop()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                }).subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
