import java.util.*;
import java.io.*;

public class Main{

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();
    for (int i = 1; i <= T; ++i) {
     long N = in.nextLong();
     System.out.println("Case #" + i + ": " + solve(N));
   }
  }

  public static String solve(long N){

    ArrayList<Long> digits = new ArrayList<>(20);
    ArrayList<Long> result = new ArrayList<>(20);

    while(N>0){
      digits.add(0, N%10);
      N = (N-N%10)/10;
    }

    if (digits.size() == 0) return "0";
    else if (digits.size() == 1) return digits.get(0).toString();
    else{
      boolean flag = false;
      for (int i=0;i<digits.size()-1;i++){
          if (flag) {
            result.add((long) 9);
            continue;
          }

          long first = digits.get(i);
          long second = digits.get(i+1);
          if(first <= second && works(digits,i,first)) result.add(first);

          else {
            result.add(first-1);
            flag = true;
          }

      }

      if (flag) result.add((long) 9);
      if (result.size() != digits.size()) result.add(digits.get(digits.size()-1));
      if (result.get(0) == 0) result.remove(0);

      String res = "";
      for (long d:result) res+=Long.toString(d);
      return res;
    }
  }

  public static boolean works(ArrayList<Long> digits, int pos, long ref){
    for(int i=pos+1; i<digits.size();i++){
      if(digits.get(i) > ref) return true;
      if(digits.get(i) < ref) return false;
    }
    return true;
  }
}
