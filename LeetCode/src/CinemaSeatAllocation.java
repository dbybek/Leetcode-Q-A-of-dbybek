import java.util.*;

//1386. Cinema Seat Allocation (Medium)
//-------------------------------------
//A cinema has n rows of seats, numbered from 1 to n. Each row has 10 seats, numbered from 1 to 10.
//You are given a 2D integer array reservedSeats,
//where reservedSeats[i] = [rowi, seati] means that seat seati in row rowi is already reserved.
//A four-person group must be assigned to four seats in the same row.
//The group can be seated in one of the following seat blocks:
//seats 2, 3, 4, 5
//seats 4, 5, 6, 7
//seats 6, 7, 8, 9
//A block can be used only if none of its seats are reserved. Each seat can be assigned to at most one group.
//
//Return an integer denoting the maximum number of four-person groups that can be assigned.
//
//Constraints:
//-----------
//1 <= n <= 10^9
//1 <= reservedSeats.length <= min(10 * n, 10^4)
//reservedSeats[i] == [rowi, seati]
//1 <= rowi <= n
//1 <= seati <= 10
//All reservedSeats[i] are distinct.

public class CinemaSeatAllocation 
{
	public int maxNumberOfFamilies(int n, int[][] reservedSeats)
	{
		HashMap<Integer, Integer> rows = new HashMap<>();
        for (int[] r : reservedSeats) {
            if (r[1] == 1 || r[1] == 10) {
                continue;
            }
            int mask = rows.getOrDefault(r[0], 0);
            mask |= 1 << r[1];
            rows.put(r[0], mask);
        }
        int res = (n - rows.size()) * 2, left = 0, middle = 0, right = 0;
        for (int seat = 2; seat <= 5; seat++) {
            left |= 1 << seat;
        }
        for (int seat = 4; seat <= 7; seat++) {
            middle |= 1 << seat;
        }
        for (int seat = 6; seat <= 9; seat++) {
            right |= 1 << seat;
        }
        for (int ele : rows.values()) {
            boolean leftFree = (ele & left) == 0;
            boolean middleFree = (ele & middle) == 0;
            boolean rightFree = (ele & right) == 0;

            if (leftFree && rightFree) {
                res+=2;
            } 
            else if (leftFree || middleFree || rightFree) {
                res++;
            }
        }
        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] arr = new int[M][2];
		for(int i=0;i<M;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		CinemaSeatAllocation Res = new CinemaSeatAllocation();
		System.out.print(Res.maxNumberOfFamilies(N, arr));
	}
}
