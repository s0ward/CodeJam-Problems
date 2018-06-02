import java.util.*;
import java.io.*;

public class Minesweeper{
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int R = in.nextInt();
        int C = in.nextInt();
        int M = in.nextInt();
        System.out.println("Case #" + i + ": " + solve(R,C,M));
    }
  }

  static String solve(int R, int C, int M){

      if(R*C-M<4 && R!=1 && C!=1) return "Impossible";

      int empty_left = R*C - M;
      int[][] board = new int[R][C];
      int s = (int) Math.ceil(Math.sqrt(empty_left));

      for(int i=0; i<R; i++)
        for(int j=0; j<C; j++)
          board[i][j] = 1;

      board[0][0] = 2;
      empty_left--;

      for(int i=0; i<Math.min(R,s); i++){
        for(int j=0; j<Math.min(C,s); j++){
          if(empty_left <= 0) break;
          if(board[i][j] == 1){
            board[i][j] = 0;
            empty_left--;
          }
        }
      }

      return printBoard(board);
  }

  static String printBoard(int[][] board){
    String res = "\n";
    int rows = board.length;
    int cols = board[0].length;

    for(int i=0; i<rows; i++){
      for(int j=0; j<cols; j++){
        if(board[i][j] == 0) res+=".";
        if(board[i][j] == 1) res+="*";
        if(board[i][j] == 2) res+="c";
      }
      res+="\n";
    }
    return res;
  }

}
