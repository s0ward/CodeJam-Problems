import java.util.*;
import java.io.*;

public class Solution{

  static int N;
  static int P;
  static int[] G;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {

      N = in.nextInt();
      P = in.nextInt();
      G = new int[P];

      for(int j=0; j<N; j++) G[in.nextInt()%P]++;
      System.out.println("Case #" + i +": "+solve());
    }
  }

  static int solve(){

    int res = 0;

    switch(P){
      case 2:
        res += G[0];
        res += Math.ceil(G[1]/2.0);
        return res;

      case 3:
        res += G[0];
        int temp = Math.min(G[1], G[2]);
        res += temp;
        G[1] -= temp;
        G[2] -= temp;
        res += Math.ceil(G[1]/3.0);
        res += Math.ceil(G[2]/3.0);
        return res;

      case 4:
        res += G[0];
        res += G[2]/2;
        G[2] = G[2]%2;
        int temp = Math.min(G[1], G[3]);
        res += temp;
        G[1] -= temp;
        G[3] -= temp;

        if(G[2] == 0){
          if(G[1] > 0) {
            // x 0 0
            res += Math.ceil(G[1]/4.0);
            return res;
          }

          else if(G[3] > 0){
            // 0 0 x
            res += Math.ceil(G[3]/4.0);
            return res;
          }
        }

        else{
          if(G[1] > 0){
            // x 1 0
          }

          else if(G[3] > 0){
            // 0 1 x
          }

        return res;
        }
    return -1;
    }
  }
}
