package code;

/* Raúl Barranco C. */
import java.util.*;
import java.lang.*;

public class RecursiveInsertionSort
{

	private static void recursiveInsertionSort(int[] arr, int count)
	{
		if(count==(arr.length))
			return;

		for(int i=count; i>0; i--)
		{
			if(arr[i]<arr[i-1])
			{
				int temp = arr[i-1];
				arr[i-1] = arr[i];
				arr[i] = temp;
			}

		}
		count++;

		recursiveInsertionSort(arr, count);

	}


	public static void main(String[] args) {

		int[] arr = {5,3,1,2,4};

		recursiveInsertionSort(arr, 1);

		System.out.println("--SORTED--");
		for(int i=0; i<arr.length; i++)
			System.out.print(", "+arr[i]);
		System.out.println();

	}


}