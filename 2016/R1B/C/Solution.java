import java.util.*;
import java.io.*;

public class Solution {

  static int N = 0;
  static String[] F;
  static String[] S;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {

      N = in.nextInt();
      F = new String[N];
      S = new String[N];

      for(int j=0; j<N; j++) {
        F[j] = in.next();
        S[j] = in.next();
      }

      System.out.println("Case #" + i + ": " + solve());
    }
  }

  static String solve(){
    //for(int i=0; i<N; i++) System.out.println(F[i] + " " + S[i]);
    return " ";
  }
}
