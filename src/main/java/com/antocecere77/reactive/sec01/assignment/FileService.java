package com.antocecere77.reactive.sec01.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");

    private static String readFile(String filename) {
        try {
            return Files.readString(PATH.resolve(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(String filename, String content) {
        try {
            Files.writeString(PATH.resolve(filename), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteFile(String filename, String content) {
        try {
            Files.delete(PATH.resolve(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
