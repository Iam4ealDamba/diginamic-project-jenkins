package fr.diginamic.components;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileGenerator {
  String baseResUrl;
  File file1;

  public FileGenerator(Class<?> clazz) throws IOException {
    URL resource = clazz.getClassLoader().getResource(".");
    if (resource != null) {
      this.baseResUrl = resource.getPath();

    } else {
      this.baseResUrl = ".";
    }

    this.file1 = new File(baseResUrl, "test1.txt");

    String txt = "Bonjour le monde !";
    if (!file1.exists()) {
      System.out.println("File created: " + file1.getName());
      file1.createNewFile();
      BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
      writer.write(txt);
      writer.close();
    }
  }

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
