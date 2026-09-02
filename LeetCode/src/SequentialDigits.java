import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1291. Sequential Digits (Medium)
//--------------------------------
//An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
//Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
//
//Constraints:
//-----------
//10 <= low <= high <= 10^9

public class SequentialDigits 
{
	public List<Integer> sequentialDigits(int low, int high)
	{
		List<Integer> res = new ArrayList<>();
        if(low>9 && high<12 || low>123456789){
            return res;
        }
        int[] temp = new int[]{12,123,1234,12345,123456,1234567,12345678,123456789};
        int start = 0, pow = 10;
        for(int i=0;i<8;i++){
            if(temp[i]>low && temp[i]<high){
                if(low==pow || low==pow-1){
                    start = temp[i];
                }
                else{
                    pow/=10;
                    start = temp[i-1];
                }
                break;
            }
            if(temp[i]==low){
                start = temp[i];
                break;
            }
            if(temp[i]>high){
                if(low==pow-1){
                    start = temp[i];
                }
                else{
                    pow/=10;
                    start = temp[i-1];
                }
                break;
            }
            pow*=10;
        }
        while(start<low){
            if(start%10==9){
                if(start/pow==1){
                    break;
                }
                start = temp[8-(start/pow)+1];
                pow*=10;
            }
            else{
                start = ((start%pow)*10)+(start%10)+1;
            }
        }
        while(start>=low && start<=high){
            res.add(start);
            if(start%10==9){
                if(start/pow==1){
                    break;
                }
                start = temp[8-(start/pow)+1];
                pow*=10;
            }
            else{
                start = ((start%pow)*10)+(start%10)+1;
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		SequentialDigits Res = new SequentialDigits();
		System.out.print(Res.sequentialDigits(N, M));
	}
}
