import java.util.*;
import java.io.*;

public class Fractiles{
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int K = in.nextInt();
      int C = in.nextInt();
      int S = in.nextInt();
      System.out.println("Case #" + i + ": " + solveLarge(K,C,S));
    }
  }


  static String solveSmall(int K, int C){
    String res = new String();
    for(int i=1; i<K+1; i++) res += new Integer(i).toString() + " ";
    return res;
  }

  static String solveLarge(int K, int C, int S){
    String res = new String();
    if(S<Math.ceil(((double) K)/((double) C))) return "IMPOSSIBLE";

    else{
      for(int i=0;i<Math.ceil(((double) K)/((double) C)); i++) res += new Long(convertToNumber(1+i*C,K,C)).toString() + " ";
    }
    return res;
  }

  static long convertToNumber(long start, long K, long C){
    long spread = (long) Math.pow(K,C-1);
    long res = 1;

    for(long i = start; i<start+C; i++){
      res += ((i-1)%K)*spread;
      spread /= K;
    }

    return res;
  }
}
