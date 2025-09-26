import java.util.Scanner;

//2785. Sort Vowels in a String (Medium)
//--------------------------------------
//Given a 0-indexed string s, permute s to get a new string t such that:
//All consonants remain in their original places. More formally,
//if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
//The vowels must be sorted in the nondecreasing order of their ASCII values.
//More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels,
//then t[i] must not have a higher ASCII value than t[j].
//Return the resulting string.
//
//The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase.
//Consonants comprise all letters that are not vowels.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s consists only of letters of the English alphabet in uppercase and lowercase.

public class SortVowelsInAString 
{
	public String sortVowels(String s)
	{
		int n = s.length();
		StringBuilder res = new StringBuilder();
		int[] vowelCount = new int[10];
		for(int i=0;i<n;i++) {
			char ch = s.charAt(i);
			vowelCount[0] = (ch=='A')?vowelCount[0]+1:vowelCount[0]+0;
			vowelCount[1] = (ch=='E')?vowelCount[1]+1:vowelCount[1]+0;
			vowelCount[2] = (ch=='I')?vowelCount[2]+1:vowelCount[2]+0;
			vowelCount[3] = (ch=='O')?vowelCount[3]+1:vowelCount[3]+0;
			vowelCount[4] = (ch=='U')?vowelCount[4]+1:vowelCount[4]+0;
			vowelCount[5] = (ch=='a')?vowelCount[5]+1:vowelCount[5]+0;
			vowelCount[6] = (ch=='e')?vowelCount[6]+1:vowelCount[6]+0;
			vowelCount[7] = (ch=='i')?vowelCount[7]+1:vowelCount[7]+0;
			vowelCount[8] = (ch=='o')?vowelCount[8]+1:vowelCount[8]+0;
			vowelCount[9] = (ch=='u')?vowelCount[9]+1:vowelCount[9]+0;
			if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' || ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
				res.append(' ');
			}
			else {
				res.append(ch);
			}
		}
		int j=0;
		for(int i=0;i<10;i++) {
			while(j<n && vowelCount[i]>0) {
				if(res.charAt(j)==' ') {
					if(i==0) {
						res.setCharAt(j, 'A');
					}
					if(i==1) {
						res.setCharAt(j, 'E');
					}
					if(i==2) {
						res.setCharAt(j, 'I');
					}
					if(i==3) {
						res.setCharAt(j, 'O');
					}
					if(i==4) {
						res.setCharAt(j, 'U');
					}
					if(i==5) {
						res.setCharAt(j, 'a');
					}
					if(i==6) {
						res.setCharAt(j, 'e');
					}
					if(i==7) {
						res.setCharAt(j, 'i');
					}
					if(i==8) {
						res.setCharAt(j, 'o');
					}
					if(i==9) {
						res.setCharAt(j, 'u');
					}
					vowelCount[i]--;
				}
				j++;
			}
		}
		return res.toString();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		SortVowelsInAString Res = new SortVowelsInAString();
		System.out.print(Res.sortVowels(N));
	}
}
