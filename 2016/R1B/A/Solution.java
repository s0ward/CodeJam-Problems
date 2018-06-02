import java.util.*;
import java.io.*;

public class Solution {

  static String s;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      s = in.next();
      System.out.println("Case #" + i + ": " + solve());
    }
  }

  static String solve(){
    String res = "";
    int[] hist = new int[26];
    for (int i=0; i<26; i++) hist[i] = 0;
    char[] arr = s.toCharArray();
    for(char c: arr) hist[(int) (c-'A')]++;
    //for(int i=0; i<26; i++) System.out.print(hist[i]+" ");
    if(hist[25] != 0){
      int occ = hist[25];
      for(int i=0; i<occ; i++) res+="0";
      hist[25] = 0;
      hist[4] -= occ;
      hist[17] -= occ;
      hist[14] -= occ;
    }

    if(hist[22] != 0){
      int occ = hist[22];
      for(int i=0; i<occ; i++) res+="2";
      hist[22] = 0;
      hist[14] -= occ;
      hist[19] -= occ;
    }

    if(hist[20] != 0){
      int occ = hist[20];
      for(int i=0; i<occ; i++) res+="4";
      hist[20] = 0;
      hist[5] -= occ;
      hist[14] -= occ;
      hist[17] -= occ;
    }

    if(hist[23] != 0){
      int occ = hist[23];
      for(int i=0; i<occ; i++) res+="6";
      hist[23] = 0;
      hist[8] -= occ;
      hist[18] -= occ;
    }

    if(hist[6] != 0){
      int occ = hist[6];
      for(int i=0; i<occ; i++) res+="8";
      hist[6] = 0;
      hist[4] -= occ;
      hist[7] -= occ;
      hist[8] -= occ;
      hist[19] -= occ;
    }

    if(hist[5] != 0){
      int occ = hist[5];
      for(int i=0; i<occ; i++) res+="5";
      hist[5] = 0;
      hist[4] -= occ;
      hist[8] -= occ;
      hist[21] -= occ;
    }

    if(hist[18] != 0){
      int occ = hist[18];
      for(int i=0; i<occ; i++) res+="7";
      hist[18] = 0;
      hist[4] -= 2*occ;
      hist[13] -= occ;
      hist[21] -= occ;
    }

    if(hist[17] != 0){
      int occ = hist[17];
      for(int i=0; i<occ; i++) res+="3";
      hist[17] = 0;
      hist[4] -= 2*occ;
      hist[7] -= occ;
      hist[19] -= occ;
    }

    if(hist[14] != 0){
      int occ = hist[14];
      for(int i=0; i<occ; i++) res+="1";
      hist[14] = 0;
      hist[4] -= occ;
      hist[13] -= occ;
    }

    if(hist[8] != 0){
      int occ = hist[8];
      for(int i=0; i<occ; i++) res+="9";
    }


    char[] chars = res.toCharArray();
    Arrays.sort(chars);
    res = new String(chars);
    return res;
  }

}
