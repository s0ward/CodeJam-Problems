import java.util.*;
import java.io.*;

public class Solution {

  static int N;
  static int Q;
  static int[] E;
  static int[] S;
  static int[][] D;
  static int[] U;
  static int[] V;
  static double[][] W;



  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i=1;i<=T;i++) {
      N = in.nextInt();
      Q = in.nextInt();
      E = new int[N];
      S = new int[N];
      D = new int[N][N];
      U = new int[Q];
      V = new int[Q];
      W = new double[N][N];

      for(int j=0;j<N;j++){
        E[j] = in.nextInt();
        S[j] = in.nextInt();
      }

      for(int j=0; j<N; j++)
        for(int k=0; k<N; k++) D[j][k] = in.nextInt();

      for(int j=0; j<Q; j++){
        U[j] = in.nextInt();
        V[j] = in.nextInt();
      }

      solve();
      Dijkstra djk = new Dijkstra(W);

      //print();
      System.out.println("Case #" + i +": " + djk.solve());
    }
  }

  static void solve(){
    for (int i=0; i<N; i++)
        for(int j=0; j<N; j++) W[i][j] = 0;

    for (int i=0; i<N; i++){
      int reach = E[i];
      int speed = S[i];
      int currPath = 0;

      for(int j=i; j<N-1; j++){
          currPath+=D[j][j+1];
          if(currPath > reach) break;
          W[i][j+1] = ((double) currPath)/S[i];
      }
    }
  }

  /*static void print(){
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        System.out.print(W[i][j]+" ");
      }
      System.out.println();
    }
  }*/
}
