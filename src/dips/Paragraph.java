package dips;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Paragraph {
	
	public List<String> wordlist(String para) {
		
		Pattern p = Pattern.compile("[ ,.]");		
		String[] array = para.split(p.pattern());
		return Arrays.stream(array).sorted(
				new Comparator<String>() {
					@Override
					public int compare(String s1, String s2) {
						return s2.length() - s1.length();
					}
					
				}
			).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		Paragraph para = new Paragraph();
		List<String> arr = para.wordlist("We have learned all the Java tricks like basic manipulation of String, I"
				+ "nteger and Characters, Selenium Codes, Reading Data from a File, "
				+ "Mathematical Series through codes and now you do have ample idea of how to go about any "
				+ "Java Interview.");
		
		
		for(String s : arr) {
			System.out.println(s);
		}
	}

}
 