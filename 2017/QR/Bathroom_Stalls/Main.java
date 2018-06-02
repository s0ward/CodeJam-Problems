public class Main{

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();
    for (int i = 1; i <= T; ++i) {
     long N = in.nextLong();
     long K = in.nextLong();
     System.out.println("Case #" + i + ": " + solve(N,K));
   }

   public static long solve(long N, long K){
     return 0;
   }

  /*

  0...0 

  5
  4 2            Case #1: 1 0
  5 2            Case #2: 1 0
  6 2            Case #3: 1 1
  1000 1000      Case #4: 0 0
  1000 1         Case #5: 500 499
  */
}
