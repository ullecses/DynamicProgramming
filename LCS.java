import java.util.ArrayList;
import java.util.Scanner;
public class LCS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array1 = new int[n];
        int[] array2 = new int[n];
        ArrayList path1 = new ArrayList<>();
        ArrayList path2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            array1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            array2[i] = in.nextInt();
        }
        int [][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (array1[i - 1] == array2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int i = n, j = n;
        while (i > 0 && j > 0) {
            if (array1[i- 1] == array2[j -1]) {
                path1.add(i - 1);
                path2.add(j - 1);
                i--;
                j--;
            }
            else {
                if (dp[i][j - 1] == dp[i][j]) {
                    j--;
                }
                else i--;
            }

        }
        int size = path1.size();
        System.out.println(size);
        for (int l = path1.size() - 1; l >= 0; l--) {
            System.out.print(path1.get(l) + " ");
        }
        System.out.println();
        for (int l = size - 1; l >= 0; l--) {
            System.out.print(path2.get(l) + " ");
        }
    }
}
