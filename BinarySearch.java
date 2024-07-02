import java.io.*;
import java.util.*;

public class BinarySearch {
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        int k = in.nextInt();
        int[] queries = new int[k];

        for (int i = 0; i < k; i++) {
            queries[i] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            System.out.println(binarySearch(array, queries[i]));
        }
    }
    public static String binarySearch(int[] arr, int x) {
        int[] result = new int[3]; // Результирующий массив
        int left = 0;
        int right = n - 1;
        int firstGreaterIndex = n; // Индекс первого элемента, большего x

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                firstGreaterIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (firstGreaterIndex < n && arr[firstGreaterIndex] == x) {
            result[0] = 1;
        } else {
            result[0] = 0;
        }

        result[1] = firstGreaterIndex;

        left = 0;
        right = n - 1;
        int firstLargerIndex = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > x) {
                firstLargerIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        result[2] = firstLargerIndex;

        return result[0] + " " + result[1] + " " + result[2];
    }
}
