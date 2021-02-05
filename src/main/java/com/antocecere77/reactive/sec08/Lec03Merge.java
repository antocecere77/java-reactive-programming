package com.antocecere77.reactive.sec08;

import com.antocecere77.reactive.courseutil.Util;
import com.antocecere77.reactive.sec08.helper.AmericanAirlines;
import com.antocecere77.reactive.sec08.helper.Emirates;
import com.antocecere77.reactive.sec08.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lec03Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericanAirlines.getFlights()
        );

        merge.subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
