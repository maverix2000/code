package code;

/* Raúl Barranco C. */
import java.util.*;
import java.lang.*;

public class DoublyLinkedList
{
	Node head;

	class Node
	{

		Node prev;
		Node next;
		int val;

		Node(int val)
		{
			this.val = val;
			prev = null;
			next = null;
		}

	}

	DoublyLinkedList()
	{
		head = null;

	}

	void add(int val)
	{
		Node newnode = new Node(val);

		if(head==null)
		{
			head = newnode;
			return;
		}
		if(head.next == null)
		{
			head.next = newnode;
			newnode.prev = head;
			return;
		}

		Node current = head;

		while(current.next!=null)
		{
			current = current.next;

		}

		current.next = newnode;
		newnode.prev = current;
		newnode.next = null;

		return;
	}

	void remove(int val)
	{
		Node current = head;

		if(current==null)
		{
			System.out.println("DoublyLinkedList is empty");
			return;
		}

		while(current!=null)
		{
			if(current.val == val)
			{
				Node prevNode = current.prev;
				Node nextNode = current.next;

				if(prevNode==null && nextNode==null)
				{
					head = null;
					return;
				}
				if(prevNode==null)
				{
					nextNode.prev = null;
					head = nextNode;
					return;
				}
				if(nextNode==null)
				{
					prevNode.next = null;
					return;
				}

				prevNode.next = nextNode;
				nextNode.prev = prevNode;
				return;
			}
			current = current.next;
		}

		System.out.println("DoublyLinkedList doesn't contain entered value");
		return;

	}

	void printDLL()
	{
		if(head==null)
		{
			System.out.println("This DoublyLinkedList is empty");
			return;
		}

		Node current = head;
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

	}

	public static void main(String[] args) {
		
		DoublyLinkedList DoublyLinkedList = new DoublyLinkedList();

		DoublyLinkedList.add(1);
		DoublyLinkedList.add(2);
		DoublyLinkedList.add(3);
		DoublyLinkedList.add(4);

		System.out.println("Linked List before removing item (3)");
		DoublyLinkedList.printDLL();

		System.out.println("Linked List after removing item (3)");
		DoublyLinkedList.remove(3);
		DoublyLinkedList.printDLL();

	}

}