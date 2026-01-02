import java.util.*;

//961. N-Repeated Element in Size 2N Array(Easy)
//----------------------------------------------
//You are given an integer array nums with the following properties:
//
//nums.length == 2 * n.
//nums contains n + 1 unique elements.
//Exactly one element of nums is repeated n times.
//Return the element that is repeated n times.
//
//Constraints:
//-----------
//2 <= n <= 5000
//nums.length == 2 * n
//0 <= nums[i] <= 10^4
//nums contains n + 1 unique elements and one of them is repeated exactly n times.

public class NRepeatedElementInSize2NArray 
{
	public int repeatedNTimes(int[] nums)
	{
		HashSet<Integer> hs = new HashSet<>();
        int res = 0;
        for(int ele:nums){
            if(hs.contains(ele)){
                res = ele;
                break;
            }
            hs.add(ele);
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr1 = new int[N];
		for(int i=0;i<N;i++) {
			arr1[i] = sc.nextInt();
		}
		sc.close();
		NRepeatedElementInSize2NArray Res = new NRepeatedElementInSize2NArray();
		System.out.print(Res.repeatedNTimes(arr1));
	}
}
