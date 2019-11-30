package code;

import java.util.*;
import java.lang.*;

public class CocktailSort
{

	static void cocktailSort(int[] arr)
	{
		int aux = -1;

		int ini_pivot = 0;
		int fin_pivot = arr.length-2;
		int incount = 0;
		boolean swap = true;
		for(int i=0; i<arr.length-1; i++)
		{
			boolean even = true;
			boolean stop = true;
			if((i&1)==0)
			{
				even = true;
				aux=i;
			}
			else
			{
				even = false;
				aux=arr.length-i-1;
			}

			incount = ini_pivot;
			swap = false;

			while(true)
			{
				if(even==true)
				{
					if(arr[incount]>arr[incount+1])
					{
						int temp = arr[incount];
						arr[incount] = arr[incount+1];
						arr[incount+1] = temp;
						swap = true;

					}

					if(incount==fin_pivot)
							break;
					incount++;
				}
				else
				{
					if(arr[incount]<arr[incount-1])
					{
						int temp = arr[incount-1];
						arr[incount-1] = arr[incount];
						arr[incount] = temp;
						swap = true;

					}
					if(incount==fin_pivot)
							break;
					incount--;
				}

			}

			if(swap == false)
				break;
			if(even)
			{
				int temp = ini_pivot+1;
				ini_pivot = fin_pivot;
				fin_pivot = temp;
			}
			else
			{
				int temp = ini_pivot-1;
				ini_pivot = fin_pivot;
				fin_pivot = temp;
			}

			System.out.println("Iteration: "+i);
			for(int k=0; k<arr.length; k++)
				System.out.print(", "+arr[k]);
			System.out.println("\n");
			
		}

	}


	public static void main(String[] args) {
		

		int [] arr = {11,10,9,8,7,6,5,4,3,2,-1};

		cocktailSort(arr);

		System.out.println("\n\n --SORTED--");
		for(int i=0; i<arr.length; i++)
			System.out.print(", "+arr[i]);
		System.out.println();


	}

}