import java.util.LinkedHashMap;
import java.util.Scanner;

public class NonRepeatingCharacter 
{
	public char nonRepeatingCharacter (String s) {
		s = s.toLowerCase();
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch,1);
            }
            else{
                hm.put(ch,hm.get(ch)+1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(hm.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		sc.close();
		NonRepeatingCharacter Res = new NonRepeatingCharacter();
		System.out.println(Res.nonRepeatingCharacter(N));
	}
}
