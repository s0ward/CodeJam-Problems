import java.util.*;
import java.io.*;

public class Cookie{
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        double C = in.nextDouble();
        double F = in.nextDouble();
        double X = in.nextDouble();
        System.out.println("Case #" + i + ": " + solve(C,F,X));
    }
  }

  static String solve(double C, double F, double X){
    double k = Math.floor(X/C-1-2.0/F) + 1;
    double t = 0;

    if(k >= 1){
        for(int i=0;i<k; i++) t += C/(2+i*F);
        t += X/(2+k*F);
    }
    
    else t+= X/2;
    return new Double(t).toString();
  }
}
