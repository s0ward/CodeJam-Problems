import java.util.*;
import java.io.*;

public class Pancakes{
  static char[] pancakes;
  static int count = 0;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      pancakes = in.next().toCharArray();
      count = 0;
      System.out.println("Case #" + i + ": " + solve());
    }
  }

  static int solve(){
    int pos = pancakes.length-1;
    while(pos>=0){
      if(pancakes[pos] == '-') {
        if(pancakes[0] == '+') flip(1);
        flip(pos+1);
        //printArray();
      }
      pos--;
    }
    return count;
  }

  static void flip(int n){
      for(int i=0; i<n/2; i++){
        char temp = pancakes[i];
        //System.out.println("pancakes["+i+"]:" + pancakes[i] + "invert():" + invert(pancakes[i]));
        //System.out.println("pancakes["+ (n-i-1) +"]:" + pancakes[n-i-1] + "invert():" + invert(pancakes[i]));
        pancakes[i] = pancakes[n-i-1];
        pancakes[n-i-1] = temp;
      }

      for(int i=0; i<n; i++) pancakes[i] = invert(pancakes[i]);
      count++;
  }

  static char invert(char s){
    return (s =='+') ? '-':'+';
  }

  static void printArray(){
    for(int i=0; i< pancakes.length; i++) System.out.print(pancakes[i] + " ");
    System.out.println();
  }

}
