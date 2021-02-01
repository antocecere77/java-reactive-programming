package com.antocecere77.reactive.sec04;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {

    public static void main(String[] args) {

        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }

    public static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }

    public static Flux<Integer> fallback() {
        return Flux.range(20, 5);
    }
}
