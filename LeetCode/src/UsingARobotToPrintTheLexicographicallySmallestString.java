import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

//2434. Using a Robot to Print the Lexicographically Smallest String (Medium)
//---------------------------------------------------------------------------
//You are given a string s and a robot that currently holds an empty string t.
//Apply one of the following operations until s and t are both empty:
//
//Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
//Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
//Return the lexicographically smallest string that can be written on the paper.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s consists of only English lowercase letters.

public class UsingARobotToPrintTheLexicographicallySmallestString 
{
	
	private boolean smallerChar(int top,int[] freq) 
	{
		for(int i=0;i<top;i++) {
			if(freq[i]>0)
				return true;
		}
		return false;
	}
	
	public String robotWithString(String s) 
	{
        int n = s.length();
        int[] freq = new int[26];
        for(int i=0;i<n;i++) {
        	char ch = s.charAt(i);
        	freq[ch-'a']++;
        }
        
        StringBuilder res = new StringBuilder();
        Deque<Integer> stk = new ArrayDeque<>();
        
        for(int i=0;i<n;i++) {
        	int ch = s.charAt(i)-'a';
        	freq[ch]--;
        	stk.push(ch);
        	
        	while(!stk.isEmpty() && !smallerChar(stk.peek(),freq)) {
        		res.append((char)(stk.pop()+'a'));
        	}
        }
        
        return res.toString();
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		UsingARobotToPrintTheLexicographicallySmallestString Res = new UsingARobotToPrintTheLexicographicallySmallestString();
		System.out.print(Res.robotWithString(str));
	}

}
