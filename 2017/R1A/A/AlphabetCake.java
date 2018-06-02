import java.util.*;
import java.io.*;

public class AlphabetCake {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {
      int R = in.nextInt();
      int C = in.nextInt();
      char[][] cake = new char[R][C];
      for (int j = 0;j < R; ++j){
        char[] line = in.next().toCharArray();
        for (int c=0 ; c<C; c++){
          cake[j][c] = line[c];
        }
      }

      solve(cake,R,C);

      System.out.println("Case #" + i +":");
      for(int k=0;k<R;k++){
        for(int l=0;l<C;l++){
          System.out.print(cake[k][l]);
        }
        System.out.println();
      }
    }
  }
  static void solve(char[][] arr, int R, int C){

    for(int r=0;r<R;r++) fillRow(r,arr,C);
    for(int c=0;c<C;c++) fillColumn(c,arr,R);
  }

  static boolean fillRow(int row, char[][] arr, int R){
    int firstPos = -1;
    char firstChar = ' ';

    for(int i=0; i<R; i++){
      if (arr[row][i] != '?'){
        firstPos = i;
        firstChar = arr[row][i];
        break;
      }
    }

    if (firstPos == -1) return false;

    for(int i=0; i<=firstPos; i++){
      arr[row][i] = firstChar;
    }

    char currentChar = firstChar;

    for(int i=firstPos+1; i<R ; i++){
      if(arr[row][i] == '?') arr[row][i] = currentChar;
      currentChar = arr[row][i];
    }
    return true;
  }

  static boolean fillColumn(int column, char[][] arr, int C){
    int firstPos = -1;
    char firstChar = ' ';

    for(int i=0; i<C; i++){
      if (arr[i][column] != '?'){
        firstPos = i;
        firstChar = arr[i][column];
        break;
      }
    }

    if (firstPos == -1) return false;

    for(int i=0; i<=firstPos; i++){
      arr[i][column] = firstChar;
    }

    char currentChar = firstChar;

    for(int i=firstPos+1; i<C ; i++){
      if(arr[i][column] == '?') arr[i][column] = currentChar;
      currentChar = arr[i][column];
    }
    return true;
  }

}

/*
*/
