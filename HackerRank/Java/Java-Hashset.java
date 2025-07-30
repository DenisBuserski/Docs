import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        HashSet<String> pairs = new HashSet<>(n);

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String first = input[0];
            String second = input[1];
            pairs.add("(" + first + ", " + second + ")");
            System.out.println(pairs.size());
        }
    }
}
