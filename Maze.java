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
  public Maze(String fileName) {
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

  /*Return the string that represents the maze.
  It should look like the text file with some characters replaced.
 */
  public String toString(){
    String result = "";
    for (char[] row: maze) {
      for (char c: row) {
        result += c;
      }
      result += "\n";
    }
    return result;
  }

  /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
  public boolean solve(){
    //find the location of the S.
    int startR = 0;
    int startC = 0;
    for (int r=0;r<maze.length;r++) {
      for (int c=0;c<maze[r].length;c++) {
        if (maze[r][c] == 'S') {
          startR = r;
          startC = c;
        }
      }
    }

    //erase the S
    maze[startR][startC ] = ' ';
    //and start solving at the location of the s.
    return solve(startR,startC);
            //return solve(???,???);
  }

  public boolean solve(int r,int c) {

    //automatic animation! You are welcome.

    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(100);
    }

    if (maze[r][c] == 'E') return true;

    int steps = 0;
    //COMPLETE SOLVE


    int[] stepR = {1,-1,0,0};
    int[] stepC = {0,0,1,-1};

    for (int i=0;i<4;i++) {
      int nextR = r+stepR[i];
      int nextC = c+stepC[i];

      if (maze[nextR][nextC] == ' ') {
        //steps ++;
        maze[nextR][nextC] = '@';
        if (solve(nextR,nextC)) {
          return true;
        }


      }
    }
    return false;

  }

  public static void main(String[] args) {
    Maze m = new Maze("data1.dat");
    m.setAnimate(true);
    System.out.println(m);
    System.out.println(m.solve());
    System.out.println(m);
  }



}
