import java.util.Scanner;

//1689. Partitioning Into Minimum Number Of Deci-Binary Numbers (Medium)
//----------------------------------------------------------------------
//A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
//For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
//Given a string n that represents a positive decimal integer,
//return the minimum number of positive deci-binary numbers needed so that they sum up to n.
//
//Constraints:
//-----------
//1 <= n.length <= 10^5
//n consists of only digits.
//n does not contain any leading zeros and represents a positive integer.

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers 
{
	public int minPartitions(String n) 
	{
//		Approach I: Checking the string for the max integer by traversing the string.
//		-----------------------------------------------------------------------------
//        int res = 0;
//        for(int i=0;i<n.length();i++) {
//        	res = Math.max(res, n.charAt(i)-'0');
//        }
//        return res;
//		
//		Approach II: Checking the string for the max integer by traversing from 9 to 0 digits and running inbuilt methods.
//		------------------------------------------------------------------------------------------------------------------
		for(int i=9;i>=0;i--) {
			if(n.contains(Integer.toString(i))) {
				return i;
			}
		}
		return -1;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		PartitioningIntoMinimumNumberOfDeciBinaryNumbers Res = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();
		System.out.print(Res.minPartitions(str));
	}

}
