package code;

/* Raúl Barranco C. */
import java.util.*;
import java.lang.*;

public class BucketSort
{

	static void bucketSort(int [] arr)
	{
		int [] hash = getHashValues(arr);

		List<Integer>[] buckets = new List[hash[0]];

		for(int i=0; i<hash[0]; i++)
		{
			buckets[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<arr.length; i++)
		{
			int j = (int)Math.floor( arr[i]/hash[1] );
			buckets[j].add(arr[i]);
		}

		for(List lst: buckets)
		{
			Collections.sort(lst);
		}

		int count = 0;

		for (int i=0; i<buckets.length; i++) 
		{ 
			for (int val : buckets[i]) 
			{ 
				arr[count] = val; 
				count++;
			}
			if(count==arr.length)
				break;
		}

		return;
	}

	static int[] getHashValues(int[] arr)
	{
		int [] hash = new int[2];
		int n = arr.length;

		int max = Integer.MIN_VALUE;

		for(int i=0; i<n; i++)
		{
			if(arr[i]>max)
				max=arr[i];
		}

		int min = Integer.MAX_VALUE;

		for(int i=0; i<n; i++)
		{
			if(arr[i]<min)
				min = arr[i];
		}

		hash[0] = (int)(arr.length*.9);

		hash[1] = (int)Math.ceil( (double)(max+1)/hash[0] );

		return hash;

	}

	public static void main(String[] args) {
		
		int[] arr = {9,7,5,3,1,2,4,6,8,10};

		bucketSort(arr);

		System.out.println("--SORTED--");
		for(int i=0; i<arr.length; i++)
			System.out.print(", "+arr[i]);
		System.out.println();

	}


}