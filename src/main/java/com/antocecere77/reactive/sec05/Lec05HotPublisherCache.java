package com.antocecere77.reactive.sec05;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec05HotPublisherCache {

    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                //.cache(2);
                .cache();

        Util.sleepSeconds(2);

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(10);

        System.out.println("Mike is about to join");

        movieStream.subscribe(Util.subscriber("mike"));
        Util.sleepSeconds(60);
    }

    //Movie-theatre
    private static Stream<String> getMovie() {
        System.out.println("Got the movie stream req");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
