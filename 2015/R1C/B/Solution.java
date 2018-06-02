import java.util.*;
import java.io.*;

public class Solution {

  static int K;
  static int L;
  static int S;
  static String k;
  static String l;
  static char[] mp;
  static int res=0;
  static int perms=0;


  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      K = in.nextInt();
      L = in.nextInt();
      S = in.nextInt();
      k = in.next();
      l = in.next();
      mp = new char[S];
      res=0;
      perms=0;
      System.out.println("Case #" + i + ": " + solve());
      //System.out.println("Case #" + i + ": " + "PAL: "+palindrome(k) + " MAX: "+ maxBanans());
    }
  }

  static double solve(){
    generate(0);
    return (maxBanans() - (double) res/perms);
    //System.out.println("RES:"+res+" PERMS:"+perms);
    //return (double) res/perms;
  }

  static int maxBanans(){
    int p = palindrome(l);
    boolean flag = false;

    int[] hist = new int[26];
    for (int i=0; i<26; i++) hist[i] = 0;
    char[] arr = k.toCharArray();
    for(char c: arr) hist[(int) (c-'A')]++;

    for(int i=0; i<l.length(); i++){
      if (hist[(int) (l.charAt(i)-'A')] == 0) return 0;
    }
    //System.out.println("S:"+S+" L:"+L+" p:"+p);
    return (S-L)/(L-p) + 1;
  }

  static int palindrome(String s){
    if(s.length() == 1) return 0;

    char[] chars = s.toCharArray();
    if(s.length() == 2) return chars[0] == chars[1] ? 1:0;

    int count  = 0;
    for(int i=0; i<s.length()/2+1;i++){
        if(chars[i] == chars[s.length()-1-i]) count++;
        else break;
    }
    return count;
  }

  static int probability(String s){

    return 0;
  }

  static void generate(int length){
    //  System.out.println(length);
    if(length == S) {
      res+=reps();
      //System.out.println(new String(mp)+": "+reps());
      perms+=1;
      //System.out.println("NEW RESULT: "+new String(mp));
      return;
    }

    for(int i=0; i<K; i++) {
      mp[length] = k.charAt(i);
      generate(length+1);
    }
  }

  static int reps(){
    int count=0;
    //System.out.println("S:"+S+" L:"+L);
    for(int i=0; i<=S-L; i++){
      if(mp[i] != l.charAt(0)) continue;
      //System.out.println("START");
      for(int j=i; j<i+L; j++){
        //System.out.println(mp[j]+" ? "+l.charAt(j-i));
        if(mp[j] != l.charAt(j-i)) break;
        if(j==(i+L-1)) {
          count++;
          //System.out.println("i:"+i+" j:"+j);
        }
      }
    }
    return count;
  }

}
