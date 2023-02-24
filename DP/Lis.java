import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; ++i){
            array[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        System.out.println(ob.longestIncreasingSubsequence(n,array));
    } 
} 

class Solution 
{


    public static int lis(int [] arr){
        int [] storage = new int[arr.length];
        int ans = 0;
        for(int i = 0; i<arr.length; i++){
            int lo = 0;
            int hi = ans;
            while(lo < hi){
                int mid = lo + (hi - lo)/2;
                if(storage[mid] < arr[i]){
                    lo = mid + 1;
                }else{
                    hi = mid;
                }
            }
            storage[lo] = arr[i];
            if(lo == ans){
                ans++;
            }
        }

        return ans;
    }
    static int longestIncreasingSubsequence(int size, int a[])
    {
        int [] storage = new int[size];

        for(int i = 0; i<size; i++){
            int max = 0;
            for(int j = i - 1; j >= 0; j--){
                if(a[j] < a[i]){ // ith element can come behind the jth element
                    max = Math.max(storage[j], max);
                }
            }
            storage[i] = max + 1;
        }
        int max = 0;
        for(int i = 0; i<size; i++){
            max = Math.max(max, storage[i]);
        }

        return max;
    }
} 