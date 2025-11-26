import java.util.Scanner;

//2154. Keep Multiplying Found Values by Two (Easy)
//-------------------------------------------------
//You are given an array of integers nums.
//You are also given an integer original which is the first number that needs to be searched for in nums.
//You then do the following steps:
//
//1. If original is found in nums, multiply it by two (i.e., set original = 2 * original).
//2. Otherwise, stop the process.
//3. Repeat this process with the new number as long as you keep finding the number.
//Return the final value of original.
//
//Constraints:
//-----------
//1 <= nums.length <= 1000
//1 <= nums[i], original <= 1000

public class KeepMultiplyingFoundValuesByTwo 
{
	public int findFinalValue(int[] nums, int original)
	{
		int[] freq = new int[1001];
        for(int ele:nums){
            freq[ele]++;
        }
        for(int i=original;i<1001;i*=2){
            if(freq[original]==0){
                break;
            }
            original*=2;
        }
        return original;
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
		int k = sc.nextInt();
		sc.close();
		KeepMultiplyingFoundValuesByTwo Res = new KeepMultiplyingFoundValuesByTwo();
		System.out.print(Res.findFinalValue(arr, k));
	}
}
