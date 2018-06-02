import java.util.*;
import java.io.*;

public class Dijkstra{
  static final String[][] Q =  new String[][]{
      {"1","i","j","k"},
      {"i","-1","k","-j"},
      {"j","-k","-1","i"},
      {"k","j","-i","-1"}
    };

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int L = in.nextInt();
      long X = in.nextLong();
      String str = in.next();
      System.out.println("Case #" + i + ": " + solve(L,X,str));
    }
  }

  static String solve(int L, long X, String str){
    String product = "1";

    boolean containsI=false;
    boolean containsJ=false;

    int i = 0;

    while(true) {

      product = multiply(product,str.substring(i%L,i%L+1));

      if(!containsI){
        if(i >= 4*L || i >= X*L) return "NO";
        if(product.equals("i")) {
          containsI = true;
          product = "1";
        }
      }

      else if(!containsJ){
        if(i >= 8*L || i >= X*L) return "NO";
        if(product.equals("j")) {
          containsJ = true;
          product = "1";
        }
      }

      else{
        if((X*L-i-1)%(4*L) == 0 || i== X*L-1 ) {
          if (product.equals("k")) return "YES";
          return "NO";
        }
      }

      i++;
    }
  }

  static String multiply(String str1, String str2){
    String product = "";

    int str1_cord = -1;
    int str2_cord = -1;

    switch(str1.charAt(str1.length()-1)) {
      case '1': str1_cord = 0;
      break;
      case 'i': str1_cord = 1;
      break;
      case 'j': str1_cord = 2;
      break;
      case 'k': str1_cord = 3;
      break;
    }

    switch(str2.charAt(str2.length()-1)) {
      case '1': str2_cord = 0;
      break;
      case 'i': str2_cord = 1;
      break;
      case 'j': str2_cord = 2;
      break;
      case 'k': str2_cord = 3;
      break;
    }

    if((str1.length()+str2.length())%2 == 0) product = Q[str1_cord][str2_cord];

    else {
      if(Q[str1_cord][str2_cord].length() == 1) product = "-"+Q[str1_cord][str2_cord];
      else product = Q[str1_cord][str2_cord].substring(1);
    }

    return product;
  }
}
