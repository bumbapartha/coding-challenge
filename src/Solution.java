import java.util.*;

public class Solution {

  static boolean canFormPalindrome(char[] blocks, int left, int right, List<Integer[]> prefixArrayList) {
    boolean isPalindrome = false;
    Integer[] prefixArrayLeft = prefixArrayList.get(left);
    Integer[] prefixArrayRight = prefixArrayList.get(right);
    int count = 0;
    for(int i=0; i<26; i++){
      if((prefixArrayRight[i] - prefixArrayLeft[i]) % 2 != 0) {
        count++;
      }
    }
    isPalindrome = (count <= 1);
    return isPalindrome;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Get number of test cases in input
    int testCaseCount = scanner.nextInt();
    // Iterate through test cases
    for (int tc = 1; tc <= testCaseCount; ++tc) {
      // Get number of blocks & questions for this test case
      int numberOfBlocks = scanner.nextInt();
      int numberOfQuestions = scanner.nextInt();

      // Read consecutive block characters as a single string
      String blockString = scanner.next();
      // Create array of characters for each block, starting with index 1
      char[] blocks = new char[numberOfBlocks + 1];
      Integer[] prefixArray = new Integer[26];
      for(int j=0; j<26; j++){
        prefixArray[j] = 0;
      }
      List<Integer[]> prefixArrayList = new ArrayList<>();
      prefixArrayList.add(prefixArray);
      for (int i = 0; i < numberOfBlocks; ++i) {
        blocks[i + 1] = blockString.charAt(i);
        int alphabetNo = (int) blocks[i + 1] - (int) 'A';
        Integer[] prefixArrayTemp = new Integer[26];
        for(int j=0; j<26; j++){
          prefixArrayTemp[j] = prefixArrayList.get(i)[j];
        }
        prefixArrayTemp[alphabetNo]++;
        prefixArrayList.add(prefixArrayTemp);
      }
      int palindromeCount = 0;
      // Iterate through questions for this test case
      for (int i = 0; i < numberOfQuestions; ++i) {
        // Get left-index and right-index (inclusive) for this question
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        // Create a copy of blocks[] array so that canFormPalindrome()
        // can safely modify it without affecting other questions
        char[] blockCopy = Arrays.copyOf(blocks, blocks.length);
        // Increment count if this question's sub-array can form a palindrome
        if (canFormPalindrome(blockCopy, left, right, prefixArrayList)) {
          ++palindromeCount;
        }
      }
      // Print results
      System.out.println("Case #" + tc + ": " + palindromeCount);
    }
  }
}
