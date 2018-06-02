import java.util.*;
import java.io.*;

public class Solution {

  static int MAXN = 10000;
  static int[] mp = new int[MAXN];
  static int R = 0;
  static int C = 0;
  static int N = 0;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      R = in.nextInt();
      C = in.nextInt();
      N = in.nextInt();
      System.out.println("Case #" + i + ": " + solve());
      }
  }

  static void print(int length){
    for(int i=0; i<length; i++) System.out.print(mp[i]+" ");
    System.out.println();
  }


  static void comb(int i, int after){
    if(i > N) return;
    for(int j = after+1; j <= R*C; j++){
      mp[i-1] = j;
      if(i == N) print(i);
      comb(i+1,j);
    }
  }

  static void evaluate(){
    
  }

  static Integer solve(){
    comb(1,0);
    return 0;
  }
}
