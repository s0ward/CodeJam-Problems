import java.util.*;
import java.io.*;

public class Main{

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {
      String S = in.next();
      int K = in.nextInt();
      System.out.println("Case #" + i + ": " + solve(S,K));
    }
  }

  public static String solve(String s, int K){
      char[] arr = s.toCharArray();
      int count = 0;
      int pos = 0;

      while (pos+K<=arr.length){
          if (arr[pos] == '-') {
            arr = flip(arr,K,pos);
            count++;
          }
           pos++;
      }


      if (isValid(arr)) return Integer.toString(count);
      else return "IMPOSSIBLE";

  }

  public static char[] flip(char[] arr, int K, int pos){
    if(pos+K-1 <= arr.length){
      for (int i=0;i<K;i++) {
        if (arr[pos+i] == '+') arr[pos+i] = '-';
        else arr[pos+i] = '+';
      }
    }
    return arr;
  }

  public static boolean isValid(char[] arr){
    for (int i=0;i<arr.length;i++) {
      if(arr[i] != '+') return false;
    }
    return true;
  }
}
