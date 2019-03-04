import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[]args){
      String filename1 = "data1.dat";
      String filename2 = "data2.dat";
      String filename3 = "data3.dat";
      //try{
        Maze f;
        f = new Maze(filename1);//true animates the maze.

        f.setAnimate(true);
        f.solve();
        System.out.println(f);

        Maze f;
        f = new Maze(filename2);//true animates the maze.

        f.setAnimate(true);
        f.solve();
        System.out.println(f);

        Maze f;
        f = new Maze(filename3);//true animates the maze.

        f.setAnimate(true);
        f.solve();
        System.out.println(f);
      //} catch(FileNotFoundException e){
        //System.out.println("Invalid filename: "+filename);
      }
}
