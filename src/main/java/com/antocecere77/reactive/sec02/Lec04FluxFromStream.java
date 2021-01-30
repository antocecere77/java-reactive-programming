package com.antocecere77.reactive.sec02;

import com.antocecere77.reactive.courseutil.Util;
import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        stream.forEach(System.out::println);
        //stream.forEach(System.out::println);  -> Throw an exception

        Flux<Integer> integerFlux = Flux.fromStream(list.stream());
        integerFlux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        //integerFlux.subscribe(Util.onNext(), Util.onError(), Util.onComplete()); -> Throw exception ERROR: stream has already been operated upon or closed
    }
}
