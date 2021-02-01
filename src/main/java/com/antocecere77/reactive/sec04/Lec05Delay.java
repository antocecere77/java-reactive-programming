package com.antocecere77.reactive.sec04;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class Lec05Delay {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.x", "9");

        Flux.range(1, 100)  // 32  Queues -> reactor.bufferSize
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
