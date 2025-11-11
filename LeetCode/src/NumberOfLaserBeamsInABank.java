import java.util.Scanner;

//2125. Number of Laser Beams in a Bank (Medium)
//----------------------------------------------
//Anti-theft security devices are activated inside a bank.
//You are given a 0-indexed binary string array bank representing the floor plan of the bank,
//which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's.
//'0' means the cell is empty, while'1' means the cell has a security device.
//There is one laser beam between any two security devices if both conditions are met:
//
//The two devices are located on two different rows: r1 and r2, where r1 < r2.
//For each row i where r1 < i < r2, there are no security devices in the ith row.
//Laser beams are independent, i.e., one beam does not interfere nor join with another.
//
//Return the total number of laser beams in the bank.
//
//Constraints:
//-----------
//m == bank.length
//n == bank[i].length
//1 <= m, n <= 500
//bank[i][j] is either '0' or '1'.

public class NumberOfLaserBeamsInABank 
{
	public int numberOfBeams(String[] bank)
	{
		int n = bank.length, m = bank[0].length(), res = 0, laserCount = 0;
		for(int i=0;i<n;i++) {
			int r = 0;
			for(int j=0;j<m;j++) {
				r+=bank[i].charAt(j)-'0';
			}
			if(r>0) {
				res+=(r*laserCount);
				laserCount = r;
			}
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextLine();
		}
		sc.close();
		NumberOfLaserBeamsInABank Res = new NumberOfLaserBeamsInABank();
		System.out.print(Res.numberOfBeams(arr));
	}
}
