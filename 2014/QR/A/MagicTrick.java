import java.util.*;
import java.io.*;

public class MagicTrick{
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int row1 = in.nextInt();
      int[] first = new int[4];
      int count = 0;

      for(int j=0; j<16; j++){
        int temp = in.nextInt();
        if(j >= (row1-1)*4 && j < row1*4) {
          first[count] = temp;
          count+=1;
        }
      }

      int row2 = in.nextInt();
      int[] second = new int[4];
      count = 0;

      for(int j=0; j<16; j++){
        int temp = in.nextInt();
        if(j >= (row2-1)*4 && j < row2*4) {
          second[count] = temp;
          count+=1;
        }
      }
      System.out.println("Case #" + i + ": " + solve(first,second));
    }
  }

  static String solve(int[] first, int[] second){
    ArrayList<Integer> cards = new ArrayList<Integer>(4);
    int[] hist = new int[17];

    for(int i=0; i<17; i++) hist[i] = 0;

    for(int i=0; i<4; i++) {
      hist[first[i]]+=1;
      hist[second[i]]+=1;
    }

    for(int i=0; i<17; i++) {
      if(hist[i] == 2) cards.add(i);
    }

    switch(cards.size()){
      case 0: return "Volunteer cheated!";
      case 1: return new Integer(cards.get(0)).toString();
      case 2: return "Bad magician!";
      case 3: return "Bad magician!";
      case 4: return "Bad magician!";
    }

    return "IMPOSSIBLE";
  }
}
