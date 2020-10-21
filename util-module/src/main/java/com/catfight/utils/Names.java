package com.catfight.utils;


import com.catfight.entities.Cat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {

    public static void nameCats(List<Cat> cats) throws IOException, URISyntaxException {
        Path path = Path.of(ClassLoader.getSystemResource("myfiles/Names.txt").toURI());
        Stream<String> lines = Files.lines(path);
        List<String> names = new ArrayList<>();
        lines.forEach(names::add);
        int skipCounter = 0;
        for (Cat cat : cats) {
            cat.setName(names.stream()
                    .filter(Pattern.compile("[a-zA-Z]+").asPredicate())
                    .skip(skipCounter++)
                    .limit(1)
                    .collect(Collectors.joining()));
        }
    }
}
