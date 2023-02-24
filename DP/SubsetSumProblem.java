import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int sum = Integer.parseInt(line[1]);
        int[] arr = new int[n];
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        Solution sol = new Solution();
        Boolean ans = sol.subsetSum(arr, n, sum);
        if(ans) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

class Solution {
    public boolean subsetSum(int[] arr, int n, int sum) {
        Boolean [][] storage = new Boolean[n][sum + 1];
        return isSubsetAvailable(arr, n, sum, storage);
    }



    public boolean isSubsetAvailable(int [] arr, int idx, int sum, Boolean [][] storage){
        if(sum < 0){
            return false;
        }
        if(sum == 0){
            return true;
        }
        if(idx == arr.length){
            if(sum == 0){
                return true;
            }
            return false;
        }
        if(storage[idx][sum] != null){
            return storage[idx][sum];
        }
        boolean inc = isSubsetAvailable(arr, idx + 1, sum - arr[idx], storage);
        boolean exc = isSubsetAvailable(arr, idx + 1, sum, storage);
        storage[idx][sum] = inc || exc; 
        return inc || exc;
    }
}