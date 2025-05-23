import java.util.*;

//2094. Finding 3-Digit Even Numbers (Easy)
//-----------------------------------------
//You are given an integer array digits, where each element is a digit. The array may contain duplicates.
//You need to find all the unique integers that follow the given requirements:
//
//The integer consists of the concatenation of three elements from digits in any arbitrary order.
//The integer does not have leading zeros.
//The integer is even.
//For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.
//
//Return a sorted array of the unique integers.
//
//Constraints:
//-----------
//3 <= digits.length <= 100
//0 <= digits[i] <= 9


public class Finding3DigitEvenNumbers 
{

	public int[] findEvenNumbers(int[] digits)
	{
		int[] freq = new int[10];
		for(int ele:digits) {
			freq[ele]++;
		}
				
		ArrayList<Integer> res = new ArrayList<>();
		
		for(int i=100;i<1000;i+=2) {
			int z = i%10, t = (i/10)%10, h = i/100;
			if(freq[z]>0) {
				freq[z]--;
				if(freq[t]>0) {
					freq[t]--;
					if(freq[h]>0) {
						res.add(i);
					}
					freq[t]++;
				}
				freq[z]++;
			}
		}
		
		return res.stream().mapToInt(Integer::intValue).toArray();
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
		Finding3DigitEvenNumbers Res = new Finding3DigitEvenNumbers();
		int[] arr1 = Res.findEvenNumbers(arr);
		for(int ele:arr1) {
			System.out.print(ele+" ");
		}
	}

}
