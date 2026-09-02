import java.util.Scanner;

//3513. Number of Unique XOR Triplets I (Medium)
//----------------------------------------------
//You are given an integer array nums of length n, where nums is a permutation of the numbers in the range [1, n].
//A XOR triplet is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k] where i <= j <= k.
//
//Return the number of unique XOR triplet values from all possible triplets (i, j, k).
//
//Constraints:
//-----------
//1 <= n == nums.length <= 10^5
//1 <= nums[i] <= n
//nums is a permutation of integers from 1 to n.

public class NumberOfUniqueXORTripletsI 
{
	public int uniqueXorTriplets(int[] nums)
	{
		int n = nums.length;
        if(n<3){
            return n;
        }
        int res = 1;
        n++;
        while(res<n){
            res*=2;
        }
        return res;
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
		NumberOfUniqueXORTripletsI Res = new NumberOfUniqueXORTripletsI();
		System.out.print(Res.uniqueXorTriplets(arr));
	}
}
