public class Permutation{
  static int n = 7;
  static int[] mp = new int[n];
  static boolean[] used = new boolean[n+1];

  public static void main(String[] args) {
    for(int i=0; i<n; i++) used[i] = false;
    permute(0);
  }

  static void permute(int pos){
    if (pos==n) {
      for(int i=0; i<n; i++) System.out.print(mp[i]);
      System.out.println();
      return;
    }
    else{
      for(int i=1; i<=n; i++) {
        if(!used[i]){
          mp[pos] = i;
          used[i] = true;
          permute(pos+1);
          used[i] = false;
        }
      }
    }
  }
}
