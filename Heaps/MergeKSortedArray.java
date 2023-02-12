import java.io.*;
import java.util.*;

public class Main {

   public static class Pair implements Comparable<Pair>{
	   int val;
	   int liIdx;
	   int liNum;
	   Pair(int val, int liIdx, int liNum){
		   this.val = val;
		   this.liIdx = liIdx;
		   this.liNum = liNum;
	   }
	   public int compareTo(Pair o){
		   return this.val - o.val;
	   }
   }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
	  PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(int i = 0; i<lists.size() ; i++){
		  pq.add(new Pair(lists.get(i).get(0), 0, i));
	  }

	   while(pq.size() != 0){
		   Pair rem = pq.remove();
		   rv.add(rem.val);
		   int liIdx = rem.liIdx;
		   int liNum = rem.liNum;
		   if(lists.get(liNum).size() == liIdx + 1){
			   continue;
		   }
		   pq.add(new Pair(lists.get(liNum).get(liIdx + 1), liIdx + 1, liNum));

	   }

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}