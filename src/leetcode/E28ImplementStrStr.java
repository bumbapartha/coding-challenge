package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class E28ImplementStrStr {
	public static void main(String[] args) {
		System.out.println(new E28Solution().strStr("xxababaxx", "aa"));
	}
}


class E28Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        
        Map<Character, Integer> needleMap = new HashMap<>();
        Map<Character, Integer> haystackMap = new HashMap<>();
        
        IntStream.range(0, needle.length())
            .forEach( 
            (i) -> {
                addChar(needleMap, needle, i);
                addChar(haystackMap, haystack, i);
            }
        );
        
        
        int i=0;
        do {
            if(matchMap(needleMap, haystackMap)){
                if(checkString(haystack, needle, i)){
                    return i;
                }
            }
            
            i++;
            if(i+needle.length() > haystack.length()){
                break;
            }
            
            addChar(haystackMap, haystack, i+needle.length()-1);
            removeChar(haystackMap, haystack, i-1);
            
        } while(true);
        
        
        return -1;
    }
    
    public void addChar(Map<Character, Integer> needleMap, String needle, int i){
        char needleCh = needle.charAt(i);
        if(needleMap.containsKey(needleCh)) {
            needleMap.put(needleCh, needleMap.get(needleCh)+1);
        }
        else {
            needleMap.put(needleCh, 1);
        }
    }
    
    public void removeChar(Map<Character, Integer> needleMap, String needle, int i){
        char needleCh = needle.charAt(i);
        if(needleMap.containsKey(needleCh)) {
            needleMap.put(needleCh, needleMap.get(needleCh)-1);
        }
        else {
            needleMap.put(needleCh, 0);
        }
    }
    
    public boolean matchMap(Map<Character, Integer> needleMap, Map<Character, Integer> haystackMap){
        for (Map.Entry<Character, Integer> entry : needleMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if(haystackMap.containsKey(key) && haystackMap.get(key) == value){
                
            }
            else {
                return false;
            }
        };
        return true;
    }
    
    public boolean checkString(String haystack, String needle, int start){
        for(int i=start; i<start+needle.length(); i++){
            if(needle.charAt(i-start)!=haystack.charAt(i)){
                return false;
            }
        }
        return true;
    }
    
}