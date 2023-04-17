package codejam2023.roundA;

import java.util.*;

public class RainbowSort {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        StringBuilder resultSB = new StringBuilder();
        for(int t=1;t<=T;t++){
            String line = in.nextLine();
            int N = Integer.parseInt(line);
            line = in.nextLine();
            String words[] = line.split(" ");
            Set<Integer> list = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            int val = Integer.parseInt(words[0]);
            list.add(val);
            sb.append(val);
            String result = "";
            int lastVal = val;
            for(int i=1; i<words.length; i++){
                val = Integer.parseInt(words[i]);
                if(lastVal == val){
                    continue;
                }
                else if(list.contains(val)){
                    result = "IMPOSSIBLE";
                    break;
                }
                else {
                    lastVal = val;
                    list.add(val);
                    sb.append(" "+val);
                }
            }
            if(!result.equals("IMPOSSIBLE")){
                result = sb.toString();
            }
            resultSB.append("Case #" + t +": "+result+"\n");
        }
        System.out.println(resultSB.toString());
        in.close();
    }
}
