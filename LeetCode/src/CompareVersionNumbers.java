import java.util.Scanner;

//165. Compare Version Numbers (Medium)
//-------------------------------------
//Given two version strings, version1 and version2, compare them.
//A version string consists of revisions separated by dots '.'.
//The value of the revision is its integer conversion ignoring leading zeros.
//To compare version strings, compare their revision values in left-to-right order.
//If one of the version strings has fewer revisions, treat the missing revision values as 0.
//
//Return the following:
//
//If version1 < version2, return -1.
//If version1 > version2, return 1.
//Otherwise, return 0.
//
//Constraints:
//-----------
//1 <= version1.length, version2.length <= 500
//version1 and version2 only contain digits and '.'.
//version1 and version2 are valid version numbers.
//All the given revisions in version1 and version2 can be stored in a 32-bit integer.

public class CompareVersionNumbers 
{
	public int compareVersion(String version1, String version2)
	{
		int i = 0, j = 0;
        int n = version1.length(), m = version2.length();
        while (i<n || j<m) {
            int rev1 = 0, rev2 = 0;
            while (i<n && version1.charAt(i)!='.') {
                rev1 = rev1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            while (j<m && version2.charAt(j)!='.') {
                rev2 = rev2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            if (rev1 < rev2) return -1;
            if (rev1 > rev2) return 1;
            i++;
            j++;
        }
        return 0;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine(), M = sc.nextLine();
		sc.close();
		CompareVersionNumbers Res = new CompareVersionNumbers();
		System.out.print(Res.compareVersion(N, M));
	}
}
