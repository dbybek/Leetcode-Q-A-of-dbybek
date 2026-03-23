import java.util.Scanner;

//1980. Find Unique Binary String (Medium)
//----------------------------------------
//Given an array of strings nums containing n unique binary strings each of length n,
//return a binary string of length n that does not appear in nums.
//If there are multiple answers, you may return any of them.
//
//Constraints:
//-----------
//n == nums.length
//1 <= n <= 16
//nums[i].length == n
//nums[i] is either '0' or '1'.
//All the strings of nums are unique.

public class FindUniqueBinaryString 
{
	public String findDifferentBinaryString(String[] nums)
	{
		StringBuilder res = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            if(nums[i].charAt(i)=='0'){
                res.append('1');
            }
            else{
                res.append('0');
            }
        }
        return res.toString();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextLine();
		}
		sc.close();
		FindUniqueBinaryString Res = new FindUniqueBinaryString();
		System.out.print(Res.findDifferentBinaryString(arr));
	}
}
