import java.util.Scanner;

//2553. Separate the Digits in an Array (Easy)
//--------------------------------------------
//Given an array of positive integers nums,
//return an array answer that consists of the digits of each integer in nums after separating them
//in the same order they appear in nums.
//To separate the digits of an integer is to get all the digits it has in the same order.
//
//For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].
//Constraints:
//-----------
//1 <= nums.length <= 1000
//1 <= nums[i] <= 10^5

public class SeparateTheDigitsInAnArray 
{
	public int[] separateDigits(int[] nums)
	{
		// Stack<Integer> stk = new Stack<>();
        // int i = nums.length-1;
        // while(i>=0){
        //     while(nums[i]>0){
        //         stk.push(nums[i]%10);
        //         nums[i]/=10;
        //     }
        //     i--;
        // }
        // int[] res = new int[stk.size()];
        // i++;
        // while(!stk.isEmpty()){
        //     res[i] = stk.pop();
        //     i++;
        // }
        // return res;
        int resSize = 0, n = nums.length, temp = 0;
        for(int i=0;i<n;i++){
            temp = nums[i];
            while(temp>0){
                resSize++;
                temp/=10;
            }
        }
        int[] res = new int[resSize];
        resSize--;
        for(int i=n-1;i>=0;i--){
            temp = nums[i];
            while(temp>0){
                res[resSize--] = temp%10;
                temp/=10;
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
		SeparateTheDigitsInAnArray Res = new SeparateTheDigitsInAnArray();
		int[] arr1 = Res.separateDigits(arr);
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
}
