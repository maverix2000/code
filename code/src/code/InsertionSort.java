package code;

/* Raùl Barranco C. */
import java.util.*;
import java.lang.*;

public class InsertionSort
{
	private static void insertionSort(int[] arr)
	{
		for(int i=0; i<arr.length-1; i++)
		{
			for(int j=i+1; j>0; j--)
			{
				if(arr[j]<arr[j-1])
				{
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		
		int[] arr = {5,3,1,2,4,};

		insertionSort(arr);

		System.out.println("--SORTED--");
		for(int i=0; i<arr.length; i++)
			System.out.print(", "+arr[i]);
		System.out.println();

	}
}