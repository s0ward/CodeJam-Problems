import java.util.*;
import java.io.*;

public class Solution {

  static int N;
  static int L;
  static ArrayList<Integer> l;
  static int rest = 0;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      N = in.nextInt();
      L = in.nextInt();
      l = new ArrayList<Integer>(L);
      int sum = 0;

      for(int j=0; j<L; j++) {
        int temp = in.nextInt();
        sum+=temp;
        l.add(temp);
      }
      
      rest = N-sum;

      System.out.println("Case #" + i + ": " + solve());
    }
  }

  static int solve(){
    double d = ((double) 100/N)%1;
    if(d == 0) return 100;

    int min = (int) Math.ceil(0.5/d);

    //System.out.println("d:"+d+" min:"+min);

    while(rest > 0){
      int lmin = Integer.MAX_VALUE;
      int lindex = 0;
      int count  = 0;

      for(int i: l){
        double dec = ((double) (100*i)/N)%1;

        if(dec < 0.5){
          int c = (int) Math.ceil((0.5-dec)/d);
          if(c < lmin) {
            lmin = c;
            lindex = count;
          }

        }
        count++;
      }

      if(lmin <= min) {
        if(rest >= lmin) {
          l.set(lindex, l.get(lindex)+lmin);
          rest -= lmin;
        }
        else{
          l.set(lindex,l.get(lindex)+rest);
          rest = 0;
        }
      }

      else{
        if(rest >= min) {
          l.add(min);
          rest-=min;
        }
        else {
          l.add(rest);
          rest = 0;
        }
      }
    }

    return calc();
  }

  static int calc(){
    int res = 0;
    for(int i: l){
      double temp = (double) 100*i/N;
      if(temp%1 >= 0.5) res+=(int) temp + 1;
      else res+=(int) temp;
    }

    return res;
  }
}
