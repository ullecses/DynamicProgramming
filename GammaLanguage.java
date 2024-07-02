import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class GammaLanguage {
    public static ArrayList <Number> nums = new ArrayList<>();
    public static ArrayList <Number> numRes = new ArrayList<>();
    public static int n, m;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

        n = in.nextInt();
        m = in.nextInt();

        for (int i = 0; i < n; i++) {
             nums.add(new Number(in.nextInt(), i, -1));
        }
        for (int i = 0; i < m; i++) {
            nums.add(new Number(in.nextInt(), -1, i));
        }

        Comparator<Number> comparator = (num1, num2) -> Integer.compare(num1.num, num2.num);
        Collections.sort(nums, comparator);
        int i = 0, j;
        Number current, next;
        while (i < nums.size()) {
            current = nums.get(i);
            j = i + 1;

            if (j < nums.size() && nums.get(j).num == current.num) {
                next = nums.get(j);
                numRes.add(new Number(current.num, current.index1, next.index2));
                i = j + 1; // Пропускаем следующий элемент, так как он уже был объединен
            } else {
                i++;
            }
        }
        Comparator<Number> comparator2 = (num1, num2) -> Integer.compare(num1.index1, num2.index1);
        Collections.sort(numRes, comparator2);
        int[] tails = new int[numRes.size()];
        int size = 0, x;
        for (int z = 0; z < numRes.size(); z++) {
            x = numRes.get(z).index2;
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
class Number {
    public int num;
    public int index1;
    public int index2;
    public Number(int num, int index1, int index2) {
        this.num = num;
        this.index1 = index1;
        this.index2 = index2;
    }
}