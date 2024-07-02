import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class MatrixMultiplication {
    public static int [][] dp;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        int n = in.nextInt();
        String temp;
        int[] matrixSizes = new int[n + 1];
        for (int i = 0; i < n - 1; i++){
            matrixSizes[i] = in.nextInt();
            temp = in.next();
        }
        matrixSizes[n - 1] = in.nextInt();
        matrixSizes[n] = in.nextInt();

        out.println(findMinOperations(matrixSizes));
        out.flush();
    }

    public static int findMinOperations(int[] sizes) {
        int n = sizes.length - 1;
        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + sizes[i] * sizes[k + 1] * sizes[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }
}
