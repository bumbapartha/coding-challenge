package dsacourse;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class StringPalindromCheck {
	
	private static boolean isPalindrom(String str) {
		return isPalindrom(str, 0, str.length()-1);
	}
	
	
	private static boolean isPalindrom(String str, int start, int end) {
		if(end <= start) {
			return true;
		}
		if(str.charAt(start)== str.charAt(end)) {
			return isPalindrom(str, start+1, end-1);
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		assertTrue(isPalindrom("racecar"));
		assertTrue(isPalindrom("a"));
		assertTrue(isPalindrom("aa"));
		assertTrue(isPalindrom("aaa"));
		assertTrue(isPalindrom("aba"));
		assertTrue(isPalindrom("abba"));
		assertTrue(isPalindrom("abcba"));
		
		assertFalse(isPalindrom("ab"));
		assertFalse(isPalindrom("abc"));
		assertFalse(isPalindrom("race12ecar"));
		
		System.out.println("All Case Passed");
	}
}
