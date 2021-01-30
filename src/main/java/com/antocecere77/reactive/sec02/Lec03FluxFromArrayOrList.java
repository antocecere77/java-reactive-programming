package com.antocecere77.reactive.sec02;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "b", "c");

        Flux.fromIterable(strings)
                .subscribe(Util.onNext());

        Integer[] arr = {1,2,3,4};
        Flux.fromArray(arr)
                .subscribe(Util.onNext());
    }
}
