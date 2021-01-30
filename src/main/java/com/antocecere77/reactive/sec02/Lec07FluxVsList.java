package com.antocecere77.reactive.sec02;

import com.antocecere77.reactive.courseutil.Util;
import com.antocecere77.reactive.sec02.helper.NameGenerator;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {

        List<String> names = NameGenerator.getNames(5);
        System.out.println("List " + names);

        System.out.println("Flux starting");
        NameGenerator.getNamesFlux(5)
                .subscribe(Util.onNext());
    }
}
