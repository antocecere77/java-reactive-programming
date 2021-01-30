package com.antocecere77.reactive.sec02;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

    public static void main(String[] args) {

        Flux.range(3, 10)
                .map(i -> Util.faker().name().fullName())
                .subscribe(Util.onNext());
    }
}
