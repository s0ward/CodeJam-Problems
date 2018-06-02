import java.util.*;
import java.io.*;

public class Solution {

  static int D = 0;
  static int N = 0;
  static ArrayList<Integer> K;
  static ArrayList<Integer> S;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i=1;i<=T;i++) {
      D = in.nextInt();
      N = in.nextInt();
      K = new ArrayList<Integer>(N);
      S = new ArrayList<Integer>(N);

      for (int j=0;j<N;j++){
        K.add(in.nextInt());
        S.add(in.nextInt());
      }

      System.out.println("Case #" + i +": " + solve());
    }
  }

  static String solve(){
    double res = Double.MAX_VALUE;
    for(int i=0; i<N; i++){
      double temp = ((double) S.get(i)*D)/(D-K.get(i));
      if (temp<res) res = temp;
    }
    return new Double(res).toString();
  }
}
