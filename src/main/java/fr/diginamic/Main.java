package fr.diginamic;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import fr.diginamic.components.FileGenerator;

public class Main {
    public static void main(String[] args) throws IOException {
        FileGenerator fileGenerator = new FileGenerator();
        Optional<List<String>> words = fileGenerator.readFile1();

        if (words.isPresent()) {
            for (String word : words.get()) {
                System.out.println(word);
            }
        }
    }
}