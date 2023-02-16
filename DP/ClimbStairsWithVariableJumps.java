import java.util.*;

class Solution {
    public int stairWays(int[] jump) {
        return tab(jump);
    }


    public int tab(int [] jump){
        int n = jump.length;
        int [] storage = new int[n + 1];
        storage[n] = 1;

        for(int i = n - 1; i >= 0; i--){
            int jumps = jump[i];
            int ways  = 0;
            for(int j = 1; j<=jumps; j++){
                ways += (i + j) <= n ? storage[i + j] : 0;
            }
            storage[i] = ways;
        }

        return storage[0];
    }

	public int memo(int [] jump, int currStair, int destStair, int [] storage){
        if(currStair > destStair){
            return 0;
        }
        if(currStair == destStair){
            return 1;
        }
        if(storage[currStair] != 0){
            return storage[currStair];
        }
        int ways  = 0;
        for(int j = 1; j<=jump[currStair]; j++){
            ways += memo(jump, currStair + j, destStair, storage);
        }
        storage[currStair] = ways;
        return ways;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int res = Obj.stairWays(arr);
        System.out.println(res);
        sc.close();
    }
}