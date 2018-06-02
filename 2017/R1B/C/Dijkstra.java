public class Dijkstra{

  static final int MAXN = 100;
  static final int MAX_VALUE = 10000;
  static final int NO_PARENT = -1;
  static  int n = 10;
  static  int s = 1;
  static  double[][] A = new double[][] {
    {0,23,0,0,0,0,0,8,0,0},
    {23,0,0,3,0,0,34,0,0,0},
    {0,0,0,6,0,0,0,25,0,7},
    {0,3,6,0,0,0,0,0,0,0},
    {0,0,0,0,0,10,0,0,0,0},
    {0,0,0,0,10,0,0,0,0,0},
    {0,34,0,0,0,0,0,0,0,0},
    {8,0,25,0,0,0,0,0,0,30},
    {0,0,0,0,0,0,0,0,0,0},
    {0,0,7,0,0,0,0,30,0,0}
  };

  Dijkstra(double[][] A){
    this.A = A;
    this.n = A.length;
  }

  static int[] T = new int[MAXN];
  static double[] d = new double[MAXN];
  static int[] pred= new int[MAXN];

  static void dijkstra(int s){
    for(int i=0; i<n; i++){
      if(A[s][i] == 0){
        d[i] = MAX_VALUE;
        pred[i] = NO_PARENT;
      }
      else{
        d[i] = A[s][i];
        pred[i] = s;
      }
    }

    for(int i=0; i<n; i++) T[i] = 1;
    T[s] = 0;
    pred[s] = NO_PARENT;

    while(true){
      int j = NO_PARENT;
      double di = MAX_VALUE;

      for(int i=0; i<n; i++){
        if(T[i] != 0 && d[i] < di){
          di = d[i];
          j = i;
        }
      }

      if (NO_PARENT == j) break;
      T[j] = 0;

      for(int i=0; i<n; i++){
        if (T[i] != 0 && A[j][i] != 0){
          if(d[i] > d[j] + A[j][i]){
            d[i] = d[j] + A[j][i];
            pred[i] = j;
            }
          }
        }
      }
    }

  /*static void printPath(int s, int j){
    if(pred[j] != s) printPath(s, pred[j]);
    System.out.print((j+1) +  " ");
  }

  static void printResult(int s){
    for(int i=0; i<n; i++){
      if (i != s) {
        if (d[i] == MAX_VALUE)
          System.out.println("No path between " +(s+1)+" and "+(i+1));
        else{
          System.out.print("Minimal path from " + (s+1) + " to " + (i+1) +": "+(s+1)+" ");
          printPath(s, i);
          System.out.print(", path length: "+d[i]+"\n");
        }
      }
    }
  }*/

  public static String solve() {
    dijkstra(s-1);
    return new Double(d[n-1]).toString();
  }
}
