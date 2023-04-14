package codejam2022.round.qualification;

import java.util.*;

public class PunchedCardsSolution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++){
            String line = in.nextLine();
            String words[] = line.split(" ");
            int R = Integer.parseInt(words[0]);
            int C = Integer.parseInt(words[1]);
            String result = drawPunchCard(R,C);
            sb.append("Case #" + t +": \n"+result);
        }
        System.out.println(sb.toString());
        in.close();
    }


    private static String drawPunchCard(int R, int C){
        StringBuilder sb = new StringBuilder();

        StringBuilder openingLine = new StringBuilder("..+");
        StringBuilder closingLine = new StringBuilder("+-+");
        StringBuilder dataLine = new StringBuilder("..|");
        for(int c=1; c<C; c++){
            openingLine.append("-+");
            closingLine.append("-+");
            dataLine.append(".|");
        }
        sb.append(openingLine.toString()+"\n");
        sb.append(dataLine.toString()+"\n");
        sb.append(closingLine.toString()+"\n");

        for(int r=1; r<R; r++){
            closingLine = new StringBuilder("+");
            dataLine = new StringBuilder("|");
            for(int c=0; c<C; c++){
                closingLine.append("-+");
                dataLine.append(".|");
            }
            sb.append(dataLine.toString()+"\n");
            sb.append(closingLine.toString()+"\n");
        }
        return sb.toString();
    }
}
