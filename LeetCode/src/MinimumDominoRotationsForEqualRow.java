import java.util.Scanner;

//1007. Minimum Domino Rotations For Equal Row (Medium)
//-----------------------------------------------------
//In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino.
//(A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
//We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
//Return the minimum number of rotations so that all the values in tops are the same, or
//all the values in bottoms are the same.
//If it cannot be done, return -1.
//
//Constraints:
//-----------
//2 <= tops.length <= 2 * 10^4
//bottoms.length == tops.length
//1 <= tops[i], bottoms[i] <= 6

public class MinimumDominoRotationsForEqualRow 
{
	private int helper(int[] T,int[] B,int val)
	{
		int topR = 0, bottomR = 0, n = T.length;
		for(int i=0;i<n;i++) {
			if(T[i]!=val && B[i]!=val) {
				return -1;
			}
			else if(T[i]!=val) {
				topR++;
			}
			else if(B[i]!=val){
				bottomR++;
			}
		}
		return Math.min(topR, bottomR);
	}
	
	public int minDominoRotations(int[] tops, int[] bottoms) 
	{
//		Approach I: A bit round about solution but getting the results.
//		---------------------------------------------------------------
//		int n = tops.length, exists = 1;
//		int countOfTopsOfZero = 1, countOfBottomsOfZero = tops[0]==bottoms[0]?0:1;
//		for(int i=1;i<n;i++) {
//			if(tops[0]==tops[i]) {
//				countOfTopsOfZero++;
//			}
//			else if (tops[0]==bottoms[i]) {
//				countOfTopsOfZero++;
//			}
//			else {
//				exists = 0;
//			}
//			if(bottoms[0]==tops[i]) {
//				countOfBottomsOfZero++;
//			}
//			else if(bottoms[0]==bottoms[i]) {
//				countOfBottomsOfZero++;
//			}
//			else if(exists == 0) {
//				return -1;
//			}
//		}
//		if(countOfTopsOfZero<n && countOfBottomsOfZero<n) {
//			return -1;
//		}
//		int  valueToCheck = countOfTopsOfZero>countOfBottomsOfZero?tops[0]:bottoms[0];
//		countOfTopsOfZero = 0;
//		countOfBottomsOfZero = 0;
//		for(int i=0;i<n;i++) {
//			if(tops[i]==valueToCheck) {
//				countOfTopsOfZero++;
//			}
//			if(bottoms[i]==valueToCheck) {
//				countOfBottomsOfZero++;
//			}
//		}
//		return Math.min(n-countOfTopsOfZero,n-countOfBottomsOfZero);
//		
//		Approach II: Optimised approach using a helper method with the same intuition as above solution.
//		------------------------------------------------------------------------------------------------
		int topRes = helper(tops,bottoms,tops[0]), bottomRes = helper(tops,bottoms,bottoms[0]);
		if(topRes==-1) {
			return bottomRes;
		}
		return bottomRes==-1?topRes:bottomRes;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N], arr2 = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();
		MinimumDominoRotationsForEqualRow Res = new MinimumDominoRotationsForEqualRow();
		System.out.print(Res.minDominoRotations(arr, arr2));
	}

}
