import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution {


    public static int tabulation(int [][] input){
        int n = input.length;
        int m = input[0].length;
        int [][] stoarge = new int[n][m];

        for(int i = n - 1; i>=0; i--){
            for(int j = m - 1; j>=0 ;j--){
                if(i == n - 1 && j == m - 1){
                    stoarge[i][j] = input[i][j];
                    continue;
                }

                int right = j + 1 < m ? stoarge[i][j + 1] : Integer.MAX_VALUE;
                int down = i + 1 < n ? stoarge[i + 1][j] : Integer.MAX_VALUE;

                stoarge[i][j] = Math.min(right, down) + input[i][j];

            }
        }

        return stoarge[0][0];
    }


	public static int minPathSum(int[][] input) {
		return tabulation(input);
	}


    public static int memo(int [][] input, int sr, int sc, int [][] stoarge){
        if(sr >= input.length || sc >= input[0].length){
            return Integer.MAX_VALUE;
        }
        if(sr == input.length - 1 && sc == input[0].length - 1){
            return input[sr][sc];
        }
        if(stoarge[sr][sc] != 0){
            return stoarge[sr][sc];
        }
        int right = memo(input, sr, sc + 1, stoarge);
        int down = memo(input, sr + 1, sc, stoarge);
        int min = Math.min(right, down);
        stoarge[sr][sc] = min + input[sr][sc];
        return min + input[sr][sc];
    }
}
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[][] take2DInput() throws IOException {
        String[] strRowsCols = br.readLine().trim().split("\\s");
        int mRows = Integer.parseInt(strRowsCols[0]);
        int nCols = Integer.parseInt(strRowsCols[1]);

        if (mRows == 0) {
            return new int[0][0];
        }


        int[][] mat = new int[mRows][nCols];

        for (int row = 0; row < mRows; row++) {
            String[] strNums; 
            strNums = br.readLine().trim().split("\\s");
            
            for (int col = 0; col < nCols; col++) {
                mat[row][col] = Integer.parseInt(strNums[col]);
            }
        }

        return mat;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] mat = take2DInput();
        System.out.println(Solution.minPathSum(mat));
    }
}