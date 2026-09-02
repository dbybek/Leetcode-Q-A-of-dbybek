import java.util.Scanner;

//2091. Removing Minimum and Maximum From Array (Medium)
//------------------------------------------------------
//You are given a 0-indexed array of distinct integers nums.
//There is an element in nums that has the lowest value and an element that has the highest value.
//We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.
//A deletion is defined as either removing an element from the front of the array or
//removing an element from the back of the array.
//Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//-10^5 <= nums[i] <= 10^5
//The integers in nums are distinct.

public class RemovingMinimumAndMaximumFromArray 
{
	public int minimumDeletions(int[] nums)
	{
		int mn = nums[0], mnind = 0, mx = nums[0], mxind = 0,  n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<mn){
                mn = nums[i];
                mnind = i;
            }
            if(nums[i]>mx){
                mx = nums[i];
                mxind = i;
            }
        }
        int res = 0;
        if(mxind>mnind){
            res = Math.min(mxind+1,n-mnind);
            res = Math.min(res, n-mxind+mnind+1);
        }
        else{
            res = Math.min(n-mxind,mnind+1);
            res = Math.min(res, n-mnind+mxind+1);
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
		RemovingMinimumAndMaximumFromArray Res = new RemovingMinimumAndMaximumFromArray();
		System.out.print(Res.minimumDeletions(arr));
	}
}
