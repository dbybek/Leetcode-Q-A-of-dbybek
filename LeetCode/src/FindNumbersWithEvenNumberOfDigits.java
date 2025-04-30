import java.util.*;

public class FindNumbersWithEvenNumberOfDigits {

	public int findNumbers(int[] nums) 
	{
        int res=0;
		for(int ele:nums) {
			if((9<ele&&ele<100)||(999<ele&&ele<10000)||(ele==100000)){
				res++;
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
		FindNumbersWithEvenNumberOfDigits Res = new FindNumbersWithEvenNumberOfDigits();
		System.out.print(Res.findNumbers(arr));
	}

}
