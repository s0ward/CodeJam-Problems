import java.util.*;
import java.io.*;

public class Solution{

  static int AC;
  static int AJ;
  static int[] C;
  static int[] D;
  static int[] J;
  static int[] K;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {
      AC = in.nextInt();
      AJ = in.nextInt();
      C = new int[AC];
      D = new int[AC];
      J = new int[AJ];
      K = new int[AJ];

      for(int j=0; j<AC; j++){
        C[j] = in.nextInt();
        D[j] = in.nextInt();
      }

      for(int j=0; j<AJ; j++){
        J[j] = in.nextInt();
        K[j] = in.nextInt();
      }

      System.out.println("Case #" + i +": "+solve());
    }
  }

  static String solve(){
    return "TEST";
  }
}
