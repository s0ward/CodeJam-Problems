import java.util.*;
import java.io.*;

public class Omino{

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int X = in.nextInt();
      int R = in.nextInt();
      int C = in.nextInt();
      System.out.println("Case #" + i + ": " + solveSmall(X,R,C));
    }
  }

  static String solveSmall(int X, int R, int C){
    if((R*C) % X != 0) return "RICHARD";

    switch(X){
      case 1: return "GABRIEL";
      case 2: return "GABRIEL";
      case 3:
        if((R == 1 && C == 3) || (R == 3 && C == 1)) return "RICHARD";
        return "GABRIEL";
      case 4:
        if((R == 2 && C == 2) || (R == 1 && C == 4) || (R == 4 && C == 1) || (R == 2 && C == 4) || (R == 4 && C == 2)) return "RICHARD";
        return "GABRIEL";
      default:
      return "IMPOSSIBLE";
    }
  }

  static String solveLarge(int X, int R,int C){
    
  }

}
