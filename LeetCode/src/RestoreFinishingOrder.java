import java.util.Scanner;

//3668. Restore Finishing Order (Easy)
//------------------------------------
//You are given an integer array order of length n and an integer array friends.
//Order contains every integer from 1 to n exactly once,
//representing the IDs of the participants of a race in their finishing order.
//friends contains the IDs of your friends in the race sorted in strictly increasing order.
//Each ID in friends is guaranteed to appear in the order array.
//Return an array containing your friends' IDs in their finishing order.
//
//Constraints:
//-----------
//1 <= n == order.length <= 100
//order contains every integer from 1 to n exactly once
//1 <= friends.length <= min(8, n)
//1 <= friends[i] <= n
//friends is strictly increasing

public class RestoreFinishingOrder 
{
	public int[] recoverOrder(int[] order, int[] friends)
	{
		int n=friends.length, i=0;
        int[] res = new int[n];
//		Approach I: Based on the constraints used the O(n^2) solution.
//		--------------------------------------------------------------
//        for(int ele:order){
//            for(int elem:friends){
//                if(ele==elem){
//                    res[i++] = ele;
//                    break;
//                }
//            }
//        }
        
//        Appraoch II: Take a boolean set or array with friends details. Then use it to create the result in TC of O(n).
//        --------------------------------------------------------------------------------------------------------------
        boolean[] friend = new boolean[order.length+1];
        for(int ele:friends) {
        	friend[ele] = true; 
        }
        for(int ele:order) {
        	if(friend[ele]) {
        		res[i++] = ele;
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
		RestoreFinishingOrder Res = new RestoreFinishingOrder();
		int[] arr2 = Res.recoverOrder(arr, arr1);
		for(int ele:arr2) {
			System.out.print(ele+" ");
		}
	}
}
