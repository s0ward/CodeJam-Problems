import java.util.*;
import java.io.*;

public class Solution {


  static int N = 0;
  static int R = 0;
  static int O = 0;
  static int Y = 0;
  static int G = 0;
  static int B = 0;
  static int V = 0;

  public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
      for (int i=1;i<=T;i++) {
        N = in.nextInt();
        R = in.nextInt();
        O = in.nextInt();
        Y = in.nextInt();
        G = in.nextInt();
        B = in.nextInt();
        V = in.nextInt();
        System.out.println("Case #" + i +": " + solveLarge());
      }
    }


  static String solveLarge(){
    String strR = "";
    String strB = "";
    String strY = "";
    String tail = "";

    if(G>0){
      if(R < G+1) return "IMPOSSIBLE";
      for (int i=0; i<2*G+1;i++){
        if(i%2 == 0) strR+="R";
        else strR+="G";
      }
      R-=G+1;
      N-=2*G+1;
    }

    if(V>0){
      if(Y < V+1) return "IMPOSSIBLE";
      for (int i=0; i<2*G+1;i++){
        if(i%2 == 0) strR+="Y";
        else strR+="V";
      }
      Y-=V+1;
      N-=2*V+1;
    }

    if(O>0){
      if(B < O+1) return "IMPOSSIBLE";
      for (int i=0; i<2*G+1;i++){
        if(i%2 == 0) strR+="B";
        else strR+="O";
      }
      B-=O+1;
      N-=2*O+1;
    }

    /*if((strR != "" && strY != "") || (strB != "" && strY != "") || (strR != "" && strB != "")){
      tail = solveSmall(1);
    }
    */

    if(strR.equals("") && strY.equals("") && strB.equals("")) tail = solveSmall(0);
    else tail = solveSmall(1);

    char start = tail.charAt(0);
    char end = tail.charAt(tail.length()-1);

    if(start == 'R' &&  end=='Y') return strR+strY+strB+tail;
    else if(start == 'Y' &&  end=='B') return strR+tail+strY+strB;
    else return strR+strY+tail+strB;

  }

  static String solveSmall(int p){
    int r = R;
    int y = Y;
    int b = B;
    int colors[] = {R,Y,B};
    Arrays.sort(colors);

    if(colors[2]*2 > N+p) return "IMPOSSIBLE";
    else{

      if(colors[2] == R){
        String res = "";
        for(int i=0; i<N;i++){
          if(r != 0 && i%2 == 0){
              res+="R";
              r--;
            }

          else if(r != 0 && i%2 == 1) {
            if(y >= b) {
              res+= "Y";
              y--;
            }
            else{
              res+="B";
              b--;
            }
          }

          else {
            if(res.charAt((res.length()-1)) == 'R'){
              if(y>b) res+= "Y";
              else res+= "B";
            }
            else{
              if(res.charAt((res.length()-1)) != 'Y' && y > 0) res+="Y";
              else res+="B";
            }
          }
        }
        return res;
      }

      else if(colors[2] == Y){
        String res = "";
        for(int i=0; i<N;i++){
          if(y != 0 && i%2 == 0){
              res+="Y";
              y--;
            }

          else if(y != 0 && i%2 == 1) {
            if(r >= b) {
              res+= "R";
              r--;
            }
            else{
              res+="B";
              b--;
            }
          }

          else{
            if(res.charAt((res.length()-1)) == 'Y'){
              if(r>b) res+= "R";
              else res+= "B";
            }
            else{
              if(res.charAt((res.length()-1)) != 'R' && r > 0) res+="R";
              else res+="B";
            }
          }
        }
        return res;
      }

      else{
        String res = "";
        for(int i=0; i<N;i++){
          if(b != 0 && i%2 == 0){
              res+="B";
              b--;
            }

          else if(b != 0 && i%2 == 1) {
            if(r >= y) {
              res+= "R";
              r--;
            }
            else{
              res+="Y";
              y--;
            }
          }

          else{
            if(res.charAt((res.length()-1)) == 'B'){
              if(r>y) res+= "R";
              else res+= "Y";
            }

            else{
              if(res.charAt((res.length()-1)) != 'Y' && y > 0) res+="Y";
              else res+="R";
            }
          }
        }
        return res;
      }
    }
  }
}
