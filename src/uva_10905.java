package src;
//Children's Game
//coding time: 60 mins

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//GPE Problem

import java.util.Scanner;

class uva_10905 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (input.hasNextLine()){
            String len = input.nextLine().trim();
            if (len.equals("0")) break;

            String[] in = input.nextLine().trim().split(" ");
            List<String> src = Arrays.asList(in); 

            Collections.sort(src, new CustomComparator());
            for(String data : src){
                System.out.print(data);
            }
            System.out.println();
        }

        input.close();
        
    }
}

class CustomComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) { //source:[1,2] -->mapping to -->[o2, o1]
        BigInteger i1 = new BigInteger(o1+o2); 
        BigInteger i2 = new BigInteger(o2+o1); 
        return -i1.compareTo(i2); 
    }
}