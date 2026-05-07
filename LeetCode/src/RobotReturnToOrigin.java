import java.util.Scanner;

//657. Robot Return to Origin (Easy)
//----------------------------------
//There is a robot starting at the position (0, 0), the origin, on a 2D plane.
//Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
//You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move.
//Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
//Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.
//Note: The way that the robot is "facing" is irrelevant.
//'R' will always make the robot move to the right once, 'L' will always make it move left, etc.
//Also, assume that the magnitude of the robot's movement is the same for each move.
//
//Constraints:
//-----------
//1 <= moves.length <= 2 * 104
//moves only contains the characters 'U', 'D', 'L' and 'R'.

public class RobotReturnToOrigin 
{
	public boolean judgeCircle(String moves)
	{
		// int countU = 0, countL = 0;
        // for(int i=0;i<moves.length();i++){
        //     char ch = moves.charAt(i);
        //     if(ch=='U'){
        //         countU++;
        //     }
        //     if(ch=='D'){
        //         countU--;
        //     }
        //     if(ch=='L'){
        //         countL++;
        //     }
        //     if(ch=='R'){
        //         countL--;
        //     }
        // }
        // return countU==0 && countL==0;
		int[] freq = new int[26];
        for(int i=0;i<moves.length();i++){
            freq[moves.charAt(i)-'A']++;
        }
        return freq[20]==freq[3] && freq[11]==freq[17];
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		RobotReturnToOrigin Res = new RobotReturnToOrigin();
		System.out.print(Res.judgeCircle(str));
	}
}
