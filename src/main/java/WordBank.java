import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/** Singleton class for acquiring word bank
 *
 */
public class WordBank {
  private final List<String> words = new ArrayList<>();
  private static WordBank wordBank;

  private WordBank() {
    try {
      String path = "files/wordbank.txt";
      Scanner fileReader = new Scanner(new File(path));
      while (fileReader.hasNext()) {
        words.add(fileReader.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Error: Word bank failed to load");
      System.exit(-1);
    }
  }

  public static WordBank acquire() {
    if (wordBank == null) {
      wordBank = new WordBank();
    }
    return wordBank;
  }

  public String selectWord() {
    Random rand = new Random();
    int selectedIndex = rand.nextInt(words.size());
    return words.get(selectedIndex);
  }
}
