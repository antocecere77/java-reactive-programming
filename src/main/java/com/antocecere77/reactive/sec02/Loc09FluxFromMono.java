package com.antocecere77.reactive.sec02;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Loc09FluxFromMono {

    public static void main(String[] args) {

        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);

        flux.subscribe(Util.onNext());

        Flux.range(1,10)
                .filter(i -> i > 3)
                .next()  //1
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }

    private static void doSomething(Flux<String> flux) {

    }
}
