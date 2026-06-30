import java.util.Scanner;

//2126. Destroying Asteroids (Medium)
//-----------------------------------
//You are given an integer mass, which represents the original mass of a planet.
//You are further given an integer array asteroids, where asteroids[i] is the mass of the ith asteroid.
//You can arrange for the planet to collide with the asteroids in any arbitrary order.
//If the mass of the planet is greater than or equal to the mass of the asteroid,
//the asteroid is destroyed and the planet gains the mass of the asteroid. Otherwise, the planet is destroyed.
//
//Return true if all asteroids can be destroyed. Otherwise, return false.
//Constraints:
//-----------
//1 <= mass <= 10^5
//1 <= asteroids.length <= 10^5
//1 <= asteroids[i] <= 10^5

public class DestroyingAsteroids 
{
	public boolean asteroidsDestroyed(int mass, int[] asteroids)
	{
		int mx = 0;
        // int[] freq = new int[100001];
        for(int i=0;i<asteroids.length;i++){
            // freq[asteroids[i]]++;
            mx = Math.max(asteroids[i],mx);
        }
        int[] freq = new int[mx+1];
        for(int i=0;i<asteroids.length;i++){
            freq[asteroids[i]]++;
        }
        for(int i=1;i<=mx;i++){
            while(freq[i]>0){
                if(mass<i){
                    return false;
                }
                mass+=i;
                freq[i]--;
                if(mass>=100000){
                    return true;
                }
            }
        }
        return true;
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
		int k = sc.nextInt();
		sc.close();
		DestroyingAsteroids Res = new DestroyingAsteroids();
		System.out.print(Res.asteroidsDestroyed(k, arr));
	}
}
