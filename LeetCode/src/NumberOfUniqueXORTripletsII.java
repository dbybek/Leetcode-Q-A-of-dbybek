import java.util.Scanner;

//3514. Number of Unique XOR Triplets II (Medium)
//-----------------------------------------------
//You are given an integer array nums.
//A XOR triplet is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k] where i <= j <= k.
//Return the number of unique XOR triplet values from all possible triplets (i, j, k).
//
//Constraints:
//-----------
//1 <= nums.length <= 1500
//1 <= nums[i] <= 1500

public class NumberOfUniqueXORTripletsII 
{
	public int uniqueXorTriplets(int[] nums)
	{
		boolean[] xorPair = new boolean[2048];
        boolean[] xorTriplet = new boolean[2048];

        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                xorPair[nums[i]^nums[j]] = true;
            }
        }

        for(int i=0;i<2048;i++){
            if(!xorPair[i]){
                continue;
            }
            for(int j=0;j<nums.length;j++){
                xorTriplet[nums[j]^i] = true;
            }
        }
        
        int res = 0;
        for(boolean ele:xorTriplet){
            res = ele?res+1:res;
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
		NumberOfUniqueXORTripletsII Res = new NumberOfUniqueXORTripletsII();
		System.out.print(Res.uniqueXorTriplets(arr));
	}
}
