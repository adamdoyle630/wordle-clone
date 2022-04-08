import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    System.out.println("Welcome to Wordle!");
    System.out.println("Guess a five letter word in six tries or less");
    System.out.println("---------------------------------------------");

    WordBank wordBank = WordBank.acquire();
    EnglishDict englishDict = EnglishDict.acquire();

    // Select random word from a word bank
    String correctWord = wordBank.selectWord();
    // System.out.println(correctWord);

    // Take in user input and check if it's correct
    Scanner input = new Scanner(System.in);
    List<String> guessedWords = new ArrayList<>();
    boolean won = false;

    for (int i = 0; i < 6; i++) {
      String currentGuess = null;
      while (currentGuess == null) {
        System.out.print("(Attempt " + (i + 1) + ") Enter a five letter word: ");
        currentGuess = WordUtils.readWord(input.nextLine(), guessedWords, englishDict.getWords());
      }
      guessedWords.add(currentGuess);
      if (currentGuess.equals(correctWord)) {
        won = true;
        break;
      } else {
        WordUtils.checkWord(currentGuess, correctWord);
      }
    }
    if (won) System.out.println("You guessed it!");
    else System.out.println("Out of tries! The word was: " + correctWord);
  }
}
