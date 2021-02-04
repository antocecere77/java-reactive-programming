package com.antocecere77.reactive.sec08;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02Concat {

    public static void main(String[] args) {

        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("a", "b", "c");
        Flux<String> flux3 = Flux.error(new RuntimeException("oops"));

        //Flux<String> flux = flux1.concatWith(flux2);
        Flux<String> flux = Flux.concat(flux1, flux2, flux3);

        flux.subscribe(Util.subscriber());
    }
}
