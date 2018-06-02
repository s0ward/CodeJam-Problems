import java.util.*;
import java.io.*;

public class Solution {

  static long N = 0;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      N = in.nextLong();
      System.out.println("Case #" + i + ": " + solve());
      }
  }


  static Integer solve(){
    int count=0;
    while(N>1){
      if(reverse(N) < N-1) N = reverse(N);
      else N--;
      count++;
      //System.out.println(N);
    }
    //System.out.println("COUNT:  " + count);
    return count+1;
  }

  static long reverse(long n){
    if(n%10 == 0) return n;
    ArrayList<Long> digits = new ArrayList<>(15);
    while(n>0){
      digits.add(n%10);
      n=n/10;
    }

    Collections.reverse(digits);

    long product = 1;
    long reversed = 0;
    for(long d: digits){
      reversed += d*product;
      product *=10;
    }

    return reversed;
  }
}
