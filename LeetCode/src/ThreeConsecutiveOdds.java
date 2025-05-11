import java.util.Scanner;

//1550. Three Consecutive Odds (Easy)
//-----------------------------------
//Given an integer array arr, return true if there are three consecutive odd numbers in the array.
//Otherwise, return false.
//
//Constraints:
//-----------
//1 <= arr.length <= 1000
//1 <= arr[i] <= 1000

public class ThreeConsecutiveOdds 
{
	public boolean threeConsecutiveOdds(int[] arr) 
	{
        int count = 0;
        for(int ele:arr){
            if(ele%2==1){
                count++;
                if(count==3){
                    return true;
                }
            }
            else{
                count=0;
            }
        }
        return false;
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
		ThreeConsecutiveOdds Res = new ThreeConsecutiveOdds();
		System.out.print(Res);
	}

}
