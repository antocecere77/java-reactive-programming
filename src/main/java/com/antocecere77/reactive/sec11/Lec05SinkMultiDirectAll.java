package com.antocecere77.reactive.sec11;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;
import java.util.Queue;

public class Lec05SinkMultiDirectAll {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");

        //Handle through which we would push items
        //Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();
        Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();

        // handle through which subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Util.subscriber("sam"));
        flux.delayElements(Duration.ofMillis(200)).subscribe(Util.subscriber("mike"));

        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }

        Util.sleepSeconds(10);
    }
}
