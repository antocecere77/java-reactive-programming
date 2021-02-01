package com.antocecere77.reactive.sec04;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08DefaultIfEmpty {

    public static void main(String[] args) {

        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribe(Util.subscriber());
    }

    public static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }
}
