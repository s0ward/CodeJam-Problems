import java.util.*;
import java.io.*;
public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      double A = in.nextDouble();
      System.out.println("Case #" + i + ": ");
      solve(A);
    }
  }

  static void solve(double A){
    double angle = Math.acos(A/Math.sqrt(2));
    double rotation = angle - Math.PI/4;
    //double cosBeta = Math.cos(angle);
    //double sinBeta = Math.sin(angle);


    //System.out.println("Rotation: " + Math.toDegrees(rotation));

    double red_x = 0.0;
    double red_y = 0.5;
    double green_x = 0.5;
    double green_y = 0.0;
    double blue_x = 0.0;
    double blue_y = 0.0;

    double red_x_new = red_x*Math.cos(rotation) - red_y*Math.sin(rotation);
    double red_y_new = red_x*Math.sin(rotation) + red_y*Math.cos(rotation);

    double green_x_new = green_x*Math.cos(rotation) - green_y*Math.sin(rotation);
    double green_y_new = green_x*Math.sin(rotation) + green_y*Math.cos(rotation);

    System.out.println(red_x_new + " " + red_y_new + " 0.0");
    System.out.println(green_x_new + " " + green_y_new + " 0.0");
    System.out.println(blue_x+ " " + blue_y + " 0.5");

    //double cosBeta = 1/A;
    //double sinBeta = Math.sqrt(1.0-cosBeta*cosBeta);

    //double X = 0.5*cosBeta;
    //double Y = 0.5*sinBeta;
    //System.out.println(X+" "+(-Y)+" 0.0");
    //System.out.println(Y+" "+X+" 0.0");
    //System.out.println("0.0 0.0 0.5");
  }
}
