import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Singleton class for retrieving dictionary of valid words
 *
 */
public class EnglishDict {
  private final List<String> words = new ArrayList<>();
  private static EnglishDict englishDict;

  private EnglishDict() {
    try {
      String path = "files/dictionary.txt";
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

  public List<String> getWords() {
    return new ArrayList<>(words);
  }
}
