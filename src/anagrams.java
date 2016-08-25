//https://leetcode.com/problems/anagrams/
import java.util.*;

public class anagrams1 {
	
//	Find if two words are anagrams of each other
	   public boolean isAnagram(String s, String t) {
	        int[] alphabet = new int[26];
	        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
	        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
	        for (int i : alphabet) if (i != 0) return false;
	        return true;
	    }
	
	//group anagrams, find the anagrams in a group and print out each line	
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        Map<String,List<String>> map= new HashMap();
        Arrays.sort(strs);
        for(String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String cont = new String(temp);
            if(map.containsKey(cont)==false){
                List<String> one = new ArrayList();
                one.add(str);
                result.add(one);
                map.put(cont,one);
              //  System.out.println("bbb");
            }
            else{
                //System.out.println("aaa");
                map.get(cont).add(str);
            }
        }
        return result;
    }
}

//group anagrams, find the anagrams in a group and print out each line	

public class anagrams2 {
   public List<String> anagrams(String[] strs){
		List<String> result = new ArrayList<String>();
		if(strs==null || strs.length==0){
			return result;
		}
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		int len = strs.length;
		for(int i=0; i<len; i++){
			//sort the string
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String s = new String(c);
			//store sorted string and its anagrams
			if(!map.containsKey(s)){
				ArrayList<String> anagrams = new ArrayList<String>();
				anagrams.add(strs[i]);
				map.put(s,anagrams);
			}else{
				map.get(s).add(strs[i]);
			}
		}

		Iterator iter = map.values().iterator();
		while(iter.hasNext()){
			ArrayList<String> value = (ArrayList<String>)iter.next();
			//store strings with more than one anagrams
			if(value.size() > 1){
				result.addAll(value);
			}
		}
		return result;
	}
}