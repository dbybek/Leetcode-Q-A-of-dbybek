import java.util.Scanner;

//2078. Two Furthest Houses With Different Colors (Easy)
//------------------------------------------------------
//There are n houses evenly lined up on the street, and each house is beautifully painted.
//You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.
//Return the maximum distance between two houses with different colors.
//The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.
//
//Constraints:
//-----------
//n == colors.length
//2 <= n <= 100
//0 <= colors[i] <= 100
//Test data are generated such that at least two houses have different colors.

public class TwoFurthestHousesWithDifferentColors 
{
	public int maxDistance(int[] colors)
	{
		int n = colors.length, i = 0, j = n-1;
        while(colors[i]==colors[j]){
            j--;
        }
        while(colors[n-1]==colors[i]){
            i++;
        }
        return Math.max(n-1-i,j);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}		
		sc.close();
		TwoFurthestHousesWithDifferentColors Res = new TwoFurthestHousesWithDifferentColors();
		System.out.print(Res.maxDistance(arr));
	}
}
