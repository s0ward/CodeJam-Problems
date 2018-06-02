import java.util.*;
import java.io.*;

public class Solution {

  static String C;
  static String J;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      C = in.next();
      J = in.next();
      System.out.println("Case #" + i + ": " + solve());
    }
  }

  static String solve(){
    char[] charsC = C.toCharArray();
    char[] charsJ = J.toCharArray();

    boolean nineC = false;
    boolean nineJ = false;
    boolean set = false;

    for(int i=0; i<charsC.length; i++){
      if(charsC[i] == '?' && charsJ[i] != '?') {
        if(nineJ) charsC[i] = '0';
        else if(nineC) charsC[i] = '9';
        else charsC[i] = charsJ[i];
      }

      else if(charsC[i] != '?' && charsJ[i] == '?') {
        if(nineJ) charsJ[i] = '9';
        else if(nineC) charsJ[i] = '0';
        else charsJ[i] = charsC[i];
      }
      else if(charsC[i] == '?' && charsJ[i] == '?') {
        if(nineC == true && nineJ == false) {
          charsC[i] = '9';
          charsJ[i] = '0';
        }

        else if(nineC == false && nineJ ==  true) {
          charsC[i] = '0';
          charsJ[i] = '9';
        }
        else{
          charsC[i] = '0';
          charsJ[i] = '0';
        }

      }
      else{
        if(charsC[i] > charsJ[i] && !set) {
          nineJ = true;
          set = true;
        }
        else if(charsJ[i] > charsC[i] && !set) {
          nineC = true;
          set = true;
        }
      }
  }

  return new String(charsC) + " " + new String(charsJ);
  }
}
