import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Score {

  private static final File scoreLog = new File("src/main/resources/score-log.txt");
  private static Score score;
  private int scoreSum;
  private int scoreCount;
  private int bestScore;

  private Score() {}

  public static Score init() {
    if (score == null) {
      score = new Score();
    }
    return score;
  }

  public int getAverage() {
    return scoreSum / scoreCount;
  }

  public int getBestScore() {
    return bestScore;
  }

  public void update(int score) {
    FileWrite.writeScore(score, scoreLog);
    scoreSum = scoreSum + score;
    scoreCount++;
    if (bestScore == 0) {
      bestScore = score;
    }
    if (score < bestScore) {
      bestScore = score;
    }
  }
}