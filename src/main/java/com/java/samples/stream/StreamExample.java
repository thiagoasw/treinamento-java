package com.java.samples.stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.toCollection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExample {

    public static final String RESOURCE_DIR = "src/main/resources";

    public static void main(String[] args) {

        AtomicInteger countAfterDistinct = new AtomicInteger(0);
        AtomicInteger countBeforeDistinct = new AtomicInteger(0);
        
        walk(Path.of(RESOURCE_DIR))
            .filter(streamFile())
            .flatMap(StreamExample::readLines)
            .filter(emptyLines().negate())
            .map(line -> getLastWord(line))

            .peek(word -> {
                countBeforeDistinct.incrementAndGet();
            })
        
            .distinct()
            
            .peek(word -> {
                countAfterDistinct.incrementAndGet();
            })
        
            .collect(toCollection(LinkedList::new))
            .descendingIterator()
            
            .forEachRemaining(out::println);
        
        System.out.println(countBeforeDistinct.get() + " - " + countAfterDistinct.get());
    }
    
    

    static Predicate<Path> streamFile() {
        return p -> p.getFileName().toString()
                .equalsIgnoreCase("streams.txt");
    }
    
    static Predicate<Path> streamFile1() {
        return new Predicate<Path>() {

            @Override
            public boolean test(Path p) {
                return p.getFileName().toString()
                        .equalsIgnoreCase("streams.txt");
            }
        };
                
                
                
    }
    
    static Predicate<String> discardEmptyLines() {
        return s -> !s.isEmpty();
    }
    
    static Predicate<String> emptyLines() {
        return s -> s.isEmpty();
    }

    static String getLastWord(String line) {
        return line.substring(line.lastIndexOf(" ") + 1);
    }
    
    static Stream<Path> walk(Path path) {
        try {
            return Files.walk(path);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
    
    static Stream<String> readLines(Path path) {
        try {
            return Files.lines(path, StandardCharsets.UTF_8);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
