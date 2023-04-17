package codejam2023.roundA;

import java.util.Scanner;

public class AsciiArt {

    public static void main(String[] args) throws Exception {
        /*
        char ch = findAsciiArt(53);
        System.out.println(53+":"+ch);


        for(int i=1; i<100; i++){
            ch = findAsciiArt(i);
            System.out.println(i+":"+ch);
        }


        */
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++){
            String line = in.nextLine();
            long N = Long.parseLong(line);
            char result = findAsciiArt(N);
            sb.append("Case #" + t +":"+result+"\n");
        }
        System.out.println(sb.toString());
        in.close();


    }

    static char findAsciiArt(long N){
        long r = (N-1) / 26;
        long reminder = (N-1) % 26;
        double d = Math.sqrt(2*r);
        long n = (long) Math.ceil(d);
        while(n * (n+1) > 2*r) {
            n--;
        }
        long leftSideSet = n * (n+1) / 2;
        long currentSetIndex = (N-1) - (leftSideSet * 26);
        int set = (int) (currentSetIndex / (n+1));
        int rem = (int) (currentSetIndex % (n+1));
        char ch = (char)((int)'A'+set);
        return ch;
    }

}
