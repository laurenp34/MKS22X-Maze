import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
  private String maze;

  public Maze(String fileName) {
    try {
      File file = new File(fileName);
      Scanner s = new Scanner(file);

      while (s.hasNextLine()) {
        String line = s.nextLine();
        maze += line;
        System.out.println(line);
      }

    } catch (FileNotFoundException e) {
      System.out.println("File not found: "+fileName);
      System.exit(1);
    }
  }



}
