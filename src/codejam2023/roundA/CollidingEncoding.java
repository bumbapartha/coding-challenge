package codejam2023.roundA;

import java.util.HashSet;
import java.util.Scanner;

public class CollidingEncoding {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        StringBuilder resultSB = new StringBuilder();
        for(int t=1;t<=T;t++){
            String line = in.nextLine();
            String words[] = line.split(" ");
            int alpha[] = new int[26];
            for(int i=0; i<26; i++){
                alpha[i] = Integer.parseInt(words[i]);
            }
            line = in.nextLine();
            int N = Integer.parseInt(line);
            HashSet<String> set = new HashSet<>();
            String result = "NO";
            for(int i=0; i<N; i++){
                String word = in.nextLine();
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<word.length(); j++){
                    int index = word.charAt(j) - 'A';
                    int value = alpha[index];
                    sb.append(value+"");
                }
                if(set.add(sb.toString())){

                }
                else {
                    result = "YES";
                    break;
                }
                if(result.equals("YES")) {
                    break;
                }
            }
            resultSB.append("Case #" + t +": "+result+"\n");
        }
        System.out.println(resultSB.toString());
        in.close();
    }
}
