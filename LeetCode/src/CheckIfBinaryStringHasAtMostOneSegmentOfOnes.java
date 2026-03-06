import java.util.Scanner;

//1784. Check if Binary String Has at Most One Segment of Ones (Easy)
//-------------------------------------------------------------------
//Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones.
//Otherwise, return false.
//
//Constraints:
//-----------
//1 <= s.length <= 100
//s[i]​​​​ is either '0' or '1'.
//s[0] is '1'.

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes 
{
	public boolean checkOnesSegment(String s)
	{
//		Approach I: Take a nested loop to calculate the length of the first sequence of consecutive '1's.
//		            Then compare it with the total number of '1's.
//		-------------------------------------------------------------------------------------------------
//		int contSeg = 0, count = 0;
//        for(int i=0;i<s.length();i++){
//            while(i<s.length() && s.charAt(i)=='1'){
//                if(contSeg==0){
//                    count++;
//                    i++;
//                }
//                else{
//                    return false;
//                }
//            }
//            contSeg = count;
//        }
//        return contSeg==count;
//        
//		Approach II: Take a loop and check if there exists a sub string "01". If exists then return false else true.
//------------------------------------------------------------------------------------------------------------------
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)=='0' && s.charAt(i+1)=='1'){
                return false;
            }
        }
        return true;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes Res = new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
		System.out.print(Res.checkOnesSegment(N));
	}
}
