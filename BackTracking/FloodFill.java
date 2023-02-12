package BackTracking;

publicimport java.util.*;

public class Main {
    public static void FloodFill(int[][] w, int x, int y, int c) {
        if(x < 0 || y <  0 || x >= w.length || y >= w[0].length || w[x][y] != c || w[x][y]  != 0){
            return;
        }
        w[x][y] = c;
        FloodFill(w,  x - 1, y, c);
        FloodFill(w, x, y + 1, c);
        FloodFill(w,x + 1, y, c);
        FloodFill(w, x, y - 1, c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] w = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; ++j)
                w[i][j] = sc.nextInt();
        }
        int x = sc.nextInt(), y = sc.nextInt(), c = sc.nextInt();
	    FloodFill(w, x, y, c);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(w[i][j] + " ");
            System.out.println();
        }
    }
} class FloodFill {
    
}
