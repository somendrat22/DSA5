
import java.util.*;
import java.lang.*;
import java.io.*;
class Solution{
     public static int countSubstrings(String str) {
       boolean [][] dp = new boolean[str.length()][str.length()];

       int count = 0;
       for(int dig = 0; dig<str.length(); dig++){
        for(int i = 0, j = dig; j < str.length(); j++, i++){
            char start = str.charAt(i);
            char end = str.charAt(j);
            if(dig == 0){
                dp[i][j] = true;
            }else if(dig == 1){
                if(start == end){
                    dp[i][j] = true;
                }
            }else{
                if(start == end){

                    dp[i][j] = dp[i + 1][j - 1];
                }
            }

            if(dp[i][j] == true){
                count++;
            }

        }
       }

       return count;
    }
}
/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(Solution.countSubstrings(str));
	}
}

