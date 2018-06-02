import java.util.*;
import java.io.*;

public class DeceitfulWar{
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int N = in.nextInt();
        double[] Naomi = new double[N];
        double[] Ken = new double[N];
        for(int j=0; j<N; j++) Naomi[i]= in.nextDouble();
        for(int j=0; j<N; j++) Ken[i]= in.nextDouble();
        System.out.println("Case #" + i + ": " + solve(Naomi,Ken));
    }
  }


  static String solve(double[] Naomi, double[] Ken){
    return null;
  }


}



Naomi 0.5
Ken 0.6

Naomi 0.7 0.2
Ken 0.8 0.3

Naomi 0.5 0.1 0.9
Ken 0.6 0.4 0.3

Naomi 0.186 0.389 0.907 0.832 0.959 0.557 0.300 0.992 0.899
Ken 0.916 0.728 0.271 0.520 0.700 0.521 0.215 0.341 0.458





Naomi 0.186 0.300 0.389 0.557 0.832 0.899 0.907 0.959 0.992
Ken 0.215 0.271 0.341 0.458 0.520 0.521 0.700 0.728 0.916

0.300 0.389 0.557 0.832 0.899 0.907 0.959 0.992
0.215 0.271 0.341 0.458 0.520 0.521 0.700 0.728

0.300 0.389 0.557 0.832 0.899 0.907 0.959 0.992
0.215 0.271 0.341 0.458 0.520 0.521 0.700 0.728

0.2 0.7
0.3 0.8

0.1 0.5 0.9
0.3 0.4 0.6





Naomi 0.60 0.73 0.77 0.78 0.81 0.84 0.88 0.90 0.93 0.99
Ken 0.04 0.14 0.15 0.17 0.26 0.27 0.31 0.40 0.51 0.57

1 5 10
2 8 15

Naomi 0.07 0.36 0.42 0.58 0.67 0.80 0.84
Ken 0.20 0.31 0.38 0.60 0.69 0.76 0.87


Naomi [|a             b|]
Ken [      |a          b|   K  ]


Naomi [       |a       b|       ]
Ken |a      b|

1 100 200 1000
700 800 850 900


1 100 400 800 1600
2 300 500 900 1400

N    K   K   N   K   N
0.1 0.3 0.4 0.5 0.6 0.9


N K K N K N N K N K K N N K


1
N 0.5
K 0.6
N K --> 0

2
N 0.7 0.2
K 0.8 0.3
N K N K --> 1

3
N 0.5 0.1 0.9
K 0.6 0.4 0.3
N K K N K N --> 2

9
N [0.186] [0.389] [0.907] [0.832] [0.959] [0.557] [0.300] [0.992] [0.899]
K [0.916] [0.728] [0.271] [0.520] [0.700] [0.521] [0.215] [0.341] [0.458]

N K K N K N K K K N K K N N N K N N --> 8

Count the leading N-s (let's say they are l) and subtract them from N. Result: N-l;


Old strategy:
