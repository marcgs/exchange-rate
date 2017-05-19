package com.mgomez.sample.exchange.util;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.ClassLoader.getSystemResource;

public class FileStringReader {

    public static String readFile(String filename) {
        try {
            URI fileUri = getSystemResource(filename).toURI();
            return new String(Files.readAllBytes(Paths.get(fileUri)));
        } catch (Exception e) {
            throw new RuntimeException("Could not read file " + filename, e);
        }
    }

}
