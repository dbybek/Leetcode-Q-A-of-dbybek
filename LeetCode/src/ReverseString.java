import java.util.Scanner;

//344. Reverse String (Easy)
//--------------------------
//Write a function that reverses a string. The input string is given as an array of characters s.
//You must do this by modifying the input array in-place with O(1) extra memory.
//
//Constraints:
//-----------
//1 <= s.length <= 10^5
//s[i] is a printable ascii character.

public class ReverseString 
{
	public void reverseString(char[] s)
	{
		int i = 0, j = s.length - 1;
        while(i<j){
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
        return;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] arr = new char[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.next().charAt(0);
		}
		sc.close();
		System.out.println("Before reversing the array: ");
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		ReverseString Res = new ReverseString();
		Res.reverseString(arr);
		System.out.println("After reversing the array: ");
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
