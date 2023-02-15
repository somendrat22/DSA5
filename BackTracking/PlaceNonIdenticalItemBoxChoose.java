import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int cb, int tb, boolean[] items, int itpsf, int ts, String asf){
	  
	  // if(itpsf == ts + 1){
		 //  System.out.println(asf); 
		 //  return;
	  // }
	  if(cb == tb + 1){
		  if(itpsf == ts){
			  	System.out.println(asf);
		  }
		  return;
	  }
	  
	  for(int i = 0; i<items.length; i++){
		if(items[i] == false){
			items[i] = true;
			permutations(cb + 1, tb, items, itpsf + 1, ts, asf + (i + 1));
			items[i] = false;
		}
	}
	  permutations(cb + 1, tb, items, itpsf, ts,  asf + 0);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new boolean[ritems], 0, ritems, "");
  }

}

// CB- current box
// TB - total box
// ritems- total no of items
// itpsf - items placed so far
// ts - total items
// asf - answer so far