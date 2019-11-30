package code;

/* Raúl Barranco C. */
import java.util.*;
import java.lang.*;

public class TreeNode
{

	int key;
	TreeNode left, right;

	TreeNode(int key)
	{
		this.key = key;
		this.left = null;
		this.right = null;
	}

	public static TreeNode insert(TreeNode xroot, int key)
	{
		if(xroot==null)
		{
			xroot = new TreeNode(key);
			return xroot;
		}
		if(xroot.key > key)
			xroot.left = insert(xroot.left, key);

		else
			xroot.right = insert(xroot.right, key);

		return xroot;

	}

	public static TreeNode createTree(LinkedList<Integer> ll)
	{
		TreeNode yroot = null;
		for(int val: ll)
		{
			yroot = insert(yroot, val);

		}
		return yroot;
	}

	public static void inOrder(TreeNode inOrderRoot)
	{
		if(inOrderRoot!=null)
		{
			inOrder(inOrderRoot.left);
			System.out.print(", "+inOrderRoot.key);
			inOrder(inOrderRoot.right);
		}
	}

	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(9);
		ll.add(7);
		ll.add(5);
		ll.add(3);
		ll.add(1);
		ll.add(2);
		ll.add(4);
		ll.add(6);
		ll.add(8);
		ll.add(10);

		TreeNode zroot = createTree(ll);

		inOrder(zroot);
		System.out.println();

	}

}