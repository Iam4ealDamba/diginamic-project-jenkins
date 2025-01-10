package fr.diginamic.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileGenerator {
  String path = "src/main/resources/";
  File file1 = new File(path, "test1.txt");

  @SuppressWarnings("resource")
  public Optional<List<String>> readFile1() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));

    String line = bufferedReader.readLine();
    List<String> words = new ArrayList<>();
    while (line != null) {
      words.add(line);
      line = bufferedReader.readLine();
    }

    if (words.size() <= 0) {
      return Optional.empty();
    }

    bufferedReader.close();
    return Optional.of(words);
  }
}
