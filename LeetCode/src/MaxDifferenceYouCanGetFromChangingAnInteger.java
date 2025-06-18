import java.util.Scanner;

//1432. Max Difference You Can Get From Changing an Integer (Medium)
//------------------------------------------------------------------
//You are given an integer num. You will apply the following steps to num two separate times:
//
//Pick a digit x (0 <= x <= 9).
//Pick another digit y (0 <= y <= 9). Note y can be equal to x.
//Replace all the occurrences of x in the decimal representation of num by y.
//Let a and b be the two results from applying the operation to num independently.
//
//Return the max difference between a and b.
//
//Note that neither a nor b may have any leading zeros, and must not be 0.
//
//Constraints:
//-----------
//1 <= num <= 10^8

public class MaxDifferenceYouCanGetFromChangingAnInteger 
{

	public int maxDiff(int num)
	{
		String str = Integer.toString(num), str2 = Integer.toString(num);
		int n = str.length(), i = 0;
        char ch = ' ';
        while(i<n) {
			if(str.charAt(i) != '1' && str.charAt(i) != '0') {
				ch = str.charAt(i);
				break;
			}
            i++;
		}
        if(i==0){
            str2 = str2.replace(ch, '1');
        }
        else if (i<n) {
            str2 = str2.replace(ch, '0');
        }
		int mn = Integer.parseInt(str2);
		ch = ' ';
        i = 0;
		while(i<n) {
			if(str.charAt(i) != '9') {
				ch = str.charAt(i);
				break;
			}
            i++;
		}
		if(ch==' ') {
			return num-1;
		}
		str = str.replace(ch, '9');
		int mx = Integer.parseInt(str);
		return mx-mn;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		MaxDifferenceYouCanGetFromChangingAnInteger Res = new MaxDifferenceYouCanGetFromChangingAnInteger();
		System.out.print(Res.maxDiff(N));
	}

}
