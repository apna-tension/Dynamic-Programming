public class LCS_recursive {
    public static void main(String args[]) {
        String str1 = "abcdefg";
        String str2 = "abddlfeg";
        System.out.println(recursive(str1, str2, str1.length(), str2.length()));

    }
    private static int recursive(String str1, String str2, int n, int m) {
        if (m == 0 || n == 0) return 0;
        if (str1.charAt(n-1) == str2.charAt(m-1)) {
            return 1 + recursive(str1, str2, n-1, m-1);
        } else {
            return Math.max(recursive(str1, str2, n-1, m) , recursive(str1, str2, n, m-1));
        }
    }
}