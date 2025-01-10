package fr.diginamic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import fr.diginamic.components.FileGenerator;

public class MainTest {
  @Test
  public void isFile1Empty() throws IOException {
    FileGenerator fileGenerator = new FileGenerator();
    assertTrue(fileGenerator.readFile1().isPresent());
  }

  @Test
  public void isFile1EqualMagicPhrase() throws IOException {
    FileGenerator fileGenerator = new FileGenerator();
    String magicPhrase = "Bonjour le monde !";
    assertEquals(magicPhrase, fileGenerator.readFile1().get().get(0));
  }
}
