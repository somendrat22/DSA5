import java.io.*;
import java.util.*;

class Main{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int M[][] = new int[n][m];
        for(int i = 0;i < n*m;i++){
            M[i/m][i%m] = sc.nextInt();
        }
        
        Solution ob = new Solution();
        System.out.println(ob.maxGold(n, m, M));
    }
} 

class Solution{
    static int maxGold(int n, int m, int M[][]){
        int [][] storage = new int[n][m];
        int max = 0;
        for(int i = 0 ; i<n; i++){
            max = Math.max(max, getMaxGold(i, 0, M, storage));
        }
        return max;
    }   

    public static int getMaxGold(int row, int col, int [][] grid, int [][] storage){
        if(row < 0 ||  row >= grid.length || col < 0 || col >= grid[0].length){
            return 0;
        }
        if(col == grid[0].length - 1){
            return grid[row][col];
        }
        if(storage[row][col] != 0){
            return storage[row][col];
        }
        int up = getMaxGold( row - 1, col + 1, grid, storage);
        int curr = getMaxGold(row, col + 1, grid, storage);
        int down =  getMaxGold(row + 1, col + 1, grid, storage);
        int max = Math.max(up, Math.max(curr, down));
        storage[row][col] = max + grid[row][col];
        return storage[row][col];
    }
}