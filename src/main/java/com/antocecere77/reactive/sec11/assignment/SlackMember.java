package com.antocecere77.reactive.sec11.assignment;

import java.util.function.Consumer;

public class SlackMember {

    private String name;
    private Consumer<String> messageConsumer;

    public SlackMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void receive(String message) {
        System.out.println(message);
    }

    public void says(String message) {
        this.messageConsumer.accept(message);
    }

    public void setMessageConsumer(Consumer<String> messageConsumer) {
        this.messageConsumer = messageConsumer;
    }
}
