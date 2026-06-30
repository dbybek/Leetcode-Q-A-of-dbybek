import java.util.Scanner;

//2161. Partition Array According to Given Pivot (Medium)
//-------------------------------------------------------
//You are given a 0-indexed integer array nums and an integer pivot.
//Rearrange nums such that the following conditions are satisfied:
//Every element less than pivot appears before every element greater than pivot.
//Every element equal to pivot appears in between the elements less than and greater than pivot.
//The relative order of the elements less than pivot and the elements greater than pivot is maintained.
//More formally, consider every pi, pj where pi is the new position of the ith element and 
//pj is the new position of the jth element.
//If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
//Return nums after the rearrangement.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//-10^6 <= nums[i] <= 10^6
//pivot equals to an element of nums.

public class PartitionArrayAccordingToGivenPivot 
{
	public int[] pivotArray(int[] nums, int pivot)
	{
		int l = 0, n = nums.length, r = n-1;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                res[l++] = nums[i];
            }
            if(nums[n-1-i]>pivot){
                res[r--] = nums[n-1-i];
            }
        }

        while(l<=r){
            res[l++] = pivot;
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
		int p = sc.nextInt();
		sc.close();
		PartitionArrayAccordingToGivenPivot Res = new PartitionArrayAccordingToGivenPivot();
		int[] arr1 = Res.pivotArray(arr, p);
		for(int i=0;i<N;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
}
