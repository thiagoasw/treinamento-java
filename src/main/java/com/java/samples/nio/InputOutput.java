package com.java.samples.nio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class InputOutput {

    public static final String INPUT_FILE = "src/main/resources/fruits_in.txt";

    public static final String OUTPUT_FILE = "src/main/resources/fruits_out.txt";

    public static void main(String[] args) throws URISyntaxException, IOException {

        InputOutput io = new InputOutput();

        Path input = io.getFilePath(INPUT_FILE);
        List<String> lines = io.getAllLines(input);

        Path output = io.writeOutputFile(OUTPUT_FILE, lines);

        io.getAllLines(output).forEach(System.out::println);
    }

    Path getFilePath(String path) {

        try {

            Path filePath = Paths.get(path);

            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }

            return filePath;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List<String> getAllLines(Path path) {
        try {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Path writeOutputFile(String output, List<String> lines) {

        Path path = getFilePath(OUTPUT_FILE);

        try {
            for (String line : lines) {
                Files.writeString(path, "out > " + line + "\n", StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
