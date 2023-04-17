package codejam2023.roundB;

import java.util.Scanner;

public class CollectingPancakes {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++){
            String line = in.nextLine();
            int N = Integer.parseInt(line);
            int A[] = new int[N+2];
            line = in.nextLine();
            String words[] = line.split(" ");
            for(int i=1; i<=N; i++){
                A[i] = Integer.parseInt(words[i-1]);
            }
            line = in.nextLine();
            words = line.split(" ");
            int La = Integer.parseInt(words[0]);
            int Ra = Integer.parseInt(words[1]);
            int Lb = Integer.parseInt(words[2]);
            int Rb = Integer.parseInt(words[3]);
            long result = maximizeAlicePancakes(A, La, Ra, Lb, Rb, N);
            sb.append("Case #" + t +": "+result+"\n");
        }
        System.out.println(sb.toString());
        in.close();
    }

    static long maximizeAlicePancakes(int[] A, int La, int Ra, int Lb, int Rb, int N){
        long[] leftSideRunningSum = new long[N+2];
        long[] rightSideRunningSum = new long[N+2];
        long[] bothSideRunningSum = new long[N+2];
        for(int i=1; i<=N; i++){
            leftSideRunningSum[i] = leftSideRunningSum[i-1]+A[i];
        }
        for(int i=N; i>=1; i--){
            rightSideRunningSum[i] = rightSideRunningSum[i+1]+A[i];
            bothSideRunningSum[i] = leftSideRunningSum[i]+rightSideRunningSum[i];
        }
        int maxIndexForAlice = La;
        for(int i=La+1; i<=Ra; i++){
            if(bothSideRunningSum[maxIndexForAlice] < bothSideRunningSum[i]){
                maxIndexForAlice = i;
            }
        }
        int maxIndexForBob = 0;
        for(int i=Lb; i<=Rb; i++){
            if(i==maxIndexForAlice) continue;
            if(bothSideRunningSum[maxIndexForBob] < bothSideRunningSum[i]){
                maxIndexForBob = i;
            }
        }
        if(maxIndexForAlice < maxIndexForBob) {
            int midDiff = (maxIndexForBob - maxIndexForAlice) / 2;
            maxIndexForAlice += midDiff;
            return leftSideRunningSum[maxIndexForAlice];
        }
        else {
            int midDiff = (maxIndexForAlice - maxIndexForBob) / 2;
            maxIndexForAlice -= midDiff;
            return rightSideRunningSum[maxIndexForAlice];
        }
    }
}
