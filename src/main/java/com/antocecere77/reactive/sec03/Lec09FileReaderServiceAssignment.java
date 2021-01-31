package com.antocecere77.reactive.sec03;

import com.antocecere77.reactive.courseutil.Util;
import com.antocecere77.reactive.sec03.assignment.FileReaderService;

import java.nio.file.Path;
import java.nio.file.Paths;


public class Lec09FileReaderServiceAssignment {

    public static void main(String[] args) {

        FileReaderService readerService = new FileReaderService();
        Path path = Paths.get("java-reactive-programming\\src\\main\\resources\\assignment\\sec03\\file01.txt");
        readerService.read(path)
                .map(s -> {
                    Integer integer = Util.faker().random().nextInt(0, 10);
                    if(integer > 8) {
                        throw new RuntimeException("oops");
                    }
                    return s;
                })
                .subscribe(Util.subscriber());
    }
}
