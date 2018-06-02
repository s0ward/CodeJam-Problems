import java.util.*;
import java.io.*;

public class PlayTheDragon{
  static int count = 0;
  static int H_d = 0;
  static int A_d = 0;
  static int H_k = 0;
  static int A_k = 0;
  static int B = 0;
  static int D = 0;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {
      count = 0;
      H_d = in.nextInt();
      A_d = in.nextInt();
      H_k = in.nextInt();
      A_k = in.nextInt();
      B = in.nextInt();
      D = in.nextInt();

      System.out.println("Case #" + i + ": " + minDefense());
    }
  }

  /*static int solveSmall(h_d, a_d, h_k, a_k){
    //If the knight dies
    if(h_k <= 0) return count;
    if(h_d <= 0) return -1;

    //Heal
    if (h_d <= a_k) {
      if (h_k > a_d) solveSmall(H_d - a_k, a_d, h_k, a_k);
      else solveSmall(h_d - a_k, a_d, h_k - a_d, a_k);
    }

    //Buff
    int buffGain = Math.ceil(H_k / A_d) - (Math.ceil(H_k / (A_d + B)) + 1);

    //Debuff
    int debuffGain = Math.ceil(H_d / A_k) - (Math.ceil(H_d / (A_k - D)) + 1);

    if (Math.ceil(H_k / A_d) > Math.ceil(H_k / (A_d + B)) + 1) {

    }
    //Debuff
    if (Math.ceil(H_d / A_k) < Math.ceil(H_d / (A_k - D)) + 1) {

    }

    //Attack
    else solveSmall(h_d - a_k, a_d, h_k - a_d, a_k);

  }
  */

  static int minAttacks(){
    int R = (int) Math.ceil((double) H_k / A_d);
    int min = (int) Math.ceil((double) H_k / A_d);
    for(int i = 0; i <= R; i++){
      int temp = (int) Math.ceil(((double) H_k / (A_d+i*B))+i);
      if(temp < min) min = temp;
    }
    return min;
  }

  static int minDefense(){
    int T = minAttacks()+(int) Math.ceil((double) H_d / A_k);
    int min = (int) Math.ceil((double) (T*A_k) / H_d);
    int R = (int) Math.ceil((double) (T*A_k) / H_d);
    System.out.println("T: " + T + " D: " + min);
    for(int j=0; j<10;j++){
      for(int i = 0; i<=R; i++){
        int temp = (int) Math.ceil((double) (T*(A_k-i*D)) / H_d + i);
        if(temp < min && temp >= 0) min = temp;
      }
      T = minAttacks() + min;
      System.out.println("T: " + T + " D: " + min);
    }

    return min;
  }
}
