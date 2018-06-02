import java.util.*;
import java.io.*;

public class Solution1 {

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
    double p =  ((double) 100/N)%1;
    if (p==0) return 100;
    int c = (int) Math.ceil(0.5/p);

    //System.out.println("p:"+p+" c:"+c);

    Collections.sort(l);
    //System.out.println("BEFORE WHEN rest="+rest);
    //System.out.println(l);

    for(int i=l.size()-1; i>0;i--){
      if(rest == 0) break;

      if(l.get(i) < c) {
        if(c-l.get(i) <= rest){
          System.out.println("HERE");
          rest-=(c-l.get(i));
          l.set(i, c);
        }
      }
    }

    //System.out.println("AFTER WHEN rest="+rest);
    //System.out.println(l);

    if(rest != 0){
      while(rest > c){
          l.add(c);
          rest-=c;
        }
    }

    if(rest != 0){
      for(int i=l.size()-1; i>0;i--){
        if(rest == 0) break;

        if(l.get(i) < c) {
          l.set(i, l.get(i)+rest);
          rest = 0;
        }
      }
    }

    if(rest != 0){
      l.add(rest);
    }

    //System.out.println("AFTER WHEN rest="+rest);
    //System.out.println(l);

    return calc();
  }

  static int calc(){
    int res = 0;
    for(int i: l){
      double temp = (double) 100*((double) i / N);
      if(temp%1 >= 0.5) res+=(int) temp + 1;
      else res+=(int) temp;
    }

    return res;
  }
}
