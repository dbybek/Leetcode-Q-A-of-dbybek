import java.util.Scanner;

//1394. Find Lucky Integer in an Array(Easy)
//------------------------------------------
//Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
//Return the largest lucky integer in the array. If there is no lucky integer return -1.
//
//Constraints:
//-----------
//1 <= arr.length <= 500
//1 <= arr[i] <= 500

public class FindLuckyIntegerInAnArray 
{
	public int findLucky(int[] arr)
	{
		int[] freq = new int[501];
        for(int ele:arr){
            freq[ele]++;
        }
        for(int i=500;i>0;i--){
            if(freq[i]==i){
                return i;
            }
        }
        return -1;
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
		FindLuckyIntegerInAnArray Res = new FindLuckyIntegerInAnArray();
		System.out.print(Res.findLucky(arr));
	}

}
