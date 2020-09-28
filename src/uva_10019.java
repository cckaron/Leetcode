package src;
import java.util.Scanner;
//3
//265
//111
//1234
public class uva_10019{
    public static void main(String[] args) {
        System.out.println(265/2);
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        
        for (int i=0; i< Integer.parseInt(s); i++){
            String source = input.nextLine();
            String bin = Integer.toBinaryString(Integer.valueOf(source));
            String hex = Integer.toBinaryString(Integer.valueOf(source, 16));
            
            int binCounter = 0;
            for (int j=0; j<bin.length(); j++){
                if (bin.charAt(j) == '1'){
                    binCounter ++;
                }
            }

            int hexCounter = 0;
            for (int j=0; j<hex.length(); j++){
                if (hex.charAt(j) == '1'){
                    hexCounter ++;
                }
            }

            System.out.println(binCounter+" "+hexCounter);
        }

        input.close();
    }

    //結果自己手刻了一個 binary 轉換
    public static String toBinary(int src, int carry){
        StringBuilder s = new StringBuilder();
        double accumulator;
        int expoAccumulator;
        int currentExponential = -1;
        int lastExponential = -1;
        
        while (src != 0){
            accumulator = 1;
            expoAccumulator = 0;

            while (accumulator*carry < src){
                accumulator *= carry;
                expoAccumulator += 1;
            }

            src -= accumulator;
            currentExponential = expoAccumulator;
            if (lastExponential != -1){
                for (int i=0; i<lastExponential-currentExponential-1; i++){
                    s.append(0);
                }
            }
            s.append(1);
            lastExponential = currentExponential;
        }
        
        return s.toString();
    }
}