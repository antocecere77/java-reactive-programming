package com.antocecere77.reactive.sec11;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec04SinkMulti {

    public static void main(String[] args) {

        //Handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();

        // handle through which subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");

        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));
        sink.tryEmitNext("?");

        flux.subscribe(Util.subscriber("mike"));
        sink.tryEmitNext("new msg");
    }
}
