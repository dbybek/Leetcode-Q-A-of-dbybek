import java.util.Scanner;

//3516. Find Closest Person (Easy)
//--------------------------------
//You are given three integers x, y, and z, representing the positions of three people on a number line:
//x is the position of Person 1.
//y is the position of Person 2.
//z is the position of Person 3, who does not move.
//Both Person 1 and Person 2 move toward Person 3 at the same speed.
//
//Determine which person reaches Person 3 first:
//
//Return 1 if Person 1 arrives first.
//Return 2 if Person 2 arrives first.
//Return 0 if both arrive at the same time.
//Return the result accordingly.
//
//Constraints:
//-----------
//1 <= x, y, z <= 100

public class FindClosestPerson 
{
	public int findClosest(int x, int y, int z)
	{
		int diff1 = Math.abs(x-z), diff2 = Math.abs(y-z);
        if(diff1==diff2){
            return 0;
        }
        return (diff1<diff2)?1:2;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
		sc.close();
		FindClosestPerson Res = new FindClosestPerson();
		System.out.print(Res.findClosest(N, M, K));
	}
}
