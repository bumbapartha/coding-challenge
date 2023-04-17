package codejam2023.roundA;

import java.util.HashSet;
import java.util.Scanner;

public class Untie {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        StringBuilder resultSB = new StringBuilder();
        for(int t=1;t<=T;t++){
            String line = in.nextLine();
            char[] chars = line.toCharArray();
            int minChange = Integer.MAX_VALUE;
            for(int j=0; j<3; j++) {
                int change = 0;
                for (int i = j; i < chars.length+j; i += 2) {
                    char ch1 = chars[(chars.length + i - 1) % chars.length];
                    char ch2 = chars[i % chars.length];
                    char ch3 = chars[(i + 1) % chars.length];

                    if (ch1 != ch2 && ch2 != ch3) {

                    } else {
                        change++;
                    }
                }
                if(change < minChange){
                    minChange = change;
                }
            }
            String result = "";
            resultSB.append("Case #" + t +": "+minChange+"\n");
        }
        System.out.println(resultSB.toString());
        in.close();
    }
}
