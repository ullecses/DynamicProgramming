import java.util.ArrayList;
import java.util.Scanner;

public class FrogPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> path = new ArrayList<>();
        int pathSize;
        int n = in.nextInt();

        int[] mosquitoes = new int[n];
        int[] eaten = new int[n];
        int[] prevPosition = new int[n];

        for (int i = 0; i < n; i++) {
            mosquitoes[i] = in.nextInt();
        }
        eaten[0] = mosquitoes[0];
        if (n == 1) {
            System.out.println(eaten[0]);
            System.out.println(1);
            return;
        }
        eaten[1] = Integer.MIN_VALUE;
        if (n == 2) {
            System.out.println(-1);
            return;
        }
        eaten[2] = eaten[0] + mosquitoes[2];
        prevPosition[0] = -1;
        prevPosition[1] = -1;
        prevPosition[2] = 0;

        for (int i = 3; i < n; i++) {
            if (eaten[i - 3] >= eaten[i - 2]) {
                eaten[i] = eaten[i - 3] + mosquitoes[i];
                prevPosition[i] = i - 3;
            } else {
                eaten[i] = eaten[i - 2] + mosquitoes[i];
                prevPosition[i] = i - 2;
            }
        }

        if (eaten[n - 1] <= 0) {
            System.out.println(-1);
        } else {
            int currPosition = n - 1;
            while (currPosition >= 0) {
                path.add(currPosition);
                currPosition = prevPosition[currPosition];
            }
            pathSize = path.size();
            System.out.println(eaten[n - 1]);
            for (int i = pathSize - 1; i >= 0; i--) {
                System.out.print((path.get(i) + 1) + " ");
            }
        }
    }
}
