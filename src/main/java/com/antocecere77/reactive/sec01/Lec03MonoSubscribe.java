package com.antocecere77.reactive.sec01;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {

        //pusblisher
        //Mono<String> mono = Mono.just("ball");

//        mono.subscribe(
//                item -> System.out.println(item),
//                err -> System.out.println(err.getMessage()),
//                () -> System.out.println("Completed")
//        );

        //pusblisher
        final var monoInteger = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 0);

        monoInteger.subscribe();

        monoInteger.subscribe(
                item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );
    }
}
