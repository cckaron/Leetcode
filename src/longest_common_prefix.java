package src;

//#14 easy
//coding time: 40min
public class longest_common_prefix { 
    public static void main(String[] args) {
        String[] strs = {"flower", "flowing", "flask"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(leetcodeAns(strs));
        System.out.println(horizontalAns(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        int shortestStrLen = strs[0].length();
        
        for (int i=1; i<strs.length; i++){
            if (strs[i].length() == 0) return "";
            if (strs[i].length() < shortestStrLen){
                shortestStrLen = strs[i].length();
            }
        }
            
        for (int j=0; j<shortestStrLen; j++){
            char temp = strs[0].charAt(j);
            for (int i=1; i< strs.length; i++){
                if (strs[i].charAt(j) != temp) {
                    return strs[i].substring(0, j);
                }
            }
        }
        
        return strs[0].substring(0, shortestStrLen);
    }

    public static String leetcodeAns(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
            
        for (int j=0; j<strs[0].length(); j++){
            char temp = strs[0].charAt(j);
            for (int i=1; i< strs.length; i++){
                if (j == strs[i].length() || strs[i].charAt(j) != temp) {
                    return strs[i].substring(0, j);
                }
            }
        }
        
        return strs[0];
    }

    public static String horizontalAns(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }        
        return prefix;
    }
}
