package com.antocecere77.reactive.sec11;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinkOne {

    public static void main(String[] args) {

        //Mono 1 value / empty / error
        Sinks.One<Object> sink = Sinks.one();
        //sink.tryEmitValue();
        //sink.tryEmitEmpty();
        //sink.tryEmitError();

        Mono<Object> mono = sink.asMono();
        mono.subscribe(Util.subscriber("sam"));

        sink.tryEmitValue("hi");
    }
}
