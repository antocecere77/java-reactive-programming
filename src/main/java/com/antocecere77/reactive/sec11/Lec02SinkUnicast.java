package com.antocecere77.reactive.sec11;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec02SinkUnicast {

    public static void main(String[] args) {

        //Handle through wich we would push items
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        // handle through subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Util.subscriber("sam"));

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");
        sink.tryEmitNext("?");
    }
}
