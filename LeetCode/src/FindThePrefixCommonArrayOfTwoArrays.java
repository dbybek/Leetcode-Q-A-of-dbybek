import java.util.Scanner;

//2657. Find the Prefix Common Array of Two Arrays(Medium)
//--------------------------------------------------------
//You are given two 0-indexed integer permutations A and B of length n.
//A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present
//at or before the index i in both A and B.
//Return the prefix common array of A and B.
//
//A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
//
//Constraints:
//-----------
//1 <= A.length == B.length == n <= 50
//1 <= A[i], B[i] <= n
//It is guaranteed that A and B are both a permutation of n integers.

public class FindThePrefixCommonArrayOfTwoArrays 
{
	public int[] findThePrefixCommonArray(int[] A, int[] B)
	{
		int[] res = new int[A.length];
        int[] freq = new int[A.length+1];
        int count=0;
        for(int i=0;i<A.length;i++){
            if(++freq[A[i]]==2){
                count++;
            }
            if(++freq[B[i]]==2) {
                count++;
            }
            res[i] = count;
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr1 = new int[N];
		for(int i=0;i<N;i++) {
			arr1[i] = sc.nextInt();
		}
		int[] arr2 = new int[N];
		for(int i=0;i<N;i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();
		FindThePrefixCommonArrayOfTwoArrays Res = new FindThePrefixCommonArrayOfTwoArrays();
		int[] arr3 = Res.findThePrefixCommonArray(arr1, arr2);
		for(int i=0;i<N;i++) {
			System.out.print(arr3[i]+" ");
		}
	}
}
