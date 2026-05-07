import java.util.*;

//874. Walking Robot Simulation (Medium)
//--------------------------------------
//A robot on an infinite XY-plane starts at point (0, 0) facing north.
//The robot receives an array of integers commands, which represents a sequence of moves that it needs to execute.
//There are only three possible types of instructions the robot can receive:
//-2: Turn left 90 degrees.
//-1: Turn right 90 degrees.
//1 <= k <= 9: Move forward k units, one unit at a time.
//Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi).
//If the robot runs into an obstacle,
//it will stay in its current location (on the block adjacent to the obstacle) and move onto the next command.
//
//Return the maximum squared Euclidean distance that the robot reaches at any point in its path
//(i.e. if the distance is 5, return 25).
//
//Note:
//
//There can be an obstacle at (0, 0).
//If this happens, the robot will ignore the obstacle until it has moved off the origin. However,
//it will be unable to return to (0, 0) due to the obstacle.
//North means +Y direction.
//East means +X direction.
//South means -Y direction.
//West means -X direction.
//
//Constraints:
//-----------
//1 <= commands.length <= 10^4
//commands[i] is either -2, -1, or an integer in the range [1, 9].
//0 <= obstacles.length <= 10^4
//-3 * 10^4 <= xi, yi <= 3 * 10^4
//The answer is guaranteed to be less than 2^31.

public class WalkingRobotSimulation 
{
	public int robotSim(int[] commands, int[][] obstacles)
	{
		HashSet<String> hs = new HashSet<>();
		for(int i=0;i<obstacles.length;i++) {
			hs.add(obstacles[i][0]+","+obstacles[i][1]);
		}
		int res = 0, dir = 0, x = 0, y = 0, tempX = 0, tempY = 0;
		int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
		for(int i=0;i<commands.length;i++) {
			if(commands[i]==-1) {
				dir = (dir+1)%4;
			}
			else if(commands[i]==-2) {
				dir = (dir+3)%4;
			}
			else {
				while(commands[i]-- > 0) {
					tempX = x + direction[dir][0];
					tempY = y + direction[dir][1];
					
					if(hs.contains(tempX+","+tempY)) {
						break;
					}
					x = tempX;
					y = tempY;
					
					res = Math.max(res, x*x + y*y);
				}
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
		int M = sc.nextInt();
		int[][] arr1 = new int[M][2];
		for(int i=0;i<M;i++) {
			arr1[i][0] = sc.nextInt();
			arr1[i][1] = sc.nextInt();
		}
		sc.close();
		WalkingRobotSimulation Res = new WalkingRobotSimulation();
		System.out.print(Res.robotSim(arr, arr1));
	}
}
