import java.util.*;

//2197. Replace Non-Coprime Numbers in Array (Hard)
//-------------------------------------------------
//You are given an array of integers nums. Perform the following steps:
//Find any two adjacent numbers in nums that are non-coprime.
//If no such numbers are found, stop the process.
//Otherwise, delete the two numbers and replace them with their LCM (Least Common Multiple).
//Repeat this process as long as you keep finding two adjacent non-coprime numbers.
//Return the final modified array.
//It can be shown that replacing adjacent non-coprime numbers in any arbitrary order will lead to the same result.
//
//The test cases are generated such that the values in the final array are less than or equal to 108.
//
//Two values x and y are non-coprime if GCD(x, y) > 1 where GCD(x, y) is the Greatest Common Divisor of x and y.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^5
//The test cases are generated such that the values in the final array are less than or equal to 10^8.

public class ReplaceNonCoprimeNumbersInArray 
{
	private int gcd(int a, int b)
	{
		if(b==0) {
			return a;
		}
		return gcd(b,a%b);
//		int rem = b%a;
//		while(rem>0) {
//			b = a;
//			a = rem;
//			rem = b%a;
//		}
//		return a;
	}
	
	public List<Integer> replaceNonCoprimes(int[] nums)
	{
		int n = nums.length, top = -1;
		int[] stk = new int[n];
		for(int i=0;i<n;i++) {
			int ele = nums[i];
			while(top!=-1) {
				if(ele==stk[top]&&ele>1){
                    top--;
                    continue;
                }
				int hcf = gcd(stk[top],ele);
				if(hcf==1) {
					break;
				}
				ele=(int)(((long)ele*(long)stk[top--])/(long)hcf);
			}
			stk[++top] = ele;
		}
		List<Integer> res = new ArrayList<>();
		for(int i=0;i<=top;i++) {
			res.add(stk[top]);
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
		ReplaceNonCoprimeNumbersInArray Res = new ReplaceNonCoprimeNumbersInArray();
		System.out.print(Res.replaceNonCoprimes(arr));
	}
}
