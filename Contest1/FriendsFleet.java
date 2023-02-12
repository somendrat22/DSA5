import java.util.*;

class Solution{
        public static void getCollisionTimes(int[][] a) {
          // Your code here
          int n = a.length;
          double [] res = new double[a.length];
          Stack<Integer> st = new Stack<>();
          for(int i = n - 1; i>=0 ; i--){
            res[i] = -1.0;
            int p1 = a[i][0]; // position of curr car
            int s1 = a[i][1]; // speed of curr car
            while(st.size() > 0 ){
                int closestIdx = st.peek();
                int p2 = a[closestIdx][0];
                int s2 = a[closestIdx][1];
                double time = (p2 - p1)/((s1- s2)*1.0);
                if(s1 <= s2 || (time >= res[closestIdx] && res[closestIdx] > -1)){
                    st.pop();
                }else{
                    break;
                }
            }

            if(st.size() > 0 ){
                int closestIdx = st.peek();
                int p2 = a[closestIdx][0];
                int s2 = a[closestIdx][1];
                double time = (p2 - p1)/((s1- s2)*1.0);
                res[i] = time;
            }

            st.push(i);
          }

		  for(int i = 0; i<res.length; i++){
			  System.out.print(String.format("%.3f", res[i]) + " ");
		  }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                cars[i][j] = sc.nextInt();
            }
        }
        Solution.getCollisionTimes(cars);
    }
}
