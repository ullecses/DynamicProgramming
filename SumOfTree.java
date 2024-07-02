import java.io.*;
import java.util.*;

public class SumOfTree {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        long sum = 0;
        Set<Integer> hashSet = new HashSet<>();

        while (in.hasNextInt()){
            hashSet.add(in.nextInt());
        }
        for (int i : hashSet) {
            sum += i;
        }
        out.println(sum);
        out.flush();
    }
}