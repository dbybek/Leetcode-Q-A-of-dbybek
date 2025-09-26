import java.util.Scanner;
import java.util.HashMap;

//166. Fraction to Recurring Decimal (Medium)
//-------------------------------------------
//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//If the fractional part is repeating, enclose the repeating part in parentheses.
//If multiple answers are possible, return any of them.
//It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
//
//Constraints:
//-----------
//-2^31 <= numerator, denominator <= 2^31 - 1
//denominator != 0

public class FractionToRecurringDecimal 
{
	public String fractionToDecimal(int numerator, int denominator)
	{
		if(numerator==0) {
			return "0";
		}
		StringBuilder res = new StringBuilder();
		if((numerator < 0) ^ (denominator < 0)) {
			res.append("-");
		}
		long num = Math.abs((long)(numerator)), deno = Math.abs((long)(denominator));
		res.append(num/deno);
		long remainder = num%deno;
		if(remainder==0) {
			return res.toString();
		}
		res.append(".");
		HashMap<Long,Integer> hm = new HashMap<>();
		while(remainder!=0) {
			if(hm.containsKey(remainder)) {
				int index = hm.get(remainder);
				res.insert(index, "(");
				res.append(")");
				return res.toString();
			}
			hm.put(remainder, res.length());
			remainder *= 10;
			res.append(remainder/deno);
			remainder %= deno;
		}
		return res.toString();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		FractionToRecurringDecimal Res = new FractionToRecurringDecimal();
		System.out.print(Res.fractionToDecimal(N, M));
	}
}
