import java.util.*;
import java.io.*;

public class Maze {
  private char[][] maze;
  private boolean animate;//false by default

/*Constructor loads a maze text file, and sets animate to false by default.
  When the file is not found then:
     throw a FileNotFoundException

  You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - Walls - locations that cannot be moved onto
  ' ' - Empty Space - locations that can be moved onto
  'E' - the location of the goal (exactly 1 per file)
  'S' - the location of the start(exactly 1 per file)

  You ma also assume the maze has a border of '#' around the edges.
  So you don't have to check for out of bounds!
*/
  public Maze(String filename) throws FileNotFoundException{
    //COMPLETE CONSTRUCTOR
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

  private void wait(int millis){
     try {
         Thread.sleep(millis);
     }
     catch (InterruptedException e) {
     }
   }

   public void setAnimate(boolean b){
    animate = b;
  }

  public void clearTerminal(){
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");
  }

  public static void main(String[] args) {
    Maze m = new Maze("data1.dat");



  }



}
