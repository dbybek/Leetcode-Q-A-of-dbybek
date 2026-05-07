import java.util.Scanner;

//1861. Rotating the Box (Medium)
//-------------------------------
//You are given an m x n matrix of characters boxGrid representing a side-view of a box.
//Each cell of the box is one of the following:
//A stone '#'
//A stationary obstacle '*'
//Empty '.'
//The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity.
//Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box.
//Gravity does not affect the obstacles' positions,
//and the inertia from the box's rotation does not affect the stones' horizontal positions.
//
//It is guaranteed that each stone in boxGrid rests on an obstacle, another stone, or the bottom of the box.
//
//Return an n x m matrix representing the box after the rotation described above.
//Constraints:
//-----------
//m == boxGrid.length
//n == boxGrid[i].length
//1 <= m, n <= 500
//boxGrid[i][j] is either '#', '*', or '.'.

public class RotatingTheBox 
{
	public char[][] rotateTheBox(char[][] boxGrid)
	{
		int n = boxGrid.length, m = boxGrid[0].length;
        char[][] res = new char[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[j][i] = boxGrid[n-i-1][j];
            }
        }
        int l = m-1;
        for(int i=0;i<n;i++){
            l = m-1;
            for(int j=m-1;j>=0;j--){
                if(res[j][i]=='*'){
                    l = j-1;
                }
                else if(res[j][i]=='#'){
                    res[j][i] = '.';
                    res[l][i] = '#';
                    l--;
                }
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		char[][] arr = new char[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextLine().charAt(0);
			}
		}
		sc.close();
		System.out.println("Before rotation: ");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		RotatingTheBox Res = new RotatingTheBox();
		char[][] arr1 = Res.rotateTheBox(arr);
		System.out.println("After rotation: ");
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
	}
}
