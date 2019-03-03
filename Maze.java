import java.util.*;
import java.io.*;

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

    int curChar = 0;
    for (int r=0;r<rows;r++) {
      for (int c=0;c<cols;c++) {
        maze[r][c] = mazeString.charAt(curChar);
        curChar ++;
      }
    }

    System.out.println(Arrays.deepToString(maze));

  }

  public static void main(String[] args) {
    Maze m = new Maze("data1.dat");



  }



}
