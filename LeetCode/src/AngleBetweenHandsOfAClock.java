import java.util.Scanner;

//1344. Angle Between Hands of a Clock (Medium)
//---------------------------------------------
//Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
//Answers within 10-5 of the actual value will be accepted as correct.
//
//Constraints:
//-----------
//1 <= hour <= 12
//0 <= minutes <= 59

public class AngleBetweenHandsOfAClock 
{
	public double angleClock(int hour, int minutes)
	{
		double hAngle = (((double)hour%12)*30) + minutes*0.5, mAngle = minutes*6.0;
        double diff = Math.abs(hAngle-mAngle);
        return Math.min(diff,360-diff);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.close();
		AngleBetweenHandsOfAClock Res = new AngleBetweenHandsOfAClock();
		System.out.print(Res.angleClock(N, M));
	}
}
