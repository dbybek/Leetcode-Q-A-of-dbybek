import java.util.*;

//3606. Coupon Code Validator (Easy)
//----------------------------------
//You are given three arrays of length n that describe the properties of n coupons: code, businessLine, and isActive.
//The ith coupon has:
//code[i]: a string representing the coupon identifier.
//businessLine[i]: a string denoting the business category of the coupon.
//isActive[i]: a boolean indicating whether the coupon is currently active.
//A coupon is considered valid if all of the following conditions hold:
//
//code[i] is non-empty and consists only of alphanumeric characters (a-z, A-Z, 0-9) and underscores (_).
//businessLine[i] is one of the following four categories: "electronics", "grocery", "pharmacy", "restaurant".
//isActive[i] is true.
//Return an array of the codes of all valid coupons,
//sorted first by their businessLine in the order: "electronics", "grocery", "pharmacy", "restaurant",
//and then by code in lexicographical (ascending) order within each category.
//
//Constraints:
//-----------
//n == code.length == businessLine.length == isActive.length
//1 <= n <= 100
//0 <= code[i].length, businessLine[i].length <= 100
//code[i] and businessLine[i] consist of printable ASCII characters.
//isActive[i] is either true or false.

public class CouponCodeValidator 
{
	private boolean checkString(String str)
    {
        int n = str.length();
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            if(!(Character.isLetterOrDigit(ch)||ch=='_')){
                return false;
            }
        }
        return true;
    }
	
	public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive)
	{
//		Approach I: Keep a list of valid index and then sort the list. After that add the code values to the result.
//		------------------------------------------------------------------------------------------------------------
		HashMap<String,Integer> hm = new HashMap<>();
        hm.put("electronics",1);
        hm.put("grocery",2);
        hm.put("pharmacy",3);
        hm.put("restaurant",4);
        List<Integer> valid = new ArrayList<>();
        int n = code.length;
        for(int i=0;i<n;i++){
            if(!isActive[i]){
                continue;
            }
            if(!hm.containsKey(businessLine[i])){
                continue;
            }
            if(code[i].isEmpty() || !checkString(code[i])){
                continue;
            }
            valid.add(i);
        }
        valid.sort((i,j)->{
            int x = hm.get(businessLine[i]), y = hm.get(businessLine[j]);
            if(x!=y) return x-y;
            return code[i].compareTo(code[j]);
        });
        List<String> res = new ArrayList<>();
        for(int ele:valid){
            res.add(code[ele]);
        }
        return res;
        
//		Approach II: Keep 4 lists of valid codes based on their businessLine value. Then sort these individual lists 
//                   and add all to 1 single result list.
//		------------------------------------------------------------------------------------------------------------
//        List<String> electronics = new ArrayList<>();
//        List<String> grocery = new ArrayList<>();
//        List<String> pharmacy = new ArrayList<>();
//        List<String> restaurant = new ArrayList<>();
//        
//        for (int i = 0; i < code.length; i++) {
//            if (!isActive[i] || code[i].isEmpty()) {
//            	continue;
//            }
//            
//            boolean validCode = true;
//            if(!checkString(code[i])){
//                validCode = false;
//            }
//            
//            if (validCode) {
//                if (businessLine[i].equals("electronics")) {
//                    electronics.add(code[i]);
//                }
//                else if (businessLine[i].equals("grocery")){
//                    grocery.add(code[i]);
//                }
//                else if (businessLine[i].equals("pharmacy")){
//                    pharmacy.add(code[i]);
//                }
//                else if (businessLine[i].equals("restaurant")){
//                    restaurant.add(code[i]);
//                }
//            }
//        }
//        
//        Collections.sort(electronics);
//        Collections.sort(grocery);
//        Collections.sort(pharmacy);
//        Collections.sort(restaurant);
//        
//        List<String> res = new ArrayList<>();
//        res.addAll(electronics);
//        res.addAll(grocery);
//        res.addAll(pharmacy);
//        res.addAll(restaurant);
//        
//        return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] val = new boolean[2];
		val[0] = true;
		val[1] = false;
		String[] arr = new String[N], arr1 = new String[N];
		boolean[] arr2 = new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextLine();
			arr1[i] = sc.nextLine();
			arr2[i] = val[sc.nextInt()];
		}
		sc.close();
		CouponCodeValidator Res = new CouponCodeValidator();
		System.out.print(Res.validateCoupons(arr, arr1, arr2));
	}
}
