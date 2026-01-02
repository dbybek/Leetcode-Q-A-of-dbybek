import java.util.Scanner;

//1051. Height Checker (Easy)
//---------------------------
//A school is trying to take an annual photo of all the students.
//The students are asked to stand in a single file line in non-decreasing order by height.
//Let this ordering be represented by the integer array expected where expected[i] is
//the expected height of the ith student in line.
//You are given an integer array heights representing the current order that the students are standing in.
//Each heights[i] is the height of the ith student in line (0-indexed).
//
//Return the number of indices where heights[i] != expected[i].
//
//Constraints:
//-----------
//1 <= heights.length <= 100
//1 <= heights[i] <= 100

public class HeightChecker 
{
	public int heightChecker(int[] heights)
	{
		int[] freq = new int[101];
        for(int ele:heights){
            freq[ele]++;
        }
        int res = 0, ind = 0;
        for(int i=1;i<101;i++){
            if(freq[i]==0){
                continue;
            }
            while(freq[i]>0){
                if(heights[ind]!=i){
                    res++;
                }
                ind++;
                freq[i]--;
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		HeightChecker Res = new HeightChecker();
		System.out.print(Res.heightChecker(arr));
	}
}
