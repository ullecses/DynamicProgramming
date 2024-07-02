import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StringConversion {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        int x = in.nextInt(); //удаление
        int y = in.nextInt(); //вставка
        int z = in.nextInt(); //замена
        String strA = in.next();
        String strB = in.next();

        int [][] dp = new int[strA.length() + 1][strB.length() + 1];
        for (int i = 0; i <= strA.length(); i++) {
            dp[i][0] = i * x;
        }

        for (int j = 0; j <= strB.length(); j++) {
            dp[0][j] = j * y;
        }
        for (int i = 1; i <= strA.length(); i++) {
            for (int j = 1; j <= strB.length(); j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + x,
                Math.min(dp[i][j - 1] + y, dp[i - 1][j - 1] + ((strA.charAt(i - 1) == strB.charAt(j - 1)) ? 0 : 1) * z));
            }
        }

        out.println(dp[strA.length()][strB.length()]);
        out.flush();
    }
}
