package leetcode.algo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class M784LetterCasePermutation {
	
	public static void main(String[] args) {
		List<String>  list = new M784LetterCasePermutation(). new Solution().letterCasePermutation("a1bc", false);
		list.stream().forEach(System.out::println);
	}
	
	class Solution {
	    public List<String> letterCasePermutation(String s) {
	    	List<StringBuilder> list = letterCasePermutation(s.toLowerCase(), s.length());
			return list.stream().map(sb -> sb.toString()).toList();
	    }
	    
	    
	    
	     
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    /* without backtracking */
	    
	    
	    public List<String> letterCasePermutation(String s, boolean nonBackTracking) {
	    	List<StringBuilder> list = letterCasePermutation(s.toLowerCase(), s.length());
			return list.stream().map(sb -> sb.toString()).toList();
	    }
	    public List<StringBuilder> letterCasePermutation(String s, int n) {
	    	if(n==1) {
	    		List<StringBuilder> newList = new LinkedList<>();
	    		StringBuilder lowerSb = new StringBuilder(s);
	    		newList.add(lowerSb);
	    		char lowerCh = s.charAt(0);
	    		if(Character.isAlphabetic(lowerCh)) {
	    			char upperCh = Character.toUpperCase(lowerCh);
		    		StringBuilder uperSb = new StringBuilder(lowerSb);
		    		uperSb.setCharAt(0, upperCh);
		    		newList.add(uperSb);
	    		}
	    		return newList;
	    	}
	    	else {
	    		List<StringBuilder> sbList = letterCasePermutation(s, n-1);
	    		char lowerCh = s.charAt(n-1);
	    		if(Character.isAlphabetic(lowerCh)) {
	    			char upperCh = Character.toUpperCase(lowerCh);
		    		List<StringBuilder> newList = new LinkedList<>();
		    		for (Iterator<StringBuilder> iterator = sbList.iterator(); iterator.hasNext();) {
						StringBuilder uperSb = new StringBuilder((StringBuilder) iterator.next());
						uperSb.setCharAt(n-1, upperCh);
						newList.add(uperSb);
					}
		    		sbList.addAll(newList);
	    		}
	    		return sbList;
	    	}
	    }
	}
}
