import java.io.*;

public class DepthMeasure {

    public static void main(String[] args) throws IOException {
        File file = new File("./src/test1.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        int n = 12;
        int count = 0;
        String st;
        int[] b = new int[n];
        BitTree mainTree = new BitTree();

        int power = (int) Math.pow(2, n-1);
        while ((st = br.readLine()) != null) {
            String[] str = st.split("");
            BitTree tempTree = mainTree;
            for(int i=0; i<n; i++) {
                int bit = Integer.parseInt(str[i]);
                if(tempTree.entries[bit] == null){
                    tempTree.entries[bit] = new BitTree();
                }
                tempTree.entries[bit].count++;
                tempTree = tempTree.entries[bit];
                b[i] += bit;
            }
            count++;
        }
        int o2 = findOxygenGeneratorRating(mainTree, power);
        System.out.println("\n"+o2);
        int co2 = findCO2ScrubberRating(mainTree, power);
        System.out.println("\n"+co2);

        System.out.println(o2 * co2);
    }

    public static int findOxygenGeneratorRating(BitTree bitTree, int power){
        if(bitTree.entries[0] == null && bitTree.entries[1] == null){
            return power;
        }
        int value = 0;
        if (bitTree.entries[1] == null || bitTree.entries[0].count>bitTree.entries[1].count) {
            System.out.print(0);
            value = findOxygenGeneratorRating(bitTree.entries[0], power/2);
        }
        else {
            System.out.print(1);
            value = findOxygenGeneratorRating(bitTree.entries[1], power/2);
            value +=  power;
        }
        return value;
    }

    public static int findCO2ScrubberRating(BitTree bitTree, int power){
        int value = 0;
        if(bitTree.entries[0] == null && bitTree.entries[1] == null){
            return power;
        }
        else if(bitTree.entries[0] == null){
            System.out.print(1);
            value = findCO2ScrubberRating(bitTree.entries[1], power/2);
            value +=  power;
        }
        else if(bitTree.entries[1] == null){
            System.out.print(0);
            value = findCO2ScrubberRating(bitTree.entries[0], power / 2);
        }
        else if (bitTree.entries[0].count<=bitTree.entries[1].count) {
            System.out.print(0);
            value = findCO2ScrubberRating(bitTree.entries[0], power / 2);
        }
        else {
            System.out.print(1);
            value = findCO2ScrubberRating(bitTree.entries[1], power/2);
            value +=  power;
        }
        return value;
    }
}

class BitTree {
    int count;
    BitTree[] entries = new BitTree[2];
}