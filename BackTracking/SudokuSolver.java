package BackTracking;

public import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[][] board = new char[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = sc.next().charAt(0);
      }
    }
    sc.close();

    if (solveSudoku(board)) System.out.println(
      "correct"
    ); else System.out.println("incorrect");
  }

  public static boolean solveSudoku(char[][] board) {
	  ArrayList<Integer> emptyIndexes = new ArrayList<>();
    for(int i = 0; i < 9; i++){
		for(int j = 0; j<9; j++){
			if(board[i][j] == '.'){
				int cellNo = i*9 + j;
				emptyIndexes.add(cellNo);
			}
		}
	}
	boolean res  = generateSudoku(board, 0, emptyIndexes);
	  return res;
  }

  public static boolean isValid(char [][] board, char ch, int rowNo, int colNo){

	  for(int i = 0; i<9 ;i++){
		  if(board[i][colNo] == ch || board[rowNo][i] == ch){
			  return false;
		  }
	  }

	  int strow = (rowNo/3)*3;
	  int stcol = (colNo/3)*3;

	  for(int i = strow; i<strow + 3; i++){
		  for(int j = stcol; j<stcol + 3; j++){
			  if(board[i][j] == ch){
				  return false;
			  }
		  }
	  }

	  return true;
  } 
  public static boolean generateSudoku(char [][] board, int idx, ArrayList<Integer> emptyIndexes){

	  if(idx == emptyIndexes.size()){
		  return true;
	  }
	  int cellNo = emptyIndexes.get(idx);
	  int rowNo = cellNo/9;
	  int colNo = cellNo%9;

	  for(char ch = '1'; ch <= '9'; ch++){
		  if(isValid(board, ch, rowNo, colNo)){
			  board[rowNo][colNo] = ch;
			  boolean res  = generateSudoku(board, idx + 1, emptyIndexes);
			  if(res == true){
				  return true;
			  }
			  board[rowNo][colNo] = '.';
		  }
	  }

	  return false;
  }

} {
    
}
