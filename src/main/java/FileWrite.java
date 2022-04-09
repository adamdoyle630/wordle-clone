import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
  public static void writeScore(int score, File file) {
    try {
      BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
      output.newLine();
      output.append("").append(String.valueOf(score));
      output.close();
    } catch (IOException ex1) {
      System.out.printf("ERROR writing score to file: %s\n", ex1);
    }
  }
}