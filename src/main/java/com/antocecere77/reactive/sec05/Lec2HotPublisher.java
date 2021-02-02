package com.antocecere77.reactive.sec05;

import com.antocecere77.reactive.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec2HotPublisher {


    public static void main(String[] args) {

        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .share();

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(3);

        movieStream.subscribe(Util.subscriber("mike"));
        Util.sleepSeconds(60);
    }

    //Neflix
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
