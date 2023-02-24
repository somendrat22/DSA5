import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String p = br.readLine();
        Solution sol = new Solution();
        System.out.println(sol.numberOfOccurrences(s, p));
    }
}

class Solution {
    public int numberOfOccurrences(String s, String p) {
        int n = s.length();
        int m = p.length();
        int [][] dp = new int[s.length() + 1][p.length() + 1];

        for(int i = 0; i<=n; i++){
            dp[i][m] = 1;
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                char chS = s.charAt(i);
                char chP = p.charAt(j);
                if(chS == chP){
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                }else{
                    dp[i][j] = d[i + 1][j];
                }
            }
        }

        return dp[0][0];


    }
}