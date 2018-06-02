import java.util.*;
import java.io.*;

public class Solution {

  static int C;
  static int D;
  static int V;
  static ArrayList<Integer> denoms;
  static int cs = 0;
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      C = in.nextInt();
      D = in.nextInt();
      V = in.nextInt();
      denoms = new ArrayList<Integer>(D);
      cs = i;
      for(int j=0; j<D; j++) denoms.add(in.nextInt());

      System.out.println("Case #" + i + ": " + solve1());
    }
  }

  static int solve(){
    int res = 0;
    while(coverage() != V){
      res++;
      for(int i=0; i <= V; i++) {
        if(!denoms.contains((int) Math.pow(2,i))) {
          denoms.add((int) Math.pow(2,i));
          break;
        }
      }
    }
    return res;
  }


  static int solve1(){
    int res = 0;
    while(coverage1() != -1){
      denoms.add(coverage1());
      res++;
    }
    return res;
  }

  static int sum (String s){
    int sum = 0;
    for(int i=0; i<s.length(); i++) if (s.charAt(i) == '1') sum+=denoms.get(i);
    return sum;
  }

  static int coverage(){
      int count = 0;
      int[] hist = new int[V+1];
      for(int i=0; i<V+1; i++) hist[i]=0;

      for(int i=1; i<(int) Math.pow(2,denoms.size()); i++){
        if(count == V) return count;
        String s = Integer.toBinaryString(i);
        while(s.length() != denoms.size()) s = "0"+s;
        if(sum(s) <= V) {
          if(hist[sum(s)] == 0) count++;
          hist[sum(s)] = 1;
        }
        System.out.println("Denoms:"+denoms+" String:"+s+" Sum:"+sum(s)+" Case:"+cs);
      }
      return count;
  }

  static int coverage1(){
      int count = 0;
      int[] hist = new int[V+1];
      for(int i=0; i<V+1; i++) hist[i]=0;

      for(int i=1; i<(int) Math.pow(2,denoms.size()); i++){
        if(count == V) return -1;
        String s = Integer.toBinaryString(i);
        while(s.length() != denoms.size()) s = "0"+s;
        if(sum(s) <= V) {
          if(hist[sum(s)] == 0) count++;
          hist[sum(s)] = 1;
        }
        //System.out.println("Denoms:"+denoms+" String:"+s+" Sum:"+sum(s)+" Case:"+cs);
      }

      for(int i=1; i<V+1; i++) {
        if(hist[i] == 0) return i;
      }

      return -1;
  }

}
