import java.util.Scanner;

public class CountSubarraysOfLengthThreeWithACondition {

	public int countSubarrays(int[] nums) 
	{
        int n=nums.length-3,res=0;
		for(int i=0;i<=n;i++) {
			if((nums[i]+nums[i+2])*2==nums[i+1]) {
				res++;
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
		CountSubarraysOfLengthThreeWithACondition Res = new CountSubarraysOfLengthThreeWithACondition();
		System.out.print(Res.countSubarrays(arr));
	}

}
