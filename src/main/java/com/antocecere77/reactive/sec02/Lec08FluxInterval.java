package com.antocecere77.reactive.sec02;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {

    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))
            .subscribe(Util.onNext());

        Util.sleepSeconds(5);
    }
}
