package src;

import java.util.ArrayList;

//#20 easy
//coding time: 30min
class valid_parentheses{
    public static void main(String[] args) {
        String s = "]]((";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        ArrayList<Character> stk = new ArrayList<>();

        for (int i=0; i<s.length(); i++){
            char currentChr = s.charAt(i);
            char popChr;
 
            if (currentChr == '(' || currentChr == '{' || currentChr == '['){
                stk.add(currentChr);
            } else {
                if ( stk.isEmpty() ) return false;
                popChr = stk.remove( stk.size()-1 );

                switch (currentChr) {            
                    case ')':
                        if (popChr != '(') return false;
                        break;
                    case '}':
                        if (popChr != '{') return false;
                        break;
                    case ']':
                        if (popChr != '[')return false;
                        break;
                    default:
                        break;
                }
            } 
        }
        return stk.isEmpty();
    }
}