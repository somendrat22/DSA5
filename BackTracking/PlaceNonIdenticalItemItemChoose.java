import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int ci, int ti){
	  if(ci == ti + 1){
		  for(int i = 0; i < boxes.length; i++){
			  System.out.print(boxes[i]);
		  }
		  System.out.println();
		  return;
	  }
    for(int i  = 0; i<boxes.length; i++){
		if(boxes[i] == 0){
			boxes[i] = ci;
			permutations(boxes, ci + 1, ti);
			boxes[i] = 0;
		}
	}
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int R = Integer.parseInt(br.readLine());
    permutations(new int[N], 1, R);
  }

}

//ti = total items
//ci = current item