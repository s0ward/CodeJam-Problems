import java.util.*;
import java.io.*;

public class Ratatouille{

  static class Interval{
    int start;
    int end;

    Interval(int start, int end){
          this.start = start;
          this.end = end;
    }

    boolean intersects(Interval i){
      Interval first = (this.start <= i.start) ? this:i;
      Interval second = (first == this) ? i:this;
      if(second.start <= first.end) return true;
      return false;
    }

    public String toString(){
      return "["+this.start+","+this.end+"]";
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {
      int N = in.nextInt(); //Number of ingredients
      int P = in.nextInt(); //Number of packages of each ingredient
      int[] R = new int[N]; //Number of grams needed of each ingredient i
      int[][] Q = new int[N][P]; //The quantity, in grams, in the j-th package of the i-th ingredient

      for(int j = 0; j < N; j++) R[j] = in.nextInt();
      for(int j = 0; j < N; j++){
        for(int k = 0; k < P; k++){
          Q[j][k] = in.nextInt();
        }
      }
      System.out.println("Case #" + i + ": "+solveSmall(reduce(Q,R)));
      //System.out.println("_________________________________");
    }
  }

  static Interval findK(int T, int R){
      ArrayList<Integer> possibleK = new ArrayList<Integer>();

      double lowerBound = (10.0/11.0)*(((double) T)/((double) R));
      double upperBound = (10.0/9.0)*(((double) T)/((double) R));

      if(Math.floor(lowerBound) != lowerBound) lowerBound = Math.floor(lowerBound) + 1;
      if(Math.floor(upperBound) != upperBound) upperBound = Math.floor(upperBound);

      if(upperBound < lowerBound) return new Interval(-1,-1);
      return new Interval((int) lowerBound, (int) upperBound);
  }

  static Interval[][] reduce(int[][] Q, int[] R){
      int rows = Q.length;
      int columns = Q[0].length;
      Interval[][] reduced = new Interval[rows][columns];

      for(int i=0; i<rows;i++){
        for(int j=0; j<columns;j++) reduced[i][j] = findK(Q[i][j], R[i]);
      }

      return reduced;
  }

  static int solveSmall(Interval[][] ints){
      int rows = ints.length;
      int columns = ints[0].length;
      int count = -1;

      if(rows==1){
        count = 0;
        for(int j=0; j<columns;j++){
          if(ints[0][j].start != -1) count++;
        }
        return count;
      }

      if(rows==2){
        int maxCount = 0;
        count = 0;
        int[] base = new int[columns];
        for (int i=0; i<columns; i++) base[i] = i;

        for(int[] perm: permute(base)){
          count = 0;

          for(int i=0; i<columns; i++){
              if(ints[0][i].intersects(ints[1][perm[i]]) && ints[0][i].start != -1 && ints[1][perm[i]].start != -1) count++;
          }
          
          if(count>maxCount) maxCount = count;
        }
        return maxCount;
      }
      return -1;
  }

 static ArrayList<int[]> permute(int[] arr){
      ArrayList<int[]> permutations = new ArrayList<int[]>();
      permuteHelper(arr, 0, permutations);
      return permutations;
  }

 static void permuteHelper(int[] arr, int index, ArrayList<int[]> permutations){
      if(index >= arr.length - 1){ //If we are at the last element - nothing left to permute
        permutations.add(arr.clone());
        return;
      }

      for(int i = index; i < arr.length; i++){ //For each index in the sub array arr[index...end]

          //Swap the elements at indices index and i
          int t = arr[index];
          arr[index] = arr[i];
          arr[i] = t;

          //Recurse on the sub array arr[index+1...end]
          permuteHelper(arr, index+1, permutations);

          //Swap the elements back
          t = arr[index];
          arr[index] = arr[i];
          arr[i] = t;
      }
  }


    static void printMatrix(Interval[][] M){
        int rows = M.length;
        int columns = M[0].length;

        for(int i=0; i<rows;i++){
          for(int j=0; j<columns;j++){
            System.out.print(M[i][j]);
          }
          System.out.println();
        }
    }

}
