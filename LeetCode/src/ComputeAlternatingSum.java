import java.util.Scanner;

//3701. Compute Alternating Sum (Easy)
//------------------------------------
//You are given an integer array nums.
//The alternating sum of nums is the value obtained by adding elements at even indices and
//subtracting elements at odd indices. That is, nums[0] - nums[1] + nums[2] - nums[3]...
//Return an integer denoting the alternating sum of nums.
//
//Constraints:
//-----------
//1 <= nums.length <= 100
//1 <= nums[i] <= 100

public class ComputeAlternatingSum 
{
	public int alternatingSum(int[] nums)
	{
		int res = 0, n = nums.length;
        for(int i=0;i<n;i++){
            if(i%2 == 0){
                res += nums[i];
            }
            else{
                res -= nums[i];
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
		sc.close();
		ComputeAlternatingSum Res = new ComputeAlternatingSum();
		System.out.print(Res.alternatingSum(arr));
	}
}
