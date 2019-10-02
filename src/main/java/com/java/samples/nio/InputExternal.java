package com.java.samples.nio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputExternal {

    public static void main(String[] args) throws URISyntaxException, IOException {

        URL url = new URL("http://raw.githubusercontent.com/thiagoasw/totvs-meetup-graal-quarkus/master/README.md");
        
        Path path = Paths.get(url.toURI());
        
        Files.readAllLines(path, StandardCharsets.UTF_8)
            .forEach(System.out::println);
    }

}
