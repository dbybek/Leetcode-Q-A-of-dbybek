import java.util.*;

//1290. Convert Binary Number in a Linked List to Integer(Easy)
//-------------------------------------------------------------
//Given head which is a reference node to a singly-linked list.
//The value of each node in the linked list is either 0 or 1.
//The linked list holds the binary representation of a number.
//Return the decimal value of the number in the linked list.
//
//The most significant bit is at the head of the linked list.
//
//Constraints:
//-----------
//The Linked List is not empty.
//Number of nodes will not exceed 30.
//Each node's value is either 0 or 1.

public class ConvertBinaryNumberInALinkedListToInteger 
{
	public int getDecimalValue(ListNode head)
	{
		StringBuilder sb = new StringBuilder();
		ListNode temp = head;
		while(temp!=null) {
			sb.append((char)temp.val);
			temp = temp.next;
		}
		int res = 0, base = 1;
		for(int i=sb.length()-1;i>=0;i--) {
			res += (sb.charAt(i)*base);
			base *= 2;
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ListNode n2 = new ListNode(sc.nextInt(),null);
		ListNode n1 = new ListNode(sc.nextInt(),n2);
		ListNode root = new ListNode(sc.nextInt(),n1);
		sc.close();
		ConvertBinaryNumberInALinkedListToInteger Res = new ConvertBinaryNumberInALinkedListToInteger();
		System.out.print(Res.getDecimalValue(root));
	}
}
