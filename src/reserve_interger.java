package src;

//#14 easy
//coding time: 120min
class reserve_interger { 
    public static void main(String[] args) {
        System.out.println(reverse(-1463847412));
    }

    public static int reverse(int x) {
        int ans = 0;
        while (x != 0){
            int pop = x%10;
            x /= 10;

            System.out.println(pop);
            if (ans > Integer.MAX_VALUE/10 || ans == Integer.MAX_VALUE/10 && pop > 7) return 0;
            if (ans < Integer.MIN_VALUE/10 || ans == Integer.MIN_VALUE/10 && pop < -8) return 0;
            ans *= 10;
            ans += pop;
        }
        return ans;
    }
}