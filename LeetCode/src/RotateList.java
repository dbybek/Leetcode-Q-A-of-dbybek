import java.util.Scanner;

//61. Rotate List (Medium)
//------------------------
//Given the head of a linked list, rotate the list to the right by k places.
//Constraints:
//-----------
//The number of nodes in the list is in the range [0, 500].
//-100 <= Node.val <= 100
//0 <= k <= 2 * 10^9

public class RotateList 
{
	public ListNode rotateRight(ListNode head, int k)
	{
		if(k==0 || head==null || head.next==null){
            return head;
        }
        ListNode temp = head;
        int listLen = 0;
        while(temp!=null){
            listLen++;
            temp = temp.next;
        }
        if(k<listLen){
            k = listLen-k;
        }
        else{
            k = k%listLen;
            k = listLen-k;
        }
        if(k==listLen){
            return head;
        }
        k--;
        temp = head;
        ListNode newEnd = null;
        while(temp.next!=null){
            if(k==0){
                newEnd = temp;
            }
            k--;
            temp = temp.next;
        }
        temp.next = head;
        head = newEnd.next;
        newEnd.next = null;
        return head;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ListNode node4 = new ListNode(sc.nextInt());
		ListNode node3 = new ListNode(sc.nextInt(),node4);
		ListNode node2 = new ListNode(sc.nextInt(),node3);
		ListNode node1 = new ListNode(sc.nextInt(),node2);
		ListNode root = new ListNode(sc.nextInt(),node1);
		int K = sc.nextInt();
		sc.close();
		System.out.println("Before rotation: ");
		ListNode temp = root;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		RotateList Res = new RotateList();
		temp = Res.rotateRight(root, K);
		System.out.println("After rotation: ");
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
}
