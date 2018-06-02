import java.util.*;
import java.io.*;

public class Solution {
  static int N;
  static int[] V;


  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      N = in.nextInt();
      V = new int[N];
      for(int j=0; j<N; j++) V[j] = in.nextInt();
      System.out.println("Case #" + i + ": " + solve2());
    }
  }

  static String solve(){
    TroubleSort();
    int prev  = -1;
    for(int i=0; i<N; i++) {
      if(prev > V[i]) return new Integer(i-1).toString();
      prev = V[i];
    }
    return "OK";
  }

  static String solve2(){
    ArrayList<Integer> even = new ArrayList<>(N/2+1);
    ArrayList<Integer> odd = new ArrayList<>(N/2+1);

    for(int i=0; i<N; i++) {
      if(i%2==0) even.add(V[i]);
      else odd.add(V[i]);
    }

    //System.out.println("EVEN: " + even);
    //System.out.println("ODD: " + odd);

    Collections.sort(even);
    Collections.sort(odd);

    //System.out.println("EVEN: " + even);
    //System.out.println("ODD: " + odd);

    int prev = -1;
    int current = -2;
    for(int i=0; i<N;i++) {
      if(i%2==0){
        current = even.get(i/2);
      }
      else{
        current = odd.get(i/2);
      }

      if(current<prev) return new Integer(i-1).toString();
      prev = current;
    }
    return "OK";
  }

  static void TroubleSort(){
    boolean done = false;
    while(!done){
      done = true;
      for(int i=0; i < N - 2; i++){

        if(V[i] > V[i+2]){
          done = false;
          int temp = V[i];
          V[i] = V[i+2];
          V[i+2] = temp;
        }
      }
    }
  }
}
