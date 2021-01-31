package com.antocecere77.reactive.courseutil;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {

    private String name;

    public DefaultSubscriber(String name) {
        this.name = name + " - ";
    }

    public DefaultSubscriber() {
        this.name = "";
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name + "received: " + o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + "ERROR " + throwable.getStackTrace());
    }

    @Override
    public void onComplete() {
        System.out.println(name + "completed!");
    }
}
