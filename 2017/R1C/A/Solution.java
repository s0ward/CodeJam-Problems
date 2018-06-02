import java.util.*;
import java.io.*;

public class Solution{
  static int N;
  static int K;
  static int[] R;
  static int[] H;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {
      N = in.nextInt();
      K = in.nextInt();
      R = new int[N];
      H = new int[N];

      for(int j=0; j<N; j++){
        R[j] = in.nextInt();
        H[j] = in.nextInt();
      }

      System.out.println("Case #" + i +": "+solve());
    }
  }

  static String solve(){
    double res = 0;
    for(int i=0; i<N; i++){
      double currRes = 0;
      ArrayList<Integer> smaller = new ArrayList<Integer>(N);
      for(int j=0; j<N; j++)
        if(R[j] <= R[i] && i != j) smaller.add(j);

      //System.out.println(smaller);
      if(smaller.size() < (K-1)) continue;

      Collections.sort(smaller, new Comparator<Integer>() {
        @Override
        public int compare(Integer first, Integer second){
          if(2*Math.PI*R[first]*H[first] == 2*Math.PI*R[second]*H[second]) return 0;
          else if(2*Math.PI*R[first]*H[first] > 2*Math.PI*R[second]*H[second]) return -1;
          else return 1;
        }
      });


      //System.out.println(smaller);

      currRes+=Math.PI*R[i]*R[i]+2*Math.PI*R[i]*H[i];



      for(int j=0;j < (K-1); j++) currRes+=2*Math.PI*R[smaller.get(j)]*H[smaller.get(j)];

      if(currRes > res) res = currRes;
    }
    return new Double(res).toString();
  }
}
