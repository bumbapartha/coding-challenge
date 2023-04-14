package codejam2022.round.qualification;

import java.util.Scanner;

public class Solution3DPrinting {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++){

            String line = in.nextLine();
            String words[] = line.split(" ");
            int C = Integer.parseInt(words[0]);
            int M = Integer.parseInt(words[1]);
            int Y = Integer.parseInt(words[2]);
            int K = Integer.parseInt(words[3]);
            for(int p=1; p<3; p++) {
                line = in.nextLine();
                words = line.split(" ");
                C = Math.min(Integer.parseInt(words[0]), C);
                M = Math.min(Integer.parseInt(words[1]), M);
                Y = Math.min(Integer.parseInt(words[2]), Y);
                K = Math.min(Integer.parseInt(words[3]), K);
            }
            String result = "";
            if(C+M+Y+K>=1000000){
                int pending = 1000000;
                if(pending > 0){
                    int contribute = (C < pending) ? C : pending;
                    pending -= contribute;
                    result += " "+contribute;
                }
                if(pending > 0){
                    int contribute = (M < pending) ? M : pending;
                    pending -= contribute;
                    result += " "+contribute;
                }
                else {
                    result += " "+0;
                }
                if(pending > 0){
                    int contribute = (Y < pending) ? Y : pending;
                    pending -= contribute;
                    result += " "+contribute;
                }
                else {
                    result += " "+0;
                }
                if(pending > 0){
                    int contribute = (K < pending) ? K : pending;
                    pending -= contribute;
                    result += " "+contribute;
                }
                else {
                    result += " "+0;
                }
            }
            else {
                result=" IMPOSSIBLE";
            }
            sb.append("Case #" + t +":"+result+"\n");
        }
        System.out.println(sb.toString());
        in.close();
    }
}
