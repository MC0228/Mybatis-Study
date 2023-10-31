import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            int[] a = new int[10001];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            Arrays.sort(a, 0, n);
            System.out.println(a[(n - 1) / 2]);
        }
    }
}
