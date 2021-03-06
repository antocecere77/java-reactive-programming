package com.antocecere77.reactive.sec06;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06Parallel {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .parallel()
                .runOn(Schedulers.parallel())
                .doOnNext(i -> printThreadName("next " + i))
                //.sequential()
                .subscribe(v -> printThreadName("sub " + v));

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg){
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
