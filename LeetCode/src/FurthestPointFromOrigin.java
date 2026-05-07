import java.util.Scanner;

//2833. Furthest Point From Origin (Easy)
//---------------------------------------
//You are given a string moves of length n consisting only of characters 'L', 'R', and '_'.
//The string represents your movement on a number line starting from the origin 0.
//In the ith move, you can choose one of the following directions:
//move to the left if moves[i] = 'L' or moves[i] = '_'
//move to the right if moves[i] = 'R' or moves[i] = '_'
//Return the distance from the origin of the furthest point you can get to after n moves.
//
//Constraints:
//-----------
//1 <= moves.length == n <= 50
//moves consists only of characters 'L', 'R' and '_'.

public class FurthestPointFromOrigin 
{
	public int furthestDistanceFromOrigin(String moves)
	{
		int res = 0, countL = 0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='_'){
                res++;
            }
            if(moves.charAt(i)=='L'){
                countL++;
            }
        }
        res += Math.abs(moves.length()-res-countL-countL);
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		FurthestPointFromOrigin Res = new FurthestPointFromOrigin();
		System.out.print(Res.furthestDistanceFromOrigin(N));
	}
}
