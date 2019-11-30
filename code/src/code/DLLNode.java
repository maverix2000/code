package code;

/* Raúl Barranco C. */
import java.util.*;
import java.lang.*;

public class DLLNode
{
	DLLNode prev;
	DLLNode next;
	int val;

	DLLNode(int val)
	{
		prev = null;
		next = null;
		this.val = val;
	}

	void add(int val)
	{
		DLLNode newnode = new DLLNode(val);
		DLLNode current = this;

		while(current!=null)
		{
			if(current.next == null)
			{
				current.next = newnode;
				newnode.prev = current;
				return;
			}
			current = current.next;
		}

	}

	void remove(int val)
	{
		DLLNode current = this;

		while(current!=null)
		{
			if(current.val == val)
			{
				DLLNode prevNode = current.prev;
				DLLNode nextNode = current.next;

				if(nextNode == null)
				{
					System.out.println("Cannot perform action, the DLLNode you are trying to remove is the head of the DLL.");
					System.out.println("If you want to remove this DLLNode, do: head = null in the main method");
					return;
				}

				if(prevNode==null && nextNode!=null)
				{
					System.out.println("Cannot perform action, the DLLNode you are trying to remove is the head of the DLL.");
					System.out.println("If you want to remove this DLLNode, do: head = head.next in the main method.");
					return;
				}

				prevNode.next = nextNode;
				nextNode.prev = prevNode;
				return;
			}
			current = current.next;
		}

		System.out.println("Doubly Linked List doesn't contain entered value");
		return;

	}


	void printDLLNodes()
	{
		DLLNode current = this;
		while(current!=null)
		{
			if(current.prev==null && current.next==null)
			{
				System.out.println("\n-------------");
				System.out.println("current: "+current.val);
				System.out.println("-------------\n");

			}
			else if(current.prev==null)
			{
				System.out.println("\n-------------");
				System.out.println("current: "+current.val);
				System.out.println("next: "+current.next.val);
				System.out.println("-------------\n");

			}
			else if(current.next==null)
			{
				System.out.println("\n-------------");
				System.out.println("prev: "+current.prev.val);
				System.out.println("current: "+current.val);
				System.out.println("-------------\n");

			}
			else
			{
				System.out.println("\n-------------");
				System.out.println("prev: "+current.prev.val);
				System.out.println("current: "+current.val);
				System.out.println("next: "+current.next.val);
				System.out.println("-------------\n");

			}

			current = current.next;

		}
		System.out.println("*********************");
		return;

	}

	public static void main(String[] args) {
		
		DLLNode head = new DLLNode(0);

		head.add(1);
		head.add(2);
		head.add(3);
		head.add(4);

		System.out.println("Linked List before removing item (3)");
		head.printDLLNodes();

		System.out.println("Linked List after removing item (3)");
		head.remove(3);
		head.printDLLNodes();

		head = null;

	}

}