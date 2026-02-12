import java.util.Scanner;

//21. Merge Two Sorted Lists(Easy)
//--------------------------------
//You are given the heads of two sorted linked lists list1 and list2.
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.
//
//Constraints:
//-----------
//The number of nodes in both lists is in the range [0, 50].
//-100 <= Node.val <= 100
//Both list1 and list2 are sorted in non-decreasing order.

public class MergeTwoSortedLists 
{
	public ListNode mergeTwoLists(ListNode list1, ListNode list2)
	{
		if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode head = null;
        if(list1.val < list2.val){
            head = list1;
            list1 = list1.next;
        }
        else{
            head = list2;
            list2 = list2.next;
        }
        ListNode temp = head;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        while(list1!=null){
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while(list2!=null){
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return head;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ListNode node2 = new ListNode(sc.nextInt(),null);
		ListNode node1 = new ListNode(sc.nextInt(),node2);
		ListNode root1 = new ListNode(sc.nextInt(),node1);
		ListNode node4 = new ListNode(sc.nextInt(),null);
		ListNode node3 = new ListNode(sc.nextInt(),node4);
		ListNode root2 = new ListNode(sc.nextInt(),node3);
		sc.close();
		ListNode temp = root1;
		System.out.println("First list: ");
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
		temp = root2;
		System.out.println("Second list: ");
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		MergeTwoSortedLists Res = new MergeTwoSortedLists();
		temp = Res.mergeTwoLists(root1, root2);
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
}
