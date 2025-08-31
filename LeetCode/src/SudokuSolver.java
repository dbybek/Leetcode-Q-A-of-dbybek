import java.util.Scanner;

//37. Sudoku Solver (Hard)
//------------------------
//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//A sudoku solution must satisfy all of the following rules:
//
//Each of the digits 1-9 must occur exactly once in each row.
//Each of the digits 1-9 must occur exactly once in each column.
//Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//The '.' character indicates empty cells.
//
//Constraints:
//-----------
//board.length == 9
//board[i].length == 9
//board[i][j] is a digit or '.'.
//It is guaranteed that the input board has only one solution.

public class SudokuSolver 
{
	private boolean fillSudoku(int row, int col, char[][] A)
	{
		if(col==9) {
			row++;
			col = 0;
		}
		
		if(row==9) {
			return true;
		}
		
		if(A[row][col] != '.') {
			return fillSudoku(row,col+1,A);
		}
		
		for(int i=1;i<=9;i++) {
			char key = (char)('0'+i);
			if(isPossible(row,col,key,A)) {
				A[row][col] = key;
				if(fillSudoku(row,col+1,A)) {
					return true;
				}
				A[row][col] = '.';
			}
		}
		return false;
	}
	
	private boolean isPossible(int r, int c, int k, char[][] a)
	{
		for(int i=0;i<9;i++) {
			if(a[r][i]==k || a[i][c]==k) {
				return false;
			}
		}
		
		int x = r-(r%3), y = c-(c%3);
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(a[x+i][y+j]==k) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void solveSudoku(char[][] board)
	{
		fillSudoku(0,0,board);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[9][9];
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				arr[i][j] = sc.nextLine().charAt(0);
			}
		}
		sc.close();
		System.out.println("Before solving: ");
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		SudokuSolver Res = new SudokuSolver();
		Res.solveSudoku(arr);
		System.out.println("After solving: ");
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
