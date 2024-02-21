

public class IsSubsequence {
    public static void main(String[] args) {
        String s="abc";
        String t="ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
    static boolean isSubsequence(String s,String t){
        int i = 0, j = 0;

        // Iterate through both strings
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        // If we've reached the end of s, it is a subsequence of the
        return i == s.length();
    }
}

