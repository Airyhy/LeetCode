
//find first character in string duplicate/not duplicate
import java.util.*;
import java.util.Map.Entry;
public class FirstCharacter{
	
//	method 1
public Character firstNonRepeatingChar1(String str) {
		Map<Character,Integer> counts = new LinkedHashMap<>(); 
		for (char c : str.toCharArray()) { 
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1); 
		} 
	
		for (Entry<Character,Integer> entry : counts.entrySet()) 
		{ 
			if (entry.getValue() == 1) 
			{ 
				return entry.getKey(); 
			} 
		}
		return null;
	}
	
//method2
public static Character firstNonRepeatingChar2(String word) { 
	Set<Character> repeating = new HashSet<>(); 
	List<Character> nonRepeating = new ArrayList<>(); 
	for (int i = 0; i < word.length(); i++) { 
		char letter = word.charAt(i); 
		if (repeating.contains(letter)) { 
			continue; 
		} 
		if (nonRepeating.contains(letter)) { 
			nonRepeating.remove((Character) letter); 
			repeating.add(letter); 
		} 
		else { 
			nonRepeating.add(letter); 
		} 
	} 
	if(nonRepeating.size()<1) return null;
	return nonRepeating.get(0); 
}

public static int findDuplicate(String s) {
    char[] chars = s.toCharArray();
    Map<Character, Integer> uniqueChars = new HashMap<Character, Integer> (chars.length, 1);
    for (int i = 0; i < chars.length; i++) {
        Integer previousIndex = uniqueChars.put(chars[i], i);
        if (previousIndex != null) {
            return previousIndex;
        }
    }
    return -1;
}
}