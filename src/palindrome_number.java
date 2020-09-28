package src;

//#9 easy
//coding time: 90min
class palindrome_number { 
    public static void main(String[] args) {
        System.out.println(leetcodeAns(12000000));
    }

    public static boolean isPalindrome(int x){
        if (x < 0) return false;
        if (x == 0) return true;

        //calculate digits
        float tempX = x;
        int digits = 1;
        while ( tempX/10 >= 1){
            digits ++;
            tempX /= 10;
        }

        int[] xStack = new int[digits];

        //check palindrome
        int item;
        int splitDigit = (int) ( (digits%2 == 0) ? (digits/2)-1 : Math.ceil(digits/2));
        int stackCounter = (int) ( (digits%2 == 0) ? splitDigit: splitDigit-1);

        for (int i=0; i<digits; i++){
            item = (int) x % 10;

            if (i <= splitDigit){
                xStack[i] = item;
                System.out.println(xStack[i]);
            } else {
                if (item == xStack[stackCounter]){
                    stackCounter --;
                } else {
                    return false;
                }
            }
            
            x /= 10;
        }

        return true;
    }

    public static boolean leetcodeAns(int x){ 
        int revertedNumber = 0;
        while (x > revertedNumber){
        	revertedNumber = (revertedNumber*10) + (x % 10);
            x = x/10;
            System.out.println(x);
            System.out.println(revertedNumber);
        }
        
        //x maybe odd, so have to divide 10 one more time 
        return x == revertedNumber || x == revertedNumber/10;
    }
}