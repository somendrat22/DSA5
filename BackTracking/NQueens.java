import java.util.*;

public class Main {
    static int totalConfiguration = 0;

    public static boolean isSafe(int row, int col, int [][] grid){
        int i = row - 1;
        int j = col - 1;
        while(i >= 0 && j >= 0){
            if(grid[i][j] == 1){
                return false;
            }
            i--;
            j--;
        }

        i = row - 1;
        j = col;
        while(i >= 0){
            if(grid[i][j] == 1){
                return false;
            }
            i--;
        }

        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < grid[0].length){
            if(grid[i][j] == 1){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
    public static int totalNQueens(int n) {
       placeQueen(new int[n][n], 0, n);
       return totalConfiguration;
    }

    public static void placeQueen(int [][] grid, int row, int n){
        if(row  == n){
            totalConfiguration++;
            return;
        }

        for(int col  = 0; col<n; col++){
            if(isSafe(row, col, grid)){
                grid[row][col] = 1;
                placeQueen(grid, row + 1, n);
                grid[row][col] = 0;
            }
        }
    }
    

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        System.out.println(totalNQueens(n));
    }
}