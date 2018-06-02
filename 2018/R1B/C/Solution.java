import java.util.*;
import java.io.*;

public class Solution {

  static char[] str;
  static int D;
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      D = in.nextInt();
      str = in.next().toCharArray();
      System.out.println("Case #" + i + ": " + solve());
    }
  }

  static int solve(){

  }
}
