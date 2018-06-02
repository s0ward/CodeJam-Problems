import java.util.*;
import java.io.*;

public class Solution {

  static int R;
  static int C;
  static int W;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      R = in.nextInt();
      C = in.nextInt();
      W = in.nextInt();
      System.out.println("Case #" + i + ": " + solve());
    }
  }


  static Integer solve(){
    int r = C%W;
    if(r == 0) return R*(C/W) + W-1;
    return R*(C/W) + W;
  }
}
