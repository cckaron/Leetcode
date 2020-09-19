class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        boolean negative = false;
        long lx;
        if (x == -2147483648) {
            negative = true;
            lx = 2147483648L;
        } else if (x < 0){
            negative = true;
            lx = -x;
        } else {
            lx = x;
        }
        
        String src = Long.toString(lx);
        int digits = src.length();

        // only one digit, return it.
        if (digits == 1) {
            return x;
        }

        int maxDigit = digits - 1;

        boolean hasMaxDigit = false;

        while (!hasMaxDigit && maxDigit >= 1) {
            char leftD = src.charAt(maxDigit - 1);
            char rightD = src.charAt(maxDigit);
            if (leftD != '0' && rightD == '0') {
                hasMaxDigit = true;
                maxDigit--;
            } else if (leftD != '0' && rightD != '0') {
                hasMaxDigit = true;
            } else if (leftD == '0' && rightD != '0') {
                hasMaxDigit = true;
            } else if (leftD == '0' && rightD == '0') {
                maxDigit--;
            }
        }

        StringBuilder outStrBdr = new StringBuilder(src.substring(0, maxDigit + 1));
        String outStr = outStrBdr.reverse().toString();

        long out = Long.parseLong(outStr);

        if (Math.abs(out) > Integer.MAX_VALUE){
            return 0;
        } else {
            return negative ? (int) -out: (int) out;
        }
    }
}