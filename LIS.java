import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LIS {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        int size = 0;
        int[] tails = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int x = array[i];
            int s = 0, q = size;
            while (s != q) {
                int m = (s + q) / 2;
                if (tails[m] < x)
                    s = m + 1;
                else
                    q = m;
            }
            tails[s] = x;
            if (s == size) ++size;
        }
        out.println(size);
        out.flush();
    }
}
