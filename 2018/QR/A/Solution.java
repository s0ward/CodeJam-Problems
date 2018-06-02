import java.util.*;
import java.io.*;
public class Solution {
  static char[] str;
  static int D;
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      D = in.nextInt();
      str = in.next().toCharArray();
      System.out.println("Case #" + i + ": " + solve());
    }
  }

  static String solve(){
    boolean flag = true;
    int count = 0;

    while(damage() > D && flag) {
      flag = swapHack();
      count++;
    }

    if(!flag) return "IMPOSSIBLE";
    return new Integer(count).toString();
  }

  static boolean swapHack(){
    for(int i = str.length-1;i>0;i--){
      if(str[i-1] == 'C' && str[i] == 'S'){
        str[i-1]='S';
        str[i]='C';
        return true;
      }
    }
    return false;
  }

  static long damage(){
    long curr = 1;
    long dmg = 0;
    for(int i=0; i<str.length; i++){
      if(str[i] == 'S') dmg+=curr;
      else curr*=2;
    }
    return dmg;
  }
}
