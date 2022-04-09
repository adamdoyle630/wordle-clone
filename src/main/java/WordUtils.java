import java.util.Collection;
import java.util.Set;

public class WordUtils {

  /**
   * Reads in and validates user input
   *
   * @param input - input read from System.in
   * @param guessedWords - list of words that have already been guessed
   * @return validated input
   */
  public static String readWord(
      String input, Collection<String> guessedWords, Collection<String> validWords) {
    if (input == null) {
      System.out.println("Entry invalid - cannot be null");
      return null;
    } else if (input.length() != 5) {
      System.out.println("Word must be five letters long");
      return null;
    } else if (guessedWords.contains(input)) {
      System.out.println("Already guessed that one!");
      return null;
    } else if (!validWords.contains(input)) {
      System.out.println("Word not in dictionary!");
      return null;
    } else {
      return input;
    }
  }

  /**
   * Checks each character's position in the word and print the result
   *
   * @param guess - user's guess word
   * @param actual - correct word
   */
  public static void checkWord(String guess, String actual, Set<Character> eliminatedLetters) {
    for (int i = 0; i < guess.length(); i++) {
      char currentChar = guess.charAt(i);
      if (currentChar == actual.charAt(i)) {
        System.out.println(currentChar + " in word, in correct position");
      } else if (actual.contains(String.valueOf(currentChar))) {
        System.out.println(currentChar + " in word, but incorrect position");
      } else {
        System.out.println(currentChar + " not in word");
        eliminatedLetters.add(currentChar);
      }
    }
  }
}
