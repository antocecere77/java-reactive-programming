package com.antocecere77.reactive.sec02;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(1,2,3,4);
        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
