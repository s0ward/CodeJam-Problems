import java.util.*;
import java.io.*;

public class IHP{
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int D = in.nextInt();
      ArrayList<Integer> list = new ArrayList<>(D);
      for(int j=0; j<D;j++) list.add(in.nextInt());
      System.out.println("Case #" + i + ": " + solveSmall(list));
    }
  }

  static int _solveSmall(List<Integer> list, int count){
    if(list.size() == 0) return count;

    List<Integer> normalList = new ArrayList<>(list);
    for(int i=0; i<normalList.size(); i++){
      int element = normalList.get(i);
      if(element == 1) normalList.remove(i--);
      else normalList.set(i, element-1);
    }

    int max = Collections.max(list);
    if(max <= 3) return _solveSmall(normalList,count+1);

    else{
    int index = list.indexOf(max);
    int firstPlate = 0;
    int secondPlate = 0;
    switch(max){
      case 4:
      firstPlate = 2;
      secondPlate = 2;
      break;
      case 5:
      firstPlate = 3;
      secondPlate = 2;
      break;
      case 6:
      firstPlate = 3;
      secondPlate = 3;
      break;
      case 7:
      firstPlate = 4;
      secondPlate = 3;
      break;
      case 8:
      firstPlate = 4;
      secondPlate = 4;
      break;
      case 9:
      firstPlate = 6;
      secondPlate = 3;
      break;
    }

    List<Integer> specialList = new ArrayList<>(list);
    specialList.remove(index);
    specialList.add(firstPlate);
    specialList.add(secondPlate);

    return Math.min(_solveSmall(normalList, count+1),_solveSmall(specialList, count+1));
    }
  }

  static String solveSmall(List<Integer> list){
    return new Integer(_solveSmall(list,0)).toString();
  }
}
