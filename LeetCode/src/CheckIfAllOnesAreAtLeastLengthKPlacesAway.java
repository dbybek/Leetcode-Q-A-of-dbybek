import java.util.Scanner;

//1437. Check If All 1's Are at Least Length K Places Away (Easy)
//---------------------------------------------------------------
//Given an binary array nums and an integer k,
//return true if all 1's are at least k places away from each other, otherwise return false.
//
//Constraints:
//-----------
//1 <= nums.length <= 10^5
//0 <= k <= nums.length
//nums[i] is 0 or 1

public class CheckIfAllOnesAreAtLeastLengthKPlacesAway 
{
	public boolean kLengthApart(int[] nums, int k)
	{
		int n = nums.length, ind = -1;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                if(ind==-1){
                    ind = i;
                }
                else{
                    if(i-ind-1<k){
                        return false;
                    }
                    ind = i;
                }
            }
        }
        return true;
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
		int k = sc.nextInt();
		sc.close();
		CheckIfAllOnesAreAtLeastLengthKPlacesAway Res = new CheckIfAllOnesAreAtLeastLengthKPlacesAway();
		System.out.print(Res.kLengthApart(arr, k));
	}
}
