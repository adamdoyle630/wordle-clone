import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/** Singleton class for retrieving dictionary of valid words
 *
 */
public class EnglishDict {
  private final Set<String> words = new HashSet<>();
  private static EnglishDict englishDict;

  private EnglishDict() {
    try {
      String path = "src/main/resources/dictionary.txt";
      Scanner fileReader = new Scanner(new File(path));
      while (fileReader.hasNext()) {
        words.add(fileReader.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Error: word dictionary failed to load");
      System.exit(-1);
    }
  }

  public static EnglishDict acquire() {
    if (englishDict == null) {
      englishDict = new EnglishDict();
    }
    return englishDict;
  }

  public Set<String> getWords() {
    return new HashSet<>(words);
  }
}
