package leetcode;
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String line[] = new String[n];
        int m[] = new int[] {-1, -1};
        List<int[]> vList = new ArrayList<>();
        for(int i=0; i<n; i++){
        	line[i] = scanner.nextLine();
        	line[i] = line[i].replace(" ", "XX");
            for(int j=0; j<10; j++){
            	if(line[i].charAt(j) == 'V'){
                	vList.add(new int[] {i, j});
                }
            	else if(line[i].charAt(j) == 'M'){
                    m = new int [] {i, j};
                }
            }            
        } 
      
        int min = 500;
        for(int[] v: vList) {
        	int dr = Math.abs(m[0]-v[0]);
        	int dc = Math.abs(m[1] - v[1]);
        	if(dc>0) {
        		dc--;
        	}
        	min = (dr + dc<min) ? dr + dc : min;
        }
        System.out.println(min);
        scanner.close();
   }
   
    
}
