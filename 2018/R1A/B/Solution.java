import java.util.*;
import java.io.*;

public class Solution {

  static int R = 0;
  static int B = 0;
  static int C = 0;
  static int[] M;
  static int[] S;
  static int[] P;
  static boolean[] used;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      R = in.nextInt();
      B = in.nextInt();
      C = in.nextInt();
      M = new int[C];
      S = new int[C];
      P = new int[C];
      used = new boolean[C];


      for(int j=0; j<C; j++){
        M[j] = in.nextInt();
        S[j] = in.nextInt();
        P[j] = in.nextInt();
        used[j] = false;
      }

      System.out.println("Case #" + i + ": " + solve());
    }
  }

  static String solve(){

    int T = 0;

    while(B>0) {

      int index = -1;
      double min = Double.MAX_VALUE;

      for (int i=0; i<C; i++){
        if(used[i]) continue;

        double temp = S[i] + ((double) P[i]/M[i]);

        if (temp<min) {
          min = temp;
          index = i;
        }
      }

      //System.out.println("INDEX: "+index);

      if(B>=M[index]) {
        T = Math.max(T, S[index]*M[index] + P[index]);
      //  System.out.println("S: "+S[index]+" M: "+M[index]+" P: "+P[index]);
      //  System.out.println("IF: "+T);
        used[index] = true;
        B -= M[index];
      }

      else {
        T = Math.max(T, S[index]*B + P[index]);
      //  System.out.println("S: "+S[index]+" B: " + B + " P: "+P[index]);
      //  System.out.println("ELSE: "+T);
        B = 0;
      }

    }
    return new Integer(T).toString();
  }

  static String solve2(){

        int T = 0;

        while(B>0) {

          int index = -1;
          double min = Double.MAX_VALUE;

          for (int i=0; i<C; i++){
            if(used[i]) continue;

            double temp = S[i] + ((double) P[i]/M[i]);

            if (temp<min) {
              min = temp;
              index = i;
            }
          }

          //System.out.println("INDEX: "+index);

          if(B>=M[index]) {
            T = Math.max(T, S[index]*M[index] + P[index]);
          //  System.out.println("S: "+S[index]+" M: "+M[index]+" P: "+P[index]);
          //  System.out.println("IF: "+T);
            used[index] = true;
            B -= M[index];
          }

          else {
            T = Math.max(T, S[index]*B + P[index]);
          //  System.out.println("S: "+S[index]+" B: " + B + " P: "+P[index]);
          //  System.out.println("ELSE: "+T);
            B = 0;
          }

        }
        return new Integer(T).toString();
  }
}
