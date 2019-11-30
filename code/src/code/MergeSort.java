package code;

/* Raùl Barranco C. */
import java.util.*;
import java.lang.*;

public class MergeSort
{

	public static void mergeSort(int[] arr, int l, int r)
	{
		int m = (int)Math.floor((l+r)/2);

		mergeSort(arr, l, m);

		mergeSort(arr, m+1, r);

		merge(arr, l, m, r);

	}

	public static void merge(int [] arr, int l, int m, int r)
	{
		if(l==r)
			return;

		if((l+1)==r)
		{
			if(arr[l]>arr[r])
			{
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
		}

		int sum = r-l+1;
		int [] arrtemp = new int[sum];
		int pos = 0;
		int max = sum-1;
		int x = l;
		int y = m+1;
		int countx = 0;
		int county = 0;
		int sizex = m-l+1;
		int sizey = r-m+1;
		boolean banderax = false;
		boolean banderay = false;

		for(int i=0; i<max; i++)
		{
			if(arr[x]<arr[y])
			{
				arrtemp[i] = arr[x];
				x++;
				countx++;
			}
			else if(arr[x]>arr[y])
			{
				arrtemp[i] = arr[y];
				y++;
				county++;
			}
			if(x>m)
			{
				banderax = true;
				pos++;
				break;
			}
			if(y>r)
			{
				banderay = true;
				pos++;
				break;
			}
			pos++;

		}

		if(banderax==true)
		{
			for(int i=pos; i<arrtemp.length; i++)
			{
				arrtemp[i] = arr[y];
				y++;
			}
		}

		else if(banderay==true)
		{
			for(int i=pos; i<arrtemp.length; i++)
			{
				arrtemp[i] = arr[x];
				x++;
			}
		}

		int j=0;
		for(int i=l; i<=r; i++)
		{
			arr[i] = arrtemp[j];
			j++;
		}

		return;

	}
	
	public static void main(String[] args) {
		
		int [] arr = {1,3,5,7,9,2,4,6,8,10};

		merge(arr, 0, 4, 9);

		System.out.println("\narr-SORTED-:");
		for(int val: arr)
			System.out.print(", "+val);
		System.out.println();

	}

}