package com.antocecere77.reactive.sec01;

import org.w3c.dom.ls.LSOutput;

import java.util.stream.Stream;

public class Lec01Stream {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1)
                .map(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i*2;
                });
        //System.out.println(stream);
        stream.forEach(System.out::println);
    }
}
