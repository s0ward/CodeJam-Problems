import java.util.*;
import java.io.*;
public class Solution {

  static int N;
  static int L;
  static String[] n;
  static char[] res;
  static int[][] hist;
  static String genReturn;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      N = in.nextInt();
      L = in.nextInt();

      n = new String[N];
      res = new char[L];
      hist = new int [L][26];
      genReturn = new String("#");

      for(int j=0; j<N; j++) {
        n[j] = in.next();
        char[] temp = n[j].toCharArray();
        for (int k=0; k<L; k++) hist[k][temp[k]-'A']++;
      }

      System.out.println("Case #" + i + ": " + solve());
    }
  }

  static String solve(){
    long p = 1;
    for(int i=0; i<L; i++) p*=card(hist[i]);

    if(p == (long) N) return "-";

    else{
      generate(0);
      return genReturn;
    }
  }

  static void generate (int i){

    if(genReturn.equals("#")){

      if(i == L){
        if (isValid(new String(res))) genReturn = new String(res);
      }

      else{
        for(int j=0; j<26; j++){
          if(hist[i][j] > 0) {
            res[i] = (char) ('A'+j);
            generate(i+1);
          }
        }
      }
    }
  }

  static boolean isValid(String s){
    for(int i=0; i<N; i++){
      if(n[i].equals(s)) return false;
    }
    return true;
  }

  static int card(int[] hist){
    int res = 0;
    for(int i=0; i < 26; i++)
      if(hist[i] > 0) res++;
    return res;
  }

}
