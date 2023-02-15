
import java.util.*;

class Solution {
    public static void coinChange(int[] coins, int amt){
        //Write your code here
        generatePermutations(new int[coins.length], coins, 0,"", amt);
    }

    public static void generatePermutations(int [] boxes, int [] coins, int idx, String asf, int amt){
        if(idx == coins.length){
            if(amt == 0){
                System.out.println(asf);
            }
            return;
        }

        if(amt == 0){
            System.out.println(asf);
            return;
        }

        if(amt < 0){
            return;
        }
        for(int i = 0; i<coins.length; i++){
                generatePermutations(boxes, coins, idx + 1, asf + coins[i] + " ", amt - coins[i]);
               
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();

        Solution Obj = new Solution();
        Obj.coinChange(coins, amt);
    }
}