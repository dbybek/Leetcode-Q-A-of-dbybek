import java.util.Scanner;

//3074. Apple Redistribution into Boxes(Easy)
//-------------------------------------------
//You are given an array apple of size n and an array capacity of size m.
//There are n packs where the ith pack contains apple[i] apples.
//There are m boxes as well, and the ith box has a capacity of capacity[i] apples.
//Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.
//Note that, apples from the same pack can be distributed into different boxes.
//
//Constraints:
//-----------
//1 <= n == apple.length <= 50
//1 <= m == capacity.length <= 50
//1 <= apple[i], capacity[i] <= 50
//The input is generated such that it's possible to redistribute packs of apples into boxes.

public class AppleRedistributionIntoBoxes 
{
	public int minimumBoxes(int[] apple, int[] capacity)
	{
		int sum = 0;
        for(int ele:apple){
            sum+=ele;
        }
        int[] freq = new int[51];
        for(int ele:capacity){
            freq[ele]++;
        }
        int res = 0;
        for(int i=50;i>=0;i--){
            while(freq[i]-->0 && sum>0){
                sum-=i;
                res++;
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int[] arr1 = new int[M];
		for(int i=0;i<M;i++) {
			arr1[i] = sc.nextInt();
		}
		sc.close();
		AppleRedistributionIntoBoxes Res = new AppleRedistributionIntoBoxes();
		System.out.print(Res.minimumBoxes(arr, arr1));
	}
}
