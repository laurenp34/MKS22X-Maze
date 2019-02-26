import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
  private char[][] maze;

  public Maze(String fileName) {
    String mazeString = "";
    int rows = 0;
    int cols = 0;
    try {
      File file = new File(fileName);
      Scanner s = new Scanner(file);

      while (s.hasNextLine()) {
        String line = s.nextLine();
        rows++;
        cols = line.length();
        mazeString += line;
        //System.out.println(line);
      }

    } catch (FileNotFoundException e) {
      System.out.println("File not found: "+fileName);
      System.exit(1);
    }

    System.out.println(mazeString);
    maze = new char[rows][cols];

    int r=0;
    int c=0;
    while ()

  }

  public static void main(String[] args) {
    Maze m = new Maze("Maze1.txt");



  }



}
