import java.util.*;

//Find the intersection and exclusive of 2 lists

public class IntersectionAndExclusiveOfList{
	

//	Sorted array to get intersection
	void printIntersection(int arr1[], int arr2[], int m, int n)
	{
	  List<Integer> ret = new ArrayList<Integer>();
	  int i = 0, j = 0;
	  while (i < m && j < n)
	  {
	    if (arr1[i] < arr2[j])
	      i++;
	    else if (arr2[j] < arr1[i])
	      j++;
	    else /* if arr1[i] == arr2[j] */
	    {
	    	ret.add(arr1[i]);
	      i++;
	      j++;
	    }
	  }
	}
	
//unsorted array to get intersection	
//	Use map, if duplicate to count the times, and add according to existing time
		private static Set<Character> intersect(char[] a, char[] b) {
	        Set<Character> aSet = new HashSet<Character>();
	        Set<Character> intersection = new HashSet<Character>();
	        for (char c : a) {
	            aSet.add(c);
	        }
	        for (char c : b) {
	            if (aSet.contains(c)) {
	                intersection.add(c);
	            }
	        }
	        return intersection;
	}

		private static Set<Character> intersect1(char[] a, char[] b) {
			Collection listOne = new ArrayList(Arrays.asList("milan","dingo", "elpha", "hafil", "meat", "iga", "neeta.peeta"));
			Collection listTwo = new ArrayList(Arrays.asList("hafil", "iga", "binga", "mike", "dingo"));

			listOne.retainAll( listTwo );
			return listOne;
	}

		
//		Sorted array to get uncommon
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
//		unsorted array not in common
		private Set<Integer>  findUnCommon{

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
		
		
		private Set<Integer> result findUnCommon{

			Set<String> intersection = new HashSet<String>(set1);
			intersection.retainAll(set2);

			Set<String> difference = new HashSet<String>();
			difference.addAll(set1);
			difference.addAll(set2);
			difference.removeAll(intersection);
		}
		
}