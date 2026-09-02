import java.util.Scanner;

//3069. Distribute Elements Into Two Arrays I (Easy)
//--------------------------------------------------
//You are given a 1-indexed array of distinct integers nums of length n.
//You need to distribute all the elements of nums between two arrays arr1 and arr2 using n operations.
//In the first operation, append nums[1] to arr1. In the second operation, append nums[2] to arr2.
//Afterwards, in the ith operation:
//If the last element of arr1 is greater than the last element of arr2, append nums[i] to arr1.
//Otherwise, append nums[i] to arr2.
//The array result is formed by concatenating the arrays arr1 and arr2.
//For example, if arr1 == [1,2,3] and arr2 == [4,5,6], then result = [1,2,3,4,5,6].
//
//Return the array result.
//
//Constraints:
//-----------
//3 <= n <= 50
//1 <= nums[i] <= 100
//All elements in nums are distinct.

public class DistributeElementsIntoTwoArraysI 
{
	public int[] resultArray(int[] nums)
	{
		int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        res[n-1] = nums[1];
        int ind1 = 0, ind2 = n-1;
        for(int i=2;i<n;i++){
            if(res[ind1]>res[ind2]){
                ind1++;
                res[ind1] = nums[i];
            }
            else{
                ind2--;
                res[ind2] = nums[i];
            }
        }
        while(ind2<n-1){
            int temp = res[ind2];
            res[ind2] = res[n-1];
            res[n-1] = temp;
            ind2++;
            n--;
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
		DistributeElementsIntoTwoArraysI Res = new DistributeElementsIntoTwoArraysI();
		int[] arr2 = Res.resultArray(arr);
		for(int ele:arr2) {
			System.out.print(ele+" ");
		}
	}
}
