import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {

    System.out.println("Welcome to Wordle!");
    System.out.println("Guess a five letter word in six tries or less");
    System.out.println("---------------------------------------------");

    WordBank wordBank = WordBank.acquire();
    EnglishDict englishDict = EnglishDict.acquire();
    Score score = Score.init();
    boolean play = true;

    while (play) {
      // Select random word from a word bank
      String correctWord = wordBank.selectWord();
      System.out.println(correctWord);

      // Take in user input and check if it's correct
      Scanner input = new Scanner(System.in);
      Set<String> guessedWords = new HashSet<>();
      Set<Character> eliminatedLetters = new HashSet<>();
      boolean won = false;
      int totalAttempts = 0;

      for (int i = 0; i < 6; i++) {
        String currentGuess = null;
        while (currentGuess == null) {
          System.out.println("Eliminated letters: " + eliminatedLetters);
          System.out.print("(Attempt " + (i + 1) + ") Enter a five letter word: ");
          currentGuess = WordUtils.readWord(input.nextLine(), guessedWords, englishDict.getWords());
        }
        guessedWords.add(currentGuess);
        if (currentGuess.equals(correctWord)) {
          won = true;
          totalAttempts = i + 1;
          break;
        } else {
          WordUtils.checkWord(currentGuess, correctWord, eliminatedLetters);
        }
      }
      if (won) {
        System.out.println("You guessed it!");
        System.out.println("Attempts: " + totalAttempts);
        score.update(totalAttempts);
        System.out.println("Average: " + score.getAverage());
        System.out.println("Best: " + score.getBestScore());
      } else System.out.println("Out of tries! The word was: " + correctWord);

      System.out.print("Play again? (y/n) ");
      String playAgain = input.nextLine();
      if (playAgain.equals("n") || playAgain.equals("N")) {
        play = false;
      }
    }
  }
}
