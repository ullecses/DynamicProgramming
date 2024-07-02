import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Palindrome {
    public static StringBuilder sb;
    public static boolean diag = false;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        String str = new String(in.nextLine());
        StringBuilder partPalindrom = new StringBuilder(longestPalindromeSub(str));
        StringBuilder palindrom = new StringBuilder(partPalindrom);
        if (diag == true) palindrom = palindrom.append(partPalindrom.reverse());
        else palindrom = palindrom.append(partPalindrom.reverse().deleteCharAt(0));
        out.println(palindrom.length());
        out.println(palindrom);
        out.flush();
    }
    public static String longestPalindromeSub(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int n = s.length();
        int[][] dp = new int[n][n];

        // Заполняем диагональные элементы
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                sb.append(s.charAt(i));
                if (i + 1 == j) diag = true;
                i++;
                j--;
            } else if (dp[i][j] == dp[i + 1][j]) {
                i++;
            } else {
                j--;
            }
        }

        return sb.toString();
    }
}
