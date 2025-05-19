import java.util.Scanner;

//3024. Type of Triangle (Easy)
//-----------------------------
//You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.
//
//A triangle is called equilateral if it has all sides of equal length.
//A triangle is called isosceles if it has exactly two sides of equal length.
//A triangle is called scalene if all its sides are of different lengths.
//Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.
//
//Constraints:
//-----------
//nums.length == 3
//1 <= nums[i] <= 100

public class TypeOfTriangle 
{

	public String triangleType(int[] nums) 
	{
//		Approach I:
//		-----------
//		if(nums[0]==nums[1] && nums[0]==nums[2]) {
//			return "equilateral";
//		}
//		
//		if(nums[0]==nums[1] || nums[0]==nums[2] || nums[1]==nums[2]) {
//			if(nums[0]+nums[1]>nums[2] && nums[0]+nums[2]>nums[1] && nums[1]+nums[2]>nums[0]) {
//				return "isosceles";
//			}
//			else {
//				return "none";
//			}
//		}
//		
//		if(nums[0]+nums[1]>nums[2] && nums[0]+nums[2]>nums[1] && nums[1]+nums[2]>nums[0]) {
//			return "scalene";
//		}
//		
//		return "none";
//		
//		Approach II: Same logic but better space utilization
//		----------------------------------------------------
		if(nums[0]+nums[1]<=nums[2] || nums[0]+nums[2]<=nums[1] || nums[1]+nums[2]<=nums[0]) {
			return "none";
		}
        if(nums[0]==nums[1] && nums[0]==nums[2]) {
			return "equilateral";
		}
        if(nums[0]==nums[1] || nums[0]==nums[2] || nums[1]==nums[2]) {
			return "isosceles";
		}
        return "scalene";
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
		TypeOfTriangle Res = new TypeOfTriangle();
		System.out.print(Res.triangleType(arr));
	}

}
