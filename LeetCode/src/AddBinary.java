import java.util.Scanner;

//67. Add Binary (Easy)
//---------------------	
//Given two binary strings a and b, return their sum as a binary string.	
//
//Constraints:
//-----------
//1 <= a.length, b.length <= 10^4
//a and b consist only of '0' or '1' characters.
//Each string does not contain leading zeros except for the zero itself.

public class AddBinary 
{
	public String addBinary(String a, String b)
	{
		// int lenA=a.length(), lenB=b.length(), sum=0, carry=0;
        // int i=lenA-1, j=lenB-1, k=Math.max(lenA,lenB);
        // char res[] = new char[k+1];
        // while(i>=0||j>=0||carry!=0){
        //     sum=carry;
        //     if(i>=0){
        //         sum+=(a.charAt(i)-'0');
        //     }
        //     if(j>=0){
        //         sum+=(b.charAt(j)-'0');
        //     }
        //     res[k]=(char)((sum%2)+'0');
        //     carry=sum/2;
        //     i--;
        //     j--;
        //     k--;
        // }
        // if(res[0]=='1'){
        //     return new String(res);
        // }
        // k=Math.max(lenA,lenB);
        // return new String(res,1,k);
		int lenA = a.length(), lenB = b.length(), carry = 0;
		int i = lenA-1, j = lenB-1;
		StringBuilder res = new StringBuilder();
		while(i>=0||j>=0||carry>0) {
			char chA = i>=0?a.charAt(i):'0', chB = j>=0?b.charAt(j):'0';
			if(chA=='0' && chB=='0') {
				if(carry>0) {
					res.append('1');
				}
				else {
					res.append('0');
				}
				carry = 0;
			}
			if(chA=='1' && chB=='1') {
				if(carry>0) {
					res.append('1');
				}
				else {
					res.append('0');
				}
				carry = 1;
			}
			if((chA=='1' && chB=='0') || (chA=='0' && chB=='1')) {
				if(carry>0) {
					res.append('0');
				}
				else {
					res.append('1');
				}
			}
			i--;
			j--;
		}
		if(carry>0) {
			res.append('1');
		}
		return res.reverse().toString();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next(), M = sc.next();
		sc.close();
		AddBinary Res = new AddBinary();
		System.out.print(Res.addBinary(N, M));
	}
}
