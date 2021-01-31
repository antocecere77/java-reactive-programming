package com.antocecere77.reactive.sec03;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxCreate {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            //Simple example
            //fluxSink.next(1);
            //fluxSink.next(2);
            //fluxSink.complete();

            String country;
            do{
                country = Util.faker().country().name();
                fluxSink.next(country);
            } while(!country.equalsIgnoreCase("canada"));

            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
