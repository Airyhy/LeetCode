package Array;

import java.util.*;

//Find the  exclusive of 2 lists

public class ExclusiveOfTwoArrays{



	/**
	 *	Sorted array to get uncommon has duplicate
     */
		void uncommon(int arr1[], int arr2[], int m, int n)
		{
		  List<Integer> ret = new ArrayList<Integer>();
		  int i = 0, j = 0;
		  while (i <= m && j <= n)
		  {
			  if(j==n || i==m){
				  break;
			  }
		    if (j==n || arr1[i] < arr2[j]){
		    	ret.add(arr1[i]);
		    	i++;
		    }
		    else if (i==m || arr2[j] < arr1[i]){
		    	ret.add(arr2[j]);
		    	j++;
		    }
		    else /* if arr1[i] == arr2[j] */
		    {
		      i++;
		      j++;
		    }
		  }
		}


		/**
		 *	unSorted array to get uncommon, no duplicate
		 */
		private Set<Integer>  findUnCommon1(){

			Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4));
			Set<Integer> b = new HashSet<>(Arrays.asList(3, 4, 5, 6));

			for (Integer key: a) {
				if (b.contains(key))
					b.remove(key);
				else
					b.add(key);
			}
			return b;
		}

	/**
	 * No duplicate
     */
		private Set<String>  findUnCommon2( HashSet<String> set1, HashSet<String> set2) {

			Set<String> intersection = new HashSet<String>(set1);
			intersection.retainAll(set2);

			Set<String> difference = new HashSet<String>();
			difference.addAll(set1);
			difference.addAll(set2);
			difference.removeAll(intersection);
            return difference;
		}

		
}