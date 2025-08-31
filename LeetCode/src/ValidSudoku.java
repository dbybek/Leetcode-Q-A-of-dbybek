import java.util.Scanner;

//36. Valid Sudoku (Medium)
//-------------------------
//Determine if a 9 x 9 Sudoku board is valid.
//Only the filled cells need to be validated according to the following rules:
//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//Note:
//
//A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//Only the filled cells need to be validated according to the mentioned rules.
//
//Constraints:
//-----------
//board.length == 9
//board[i].length == 9
//board[i][j] is a digit 1-9 or '.'.

public class ValidSudoku 
{
	public boolean isValidSudoku(char[][] board)
	{
		boolean[][] row = new boolean[9][9];
		boolean[][] col = new boolean[9][9];
		boolean[][] box = new boolean[9][9];
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j] != '.') {
					int num = board[i][j] - '1', boxInd = (i/3)*3 + (j/3);
					if(row[i][num] || col[j][num] || box[boxInd][num]) {
						return false;
					}
					row[i][num] = col[j][num] = box[boxInd][num] = true;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextLine().charAt(0);
			}
		}
		sc.close();
		ValidSudoku Res = new ValidSudoku();
		System.out.print(Res.isValidSudoku(arr));
	}
}
