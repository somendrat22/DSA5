import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next(), s2 = sc.next();
    sc.close();
    System.out.println(editDistance(s1, s2));
  }

  public static int editDistance(String s1, String s2) {
    
    int n = s1.length(); // source length;

    int m = s2.length(); // target length;

    int [][] dp = new int[n + 1][m + 1];

    for(int i = 0; i<n; i++){
        dp[i][0] = i;
    }

    for(int i = 0; i<m; i++){
        dp[0][i] = i;
    }

    for(int i =  1; i<=n; i++){
        for(int j = 1; j<=m ;j++){
            char chS = s1.charAt(i - 1);
            char chT = s1.charAt(j - 1);
            if(chS == chT){
                dp[i][j] = dp[i-1][j-1];
            }else{
                int insert = dp[i][j - 1];
                int delete = dp[i - 1][j];
                int replace = dp[i - 1][j - 1];

                int min = Math.min(insert, Math.min(delete, replace));

                dp[i][j] = min + 1;
            }
        }
    }

    return dp[n][m];

  }

}