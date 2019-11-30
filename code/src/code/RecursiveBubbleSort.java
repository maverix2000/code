package code;

import java.util.*;
import java.lang.*;

public class RecursiveBubbleSort
{

	public static void recursiveBubbleSort(int[] arr, int count)
	{
		if(count==arr.length)
			return;

		for(int i=0; i<arr.length-count-1; i++)
		{
			if(arr[i]>arr[i+1])
			{
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		count++;
		recursiveBubbleSort(arr, count);
		
	}

	public static void main(String[] args) {

		int [] arr = {5,3,1,2,4};

		recursiveBubbleSort(arr, 0);

		for(int i=0; i<arr.length; i++)
			System.out.print(", "+arr[i]);
		System.out.println();

	}
}