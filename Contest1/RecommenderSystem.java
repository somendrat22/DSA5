import java.util.*;

class Solution {
    public class Pair implements Comparable<Pair>{
        int freq;
        String str;
        Pair(String str, int freq){
            this.str = str;
            this.freq = freq;
        }

        public int compareTo(Pair o){
            if(this.freq == o.freq){
                return this.str.compareTo(o.str);
            }else{
                return o.freq - this.freq;
            }
        }

    }
    public ArrayList<String> RecommendWords(ArrayList<String> wordDict, int k) {
        // Write your code here

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        HashMap<String, Integer> map = new HashMap<>();
        for(String str : wordDict){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(String str : map.keySet()){
            int freq = map.get(str);
            pq.add(new Pair(str, freq));
        }
        ArrayList<String> ans = new ArrayList<>();
        while(pq.size() > 0 && k != 0){
            Pair rem = pq.remove();
            ans.add(rem.str);
			k--;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        ArrayList<String> w = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            String t = sc.next();
            w.add(t);
        }
	    Solution Obj = new Solution();
        ArrayList<String> ans = Obj.RecommendWords(w, k);
        for(String a : ans) {
            System.out.println(a);
        }
    }
}