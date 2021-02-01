package com.antocecere77.reactive.sec04;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {

    public static void main(String[] args) {

        Flux.range(1, 1000)
                .log()
                .limitRate(100, 99)  // default 75%
                .subscribe(Util.subscriber());
    }
}
