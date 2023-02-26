import java.util.*;

class Solution {
    @SuppressWarnings("unchecked")
    public int thanosTelepath(int[][] edges, int[] patience) {
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
       for(int i =0; i<patience.length; i++){
            graph.add(new ArrayList<>());
       }

       for(int i =0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
       }


       int d = 0;
       int [] dist = new int[patience.length];
       for(int i = 0; i<dist.length; i++){
        dist[i] = -1;
       }
       LinkedList<Integer> q = new LinkedList<>();
       q.addLast(0);

       while(q.size() != 0){
         int  size = q.size();
         while(size != 0){
            int rem = q.removeFirst();
            if(dist[rem] != -1){
                continue;
            }
            dist[rem] = d;
            for(int nbr : graph.get(rem)){
                q.addLast(nbr);
            }
            size--;
         }
         d++;
       }
       int max = 0;
       for(int i = 0; i<patience.length; i++){
            int recieveTime = 2*dist[i];
            int shutOffTime = recieveTime - 1;
            int lastMssgSentTime = (shutOffTime/patience[i])*patience[i];
            int totalExecutionTime = lastMssgSentTime + recieveTime;
            max = Math.max(max, totalExecutionTime);
       }




      return max + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] edges = new int[n][2];
        for (int i = 0; i < n; i++) {
        edges[i][0] = sc.nextInt();
        edges[i][1] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] patience = new int[m];
        for (int i = 0; i < m; i++) {
        patience[i] = sc.nextInt();
        }
        sc.close();
        
        Solution Obj = new Solution();
        System.out.println(Obj.thanosTelepath(edges,patience));

    }
}