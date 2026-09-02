import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//3731. Find Missing Elements (Easy)
//----------------------------------
//You are given an integer array nums consisting of unique integers.
//Originally, nums contained every integer within a certain range.
//However, some integers might have gone missing from the array.
//The smallest and largest integers of the original range are still present in nums.
//Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.
//
//Constraints:
//-----------
//2 <= nums.length <= 100
//1 <= nums[i] <= 100

public class FindMissingElements 
{
	public List<Integer> findMissingElements(int[] nums)
	{
		int mn = 101, mx = 0;
        int[] freq = new int[101];
        for(int ele:nums){
            mn = Math.min(mn,ele);
            mx = Math.max(mx,ele);
            freq[ele]++;
        }
        List<Integer> res = new ArrayList<>();
        if(nums.length == mx-mn+1){
            return res;
        }
        for(int i=mn+1;i<mx;i++){
            if(freq[i]==0){
                res.add(i);
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
		FindMissingElements Res = new FindMissingElements();
		System.out.print(Res.findMissingElements(arr));
	}
}
