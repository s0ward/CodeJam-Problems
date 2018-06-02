import java.util.Scanner;

public class Solution {
  static boolean[][] orchard = new boolean[100][100];
  static int current = -1;

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      for(int i = 0; i < 100; i++)
        for(int j = 0; j < 100; j++)
          orchard[i][j] = false;
      current = 10;
      int A = input.nextInt();
      solve(input, A);
    }
  }

  public static void solve(Scanner input, int A) {
    int i = -1;
    int j = -1;

    do{
        System.out.println("10 "+current);
        i = input.nextInt();
        j = input.nextInt();
        //System.err.println("I: "+i+"J: "+j);
        orchard[i][j] = true;
        if(isComplete(10, current)) current+=3;

      }  while(!(i == 0 && j == 0));
  }

  public static boolean isComplete(int i, int j){
    return
    orchard[i-1][j-1] && orchard[i-1][j] && orchard[i-1][j+1] &&
    orchard[i][j-1] && orchard[i][j] && orchard[i][j+1] &&
    orchard[i+1][j-1] && orchard[i+1][j] && orchard[i+1][j+1];
  }
}
