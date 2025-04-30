import java.util.Scanner;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

	public long countSubarrays(int[] nums, int k) 
	{
        int mx=0,n=nums.length;
		for(int ele:nums) {
			mx=Math.max(mx,ele);
		}
		boolean add=true;
		long res=0;
		int l=0,r=0,count=0;
		while(r<n) {
			if(add) {
				if(nums[r]==mx) {
					count++;
				}
			}
			if(count==k) {
				res+=n-r;
				if(nums[l]==mx) {
					count--;
				}
				l++;
				add=false;
				if(l==r && count!=k) {
					r++;
					add=true;
				}
			}
			else {
				r++;
				add=true;
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int K = sc.nextInt();
		sc.close();
		CountSubarraysWhereMaxElementAppearsAtLeastKTimes Res = new CountSubarraysWhereMaxElementAppearsAtLeastKTimes();
		System.out.print(Res.countSubarrays(arr, K));
	}

}
