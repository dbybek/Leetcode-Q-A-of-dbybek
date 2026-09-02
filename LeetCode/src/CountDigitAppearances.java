import java.util.Scanner;

//3895. Count Digit Appearances (Medium)
//--------------------------------------
//You are given an integer array nums and an integer digit.
//Return the total number of times digit appears in the decimal representation of all elements in nums.
//
//Constraints:
//-----------
//1 <= nums.length <= 1000
//1 <= nums[i] <= 10^6​​​​​​​
//0 <= digit <= 9

public class CountDigitAppearances 
{
	public int countDigitOccurrences(int[] nums, int digit)
	{
		int res = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=nums[i];j>0;j/=10){
                if(j%10==digit){
                    res++;
                }
            }
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
		int k = sc.nextInt();
		sc.close();
		CountDigitAppearances Res = new CountDigitAppearances();
		System.out.print(Res.countDigitOccurrences(arr, k));
	}
}
