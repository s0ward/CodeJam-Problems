import java.util.*;
import java.io.*;

public class Solution {

  static int N = 0;
  static int P = 0;
  static int[] w;
  static int[] h;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      N = in.nextInt();
      P = in.nextInt();
      w = new int[N];
      h = new int[N];

      for(int j = 0; j < N; j++){
        w[j] = in.nextInt();
        h[j] = in.nextInt();
      }

      System.out.println("Case #" + i + ": " + solveSmall());
    }
  }

  static Double solveSmall(){
    int W = w[0];
    int H = h[0];

    int p = P - 2*N*(W+H);

    if(p < Math.min(W,H)) return new Double(2*N*(W+H));
    else if(p <= 2*N*Math.sqrt(H*H+W*W)) return new Double(P);
    else return new Double(2*N*(W+H)+2*N*Math.sqrt(H*H+W*W));
  }
}
