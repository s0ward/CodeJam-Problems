import java.util.*;
import java.io.*;

public class StandingOvation{
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int S = in.nextInt();
      String shy = in.next();
      System.out.println("Case #" + i + ": " + solve(shy));
    }
  }

  static String solve(String str){
    int standing = 0;
    int res = 0;

    for (int i=0; i<str.length(); i++){
      if(standing >= i) standing += (int) (str.charAt(i)-'0');

      else{
        res += i - standing;
        standing = i + (int) (str.charAt(i)-'0');
      }
    }
    return new Integer(res).toString();
  }

}
